package elaborato.DAO;

import java.util.List;

public interface ILavoratoreDAO {
	public List<Lavoratore> getAllLavoratore();

	public Lavoratore getLavoratore(int id_lavoratore);

	public void updateLavoratore(Lavoratore lavoratore);

	public void deleteLavoratore(Lavoratore lavoratore);
}
