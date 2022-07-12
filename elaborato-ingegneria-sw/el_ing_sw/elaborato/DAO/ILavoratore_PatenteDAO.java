package elaborato.DAO;

import java.util.List;

public interface ILavoratore_PatenteDAO {
	public List<Lavoratore_Patente> getAllLavoratore_Patente();

	public Lavoratore_Patente getLavoratore_Patente(int id_lavoratore); // serve anche id_patente?

	public void updateLavoratore_Patente(Lavoratore_Patente lavoratore_patente);

	public void deleteLavoratore_Patente(Lavoratore_Patente lavoratore_patente);
}
