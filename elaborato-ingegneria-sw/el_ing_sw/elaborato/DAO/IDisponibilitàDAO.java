package elaborato.DAO;

import java.util.List;

public interface IDisponibilitąDAO {
	public List<Disponibilitą> getAllDisponibilitą();
	public Disponibilitą getDisponibilitą(int id_disponibilitą);
	public void updateDisponibilitą(Disponibilitą disponibilitą);
	public void deleteDisponibilitą(Disponibilitą disponibilitą);
}
