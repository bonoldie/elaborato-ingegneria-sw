package elaborato.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class PatenteDAO implements IPatenteDAO {

	public PatenteDAO() {
	}

	public List<Patente> getAllPatente() {
		List<Patente> patenti = new ArrayList<>();
		
		ResultSet rs_patente;
		try {
			Statement st_patente = Database.getDatabase().getConnection().createStatement();	
			
			rs_patente = st_patente.executeQuery("SELECT * FROM patente ");
			
			while(rs_patente.next()) {
				patenti.add(
						new Patente(
								rs_patente.getInt("id_patente"),
								rs_patente.getString("nome_patente")
								)
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return patenti;
	}

	@Override
	public Patente getPatente(int id_patente) {
		// TODO Auto-generated method stub
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
