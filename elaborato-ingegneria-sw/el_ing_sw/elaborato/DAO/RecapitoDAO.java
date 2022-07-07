package elaborato.DAO;

import java.util.ArrayList;
import java.util.List;

public class RecapitoDAO implements IRecapitoDAO {

	public RecapitoDAO() {
	}

	@Override
	public List<Recapito> getAllLingue() {
		// TODO Auto-generated method stub
		List<Recapito> recapiti = new ArrayList<>();
		// Database.getDatabase().getConnection().prepareStatement("");
		return recapiti;
	}

	@Override
	public Lingua getRecapito(int id_recapito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRecapito(Recapito recapito) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRecapito(Recapito recapito) {
		// TODO Auto-generated method stub

	}

}
