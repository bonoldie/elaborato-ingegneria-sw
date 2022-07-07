package elaborato.DAO;

import java.util.ArrayList;
import java.util.List;

public class AnagraficaDAO implements IAnagraficaDAO {

	public AnagraficaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Anagrafica> getAllLingue() {
		List<Anagrafica> anagrafiche= new ArrayList<>();
		// Database.getDatabase().getConnection().prepareStatement("");
		return anagrafiche;
	}

	@Override
	public Lingua getAnagrafica(int id_anagrafica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAnagrafica(Anagrafica anagrafica) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAnagrafica(Anagrafica anagrafica) {
		// TODO Auto-generated method stub

	}

}
