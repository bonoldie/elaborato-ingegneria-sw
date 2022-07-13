package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class Lavoratore_LinguaDAO implements ILavoratore_LinguaDAO {

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
	public Lavoratore_Lingua getLavoratore_Lingua(int id_lingua) {
		// TODO Auto-generated method stub
		return null;
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
	public void deleteLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua) {
		// TODO Auto-generated method stub

	}

}
