package elaborato.DAO;

import java.util.ArrayList;
import java.util.List;

public class LavoratoreDAO implements ILavoratoreDAO {

	public LavoratoreDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lavoratore> getAllLavoratore() {
		// TODO Auto-generated method stub
		List<Lavoratore> lavoratori= new ArrayList<>();
		// Database.getDatabase().getConnection().prepareStatement("");
		return lavoratori;
	}

	@Override
	public Lavoratore getLavoratore(int id_lavoratore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLavoratore(Lavoratore lavoratore) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLavoratore(Lavoratore lavoratore) {
		// TODO Auto-generated method stub

	}

}
