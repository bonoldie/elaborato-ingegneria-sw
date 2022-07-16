package elaborato.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecializzazioneDAO implements ISpecializzazioneDAO {
	
	private static List<Specializzazione> specializzazioni = Arrays.asList(new Specializzazione(0, "bagnino")
	                                              			,new Specializzazione(1, "barman")
	                                            			,new Specializzazione(2, "istruttore di nuoto")
	                                            			,new Specializzazione(3, "viticultore")
	                                            			,new Specializzazione(4, "floricultore"));
	
	public SpecializzazioneDAO() {
		
	}
	
	@Override
	public List<Specializzazione> getAllSpecializzazione() throws SQLException {
		return specializzazioni;
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
