package elaborato.DAO;

import java.util.ArrayList;
import java.util.List;

public class PatenteDAO implements IPatenteDAO {
	
	public PatenteDAO() {
	}

	public List<Patente> getAllPatente() {
		List<Patente> patenti = new ArrayList<>();
		// dati da db
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
