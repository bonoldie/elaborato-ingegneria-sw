package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IAnagraficaDAO {
	public List<Anagrafica> getAllAnagrafica() throws SQLException;

	public Anagrafica getAnagrafica(int id_anagrafica) throws SQLException;

	public void updateAnagrafica(Anagrafica anagrafica, int id_anagrafica) throws SQLException;

	public void insertAnagrafica(Anagrafica anagrafica) throws SQLException;
	
	public void deleteAnagrafica(Anagrafica anagrafica) throws SQLException;
}
