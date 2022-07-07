package elaborato.DAO;

import java.util.List;

public interface IAnagraficaDAO {
	public List<Anagrafica> getAllAnagrafica();
	public Anagrafica getAnagrafica(int id_anagrafica);
	public void updateAnagrafica(Anagrafica anagrafica);
	public void deleteAnagrafica(Anagrafica anagrafica);
}
