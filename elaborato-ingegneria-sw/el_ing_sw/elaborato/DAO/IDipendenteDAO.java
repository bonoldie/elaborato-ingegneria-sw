package elaborato.DAO;

import java.util.List;

public interface IDipendenteDAO {
	public List<Dipendente> getAllDipendente();
	public Dipendente getDipendente(int id_dipendente);
	public void updateDipendente(Dipendente dipendente);
	public void deleteDipendente(Dipendente dipendente);
}
