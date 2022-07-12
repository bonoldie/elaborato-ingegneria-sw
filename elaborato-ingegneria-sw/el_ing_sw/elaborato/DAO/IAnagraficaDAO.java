package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IAnagraficaDAO {
	public List<Anagrafica> getAllAnagrafica();

	public Anagrafica getAnagrafica(int id_anagrafica);

	public void updateAnagrafica(Anagrafica anagrafica);

	public void insertAnagrafica(Anagrafica anagrafica) throws SQLException;
	
	public void deleteAnagrafica(Anagrafica anagrafica);
}
