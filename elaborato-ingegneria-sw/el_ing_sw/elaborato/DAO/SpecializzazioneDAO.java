package elaborato.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import elaborato.DB.Database;

public class SpecializzazioneDAO implements ISpecializzazioneDAO {
	
	/*private static List<Specializzazione> specializzazioni = Arrays.asList(new Specializzazione(0, "bagnino")
	                                              			,new Specializzazione(1, "barman")
	                                            			,new Specializzazione(2, "istruttore di nuoto")
	                                            			,new Specializzazione(3, "viticultore")
	                                            			,new Specializzazione(4, "floricultore"));*/
	
	public SpecializzazioneDAO() {
		
	}
	
	@Override
	public List<Specializzazione> getAllSpecializzazione() throws SQLException {
		
		List<Specializzazione> spec = new ArrayList<>();

		ResultSet rs_spec;

		Statement st_spec = Database.getDatabase().getConnection().createStatement();

		rs_spec = st_spec.executeQuery("SELECT * FROM specializzazione");

		while (rs_spec.next()) {
			spec.add(new Specializzazione(rs_spec.getInt("id_spec"), rs_spec.getString("nome_spec")));
		}
		
		return spec;
	}

	@Override
	public Specializzazione getSpecializzazione(int id_specializzazione) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSpecializzazione(Specializzazione specializzazione) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSpecializzazione(Specializzazione specializzazione) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertSpecializzazione(Specializzazione specializzazione) throws SQLException {
		// TODO Auto-generated method stub

	}

}
