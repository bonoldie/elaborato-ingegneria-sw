package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import elaborato.DB.Database;

public class Lavoratore_PatenteDAO implements ILavoratore_PatenteDAO {

	public Lavoratore_PatenteDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lavoratore_Patente> getAllLavoratore_Patente() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lavoratore_Patente getLavoratore_Patente(int id_lavoratore) {
		// TODO Auto-generated method stub
		return null;
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
	public void deleteLavoratore_Patente(Lavoratore_Patente lavoratore_patente) {
		// TODO Auto-generated method stub

	}

}
