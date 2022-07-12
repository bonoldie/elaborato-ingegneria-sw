package elaborato.DAO;

import java.util.List;

public interface IPatenteDAO {
	public List<Patente> getAllPatente();

	public Patente getPatente(int id_patente);

	public void updatePatente(Patente patente);

	public void deletePatente(Patente patente);
}
