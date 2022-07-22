package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IRecapitoDAO {
	public List<Recapito> getAllRecapito() throws SQLException;

	public Recapito getRecapito(int id_recapito) throws SQLException;

	public void updateRecapito(Recapito recapito) throws SQLException;

	public void deleteRecapito(Recapito recapito);
	
	public void insertRecapito(Recapito recapito) throws SQLException;
}
