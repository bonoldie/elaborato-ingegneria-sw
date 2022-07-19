package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class Anagrafiche_LavoratoriDAO implements IAnagrafiche_LavoratoriDAO {
	
	public Anagrafiche_LavoratoriDAO() {
		// TODO Auto-generated method stub
				
	}
	
	@Override
	public List<Anagrafiche_Lavoratori> getAllAnagrafiche_Lavoratori() throws SQLException {
		List<Anagrafiche_Lavoratori> anag_lav = new ArrayList<>();
		
		Statement st_anag_lav = Database.getDatabase().getConnection().createStatement();
		
		ResultSet r = st_anag_lav.executeQuery("SELECT * FROM anagrafiche_lavoratori;");
		
		
		while(r.next()) {
			anag_lav.add(
					new Anagrafiche_Lavoratori(
							r.getInt("id_lavoratore"),
							r.getInt("id_anagrafica"),
							r.getInt("id_recapito_urgenza"), 
							r.getString("indirizzo"), 
							r.getBoolean("automunito"),
							r.getString("luogo_di_nascita"), 
							r.getDate("data_di_nascita").toLocalDate(), 
							r.getString("nazionalita"),
							r.getString("nome"),
							r.getString("cognome"),
							r.getString("telefono"),
							r.getString("email")
							)
					);
		}
		
		return anag_lav;
	}

	@Override
	public Anagrafiche_Lavoratori getAnagrafiche_Lavoratori(int id_lavoratore) throws SQLException {

		PreparedStatement st_anag_lav = Database.getDatabase().getConnection().prepareStatement("SELECT * FROM anagrafiche_lavoratori WHERE id_lavoratore=? LIMIT 1;");
		st_anag_lav.setInt(1, id_lavoratore);
		
		ResultSet r = st_anag_lav.executeQuery();
		
		
		while(r.next()) {
			return new Anagrafiche_Lavoratori(
							r.getInt("id_lavoratore"),
							r.getInt("id_anagrafica"),
							r.getInt("id_recapito_urgenza"), 
							r.getString("indirizzo"), 
							r.getBoolean("automunito"),
							r.getString("luogo_di_nascita"), 
							r.getDate("data_di_nascita").toLocalDate(), 
							r.getString("nazionalita"),
							r.getString("nome"),
							r.getString("cognome"),
							r.getString("telefono"),
							r.getString("email")
							);
		}
		
		return null;
	}

}
