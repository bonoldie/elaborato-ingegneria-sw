package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILavoro_svoltoDAO {
	public List<Lavoro_svolto> getAllLavoro_svolto() throws SQLException;

	public Lavoro_svolto getLavoro_svolto(int id_lavoro_svolto);

	public void insertLavoro_svolto(Lavoro_svolto lavoro_svolto) throws SQLException;
	
	public void updateLavoro_svolto(Lavoro_svolto lavoro_svolto) throws SQLException;

	public void deleteLavoro_svolto(Lavoro_svolto lavoro_svolto) throws SQLException;
}
