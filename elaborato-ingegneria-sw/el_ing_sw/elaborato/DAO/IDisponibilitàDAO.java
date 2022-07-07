package elaborato.DAO;

import java.util.List;

public interface IDisponibilit‡DAO {
	public List<Disponibilit‡> getAllDisponibilit‡();
	public Disponibilit‡ getDisponibilit‡(int id_disponibilit‡);
	public void updateDisponibilit‡(Disponibilit‡ disponibilit‡);
	public void deleteDisponibilit‡(Disponibilit‡ disponibilit‡);
}
