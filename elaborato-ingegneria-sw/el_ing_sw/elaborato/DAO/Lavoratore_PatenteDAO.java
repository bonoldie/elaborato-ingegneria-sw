package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class Lavoratore_PatenteDAO implements ILavoratore_PatenteDAO, ManyToMany<Lavoratore, Patente> {

	public Lavoratore_PatenteDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lavoratore_Patente> getAllLavoratore_Patente() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lavoratore_Patente> getLavoratore_Patente(int id_lavoratore) throws SQLException {
		List<Lavoratore_Patente> lavoratore_patenti = new ArrayList<>();

		ResultSet rs_lavoratore_patenti;

		PreparedStatement pst_patente = Database.getDatabase().getConnection()
				.prepareStatement("SELECT * FROM lavoratore_patente WHERE id_lavoratore=?");
		pst_patente.setInt(1, id_lavoratore);

		rs_lavoratore_patenti = pst_patente.executeQuery();

		while (rs_lavoratore_patenti.next()) {
			lavoratore_patenti.add(new Lavoratore_Patente(rs_lavoratore_patenti.getInt("id_lavoratore"),
					rs_lavoratore_patenti.getInt("id_patente")));
		}

		return lavoratore_patenti;
	}

	@Override
	public void insertLavoratore_Patente(Lavoratore_Patente lavoratore_patente) throws SQLException {
		PreparedStatement pst_lavoratore_patente = Database.getDatabase().getConnection().prepareStatement(
				"INSERT INTO lavoratore_patente(id_lavoratore, id_patente) VALUES (?,?);",
				Statement.RETURN_GENERATED_KEYS);
		pst_lavoratore_patente.setInt(1, lavoratore_patente.getId_lavoratore());
		pst_lavoratore_patente.setInt(2, lavoratore_patente.getId_patente());
		pst_lavoratore_patente.executeUpdate();
	}

	@Override
	public void updateLavoratore_Patente(Lavoratore_Patente lavoratore_patente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLavoratore_Patente(Lavoratore_Patente lavoratore_patente) throws SQLException {
		PreparedStatement pst_lavoratore_patente = Database.getDatabase().getConnection().prepareStatement(
				"DELETE FROM lavoratore_patente WHERE id_lavoratore=? AND id_patente=?;",
				Statement.RETURN_GENERATED_KEYS);
		pst_lavoratore_patente.setInt(1, lavoratore_patente.getId_lavoratore());
		pst_lavoratore_patente.setInt(2, lavoratore_patente.getId_patente());
		pst_lavoratore_patente.execute();

	}

	@Override
	public void sync(Lavoratore pivot, List<Patente> syncArray) throws SQLException {
		List<Lavoratore_Patente> updatedLPs = new ArrayList<>();

		syncArray.forEach(p -> {
			updatedLPs.add(new Lavoratore_Patente(pivot.getId_lavoratore(), p.getId_patente()));
		});

		this.getLavoratore_Patente(pivot.getId_lavoratore()).forEach(lp -> {
			if (!updatedLPs.contains(lp)) {
				try {
					this.deleteLavoratore_Patente(lp);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		updatedLPs.forEach(updatedLP -> {
			try {
				if (!this.getLavoratore_Patente(pivot.getId_lavoratore()).contains(updatedLP)) {
					this.insertLavoratore_Patente(updatedLP);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

}
