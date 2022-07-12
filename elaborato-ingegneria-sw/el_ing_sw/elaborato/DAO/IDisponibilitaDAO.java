package elaborato.DAO;

import java.util.List;

public interface IDisponibilitaDAO {
	public List<Disponibilita> getAllDisponibilita();

	public Disponibilita getDisponibilita(int id_disponibilita);

	public void updateDisponibilita(Disponibilita disponibilita);

	public void deleteDisponibilita(Disponibilita disponibilita);
}
