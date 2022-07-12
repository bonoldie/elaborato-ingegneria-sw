package elaborato.DAO;

import java.util.List;

public interface ILavoratore_LinguaDAO {
	public List<Lavoratore_Lingua> getAllLavoratore_Lingua();

	public Lavoratore_Lingua getLavoratore_Lingua(int id_lingua); // serve anche id_lavoratore??

	public void updateLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua);

	public void deleteLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua);
}
