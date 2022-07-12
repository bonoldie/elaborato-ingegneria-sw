package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class AnagraficaDAO implements IAnagraficaDAO {

	public AnagraficaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Anagrafica> getAllAnagrafica() {
		List<Anagrafica> anagrafiche = new ArrayList<>();

		ResultSet rs_anagrafica;
		try {
			Statement st_anagrafica = Database.getDatabase().getConnection().createStatement();	
			
			rs_anagrafica = st_anagrafica.executeQuery("SELECT * FROM anagrafica ");
			
			while(rs_anagrafica.next()) {
				anagrafiche.add(
						new Anagrafica(
								rs_anagrafica.getInt("id_anagrafica"),
								rs_anagrafica.getString("luogo_di_nascita"),
								rs_anagrafica.getDate("data_di_nascita").toLocalDate(),
								rs_anagrafica.getString("nazionalita"),
								rs_anagrafica.getString("nome"),
								rs_anagrafica.getString("cognome"),
								rs_anagrafica.getString("telefono"),
								rs_anagrafica.getString("email")
								)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return anagrafiche;
	}

	@Override
	public Anagrafica getAnagrafica(int id_anagrafica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAnagrafica(Anagrafica anagrafica) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAnagrafica(Anagrafica anagrafica) throws SQLException {
		PreparedStatement pst_anagrafica = Database.getDatabase().getConnection().prepareStatement(
				"INSERT INTO Anagrafica(luogo_di_nascita, data_di_nascita, nazionalita, nome, cognome, telefono, email) VALUES (?,?,?,?,?,?,?);");
		pst_anagrafica.setString(1, anagrafica.getLuogo_di_nascita());

		pst_anagrafica.setDate(2, java.sql.Date.valueOf(anagrafica.getData_di_nascita()));
		pst_anagrafica.setString(3, anagrafica.getNazionalita());
		pst_anagrafica.setString(4, anagrafica.getNome());
		pst_anagrafica.setString(5, anagrafica.getCognome());
		pst_anagrafica.setString(6, anagrafica.getTelefono());
		pst_anagrafica.setString(7, anagrafica.getEmail());
		pst_anagrafica.execute();
		
		System.out.println(pst_anagrafica.toString());
	}
	
	@Override
	public void deleteAnagrafica(Anagrafica anagrafica) {
		// TODO Auto-generated method stub

	}

}
