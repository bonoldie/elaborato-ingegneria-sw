package elaborato.DAO;

import java.util.List;

public interface IRecapitoDAO {
	public List<Recapito> getAllRecapito();

	public Recapito getRecapito(int id_recapito);

	public void updateRecapito(Recapito recapito);

	public void deleteRecapito(Recapito recapito);
}
