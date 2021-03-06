package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class PatenteDAO implements IPatenteDAO {

	public PatenteDAO() {
	}

	public List<Patente> getAllPatente() throws SQLException {
		List<Patente> patenti = new ArrayList<>();

		ResultSet rs_patente;

		Statement st_patente = Database.getDatabase().getConnection().createStatement();

		rs_patente = st_patente.executeQuery("SELECT * FROM patente ");

		while (rs_patente.next()) {
			patenti.add(new Patente(rs_patente.getInt("id_patente"), rs_patente.getString("nome_patente")));
		}

		return patenti;
	}

	@Override
	public Patente getPatente(int id_patente) throws SQLException {

		ResultSet rs_patente;

		PreparedStatement pst_patente = Database.getDatabase().getConnection().prepareStatement("SELECT * FROM patente WHERE id_patente=? LIMIT 1");
		pst_patente.setInt(1, id_patente);
		
		rs_patente = pst_patente.executeQuery();

		while (rs_patente.next()) {
			return new Patente(rs_patente.getInt("id_patente"), rs_patente.getString("nome_patente"));
		}

		return null;
	}

	@Override
	public void updatePatente(Patente patente) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePatente(Patente patente) {
		// TODO Auto-generated method stub
	}

}
