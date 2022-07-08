package elaborato.DAO;

import java.util.ArrayList;
import java.util.List;

public class LinguaDAO implements ILinguaDAO{

	public LinguaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lingua> getAllLingue() {
		// TODO Auto-generated method stub
		List<Lingua> lingua= new ArrayList<>();
		// Database.getDatabase().getConnection().prepareStatement("");
		return lingua;
	}

	@Override
	public Lingua getLingua(int id_lingua) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLingua(Lingua lingua) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLingua(Lingua lingua) {
		// TODO Auto-generated method stub
		
	}

}
