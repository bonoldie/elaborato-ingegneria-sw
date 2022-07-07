package elaborato.DAO;

import java.util.List;

public interface ILavoro_svoltoDAO {
	public List<Lavoro_svolto> getAllLavoro_svolto();
	public Lavoro_svolto getLavoro_svolto(int id_lavoro_svolto);
	public void updateLavoro_svolto(Lavoro_svolto lavoro_svolto);
	public void deleteLavoro_svolto(Lavoro_svolto lavoro_svolto);
}
