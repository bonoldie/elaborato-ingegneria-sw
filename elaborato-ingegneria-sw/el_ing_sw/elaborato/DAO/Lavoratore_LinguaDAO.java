package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class Lavoratore_LinguaDAO implements ILavoratore_LinguaDAO, ManyToMany<Lavoratore,Lingua> {

	public Lavoratore_LinguaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lavoratore_Lingua> getAllLavoratore_Lingua() throws SQLException {
		List<Lavoratore_Lingua> lavoratori_lingue = new ArrayList<>();

		ResultSet rs_lavoratori_lingue;

		Statement st_patente = Database.getDatabase().getConnection().createStatement();

		rs_lavoratori_lingue = st_patente.executeQuery("SELECT * FROM lavoratore_lingua ");

		while (rs_lavoratori_lingue.next()) {
			lavoratori_lingue.add(new Lavoratore_Lingua(rs_lavoratori_lingue.getInt("id_lavoratore"), rs_lavoratori_lingue.getInt("id_lingua")));
		}

		return lavoratori_lingue;
	}

	@Override
	public List<Lavoratore_Lingua> getLavoratore_Lingua(int id_lavoratore) throws SQLException {
		List<Lavoratore_Lingua> lavoratore_lingue= new ArrayList<>();

		ResultSet rs_lavoratore_lingue;

		PreparedStatement pst_lingue = Database.getDatabase().getConnection().prepareStatement("SELECT * FROM lavoratore_lingua WHERE id_lavoratore=?");
		pst_lingue.setInt(1, id_lavoratore);

		rs_lavoratore_lingue = pst_lingue.executeQuery();

		while (rs_lavoratore_lingue.next()) {
			lavoratore_lingue.add(new Lavoratore_Lingua(rs_lavoratore_lingue.getInt("id_lavoratore"), rs_lavoratore_lingue.getInt("id_lingua")));
		}

		return lavoratore_lingue; 

	}

	@Override
	public void insertLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua)  throws SQLException{
		PreparedStatement pst_lavoratore_lingua = Database.getDatabase().getConnection().prepareStatement(
				"INSERT INTO lavoratore_lingua(id_lavoratore, id_lingua) VALUES (?,?);",
				Statement.RETURN_GENERATED_KEYS);
		pst_lavoratore_lingua.setInt(1, lavoratore_lingua.getId_lavoratore());
		pst_lavoratore_lingua.setInt(2, lavoratore_lingua.getId_lingua());
		pst_lavoratore_lingua.executeUpdate();

	}
	
	@Override
	public void updateLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua) throws SQLException {
		PreparedStatement pst_lavoratore_lingua = Database.getDatabase().getConnection().prepareStatement(
				"DELETE FROM lavoratore_lingua WHERE id_lavoratore=? AND id_lingua=?;");
		pst_lavoratore_lingua.setInt(1, lavoratore_lingua.getId_lavoratore());
		pst_lavoratore_lingua.setInt(2, lavoratore_lingua.getId_lingua());
		pst_lavoratore_lingua.execute();

	}

	@Override
	public void sync(Lavoratore pivot, List<Lingua> syncArray) throws SQLException {
		List<Lavoratore_Lingua> updatedLLs = new ArrayList<>();

		syncArray.forEach(l -> {
			updatedLLs.add(new Lavoratore_Lingua(pivot.getId_lavoratore(), l.getId_lingua()));
		});

		this.getLavoratore_Lingua(pivot.getId_lavoratore()).forEach(ll -> {
			if (!syncArray.contains(ll)) {
				try {
					this.deleteLavoratore_Lingua(ll);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		updatedLLs.forEach(updatedLP -> {
			try {
				if (!this.getLavoratore_Lingua(pivot.getId_lavoratore()).contains(updatedLP)) {
					this.insertLavoratore_Lingua(updatedLP);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
	}

}
