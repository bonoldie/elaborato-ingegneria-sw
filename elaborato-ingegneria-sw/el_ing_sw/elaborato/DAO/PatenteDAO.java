package elaborato.DAO;

import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class PatenteDAO implements IPatenteDAO {
	
	public PatenteDAO() {
	}

	public List<Patente> getAllPatente() {
		List<Patente> patenti = new ArrayList<>();
		// Database.getDatabase().getConnection().prepareStatement("");
		//ritotno una lista con tutte le colonne della tabella patente
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
