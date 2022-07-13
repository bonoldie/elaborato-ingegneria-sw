package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDisponibilitaDAO {
	public List<Disponibilita> getAllDisponibilita() throws SQLException;

	public Disponibilita getDisponibilita(int id_disponibilita);

	public void updateDisponibilita(Disponibilita disponibilita);
	
	public void insertDisponibilita(Disponibilita disponibilita) throws SQLException;

	public void deleteDisponibilita(Disponibilita disponibilita);
}
