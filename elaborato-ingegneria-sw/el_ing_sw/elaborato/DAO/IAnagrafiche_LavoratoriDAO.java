package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IAnagrafiche_LavoratoriDAO {
	public List<Anagrafiche_Lavoratori> getAllAnagrafiche_Lavoratori() throws SQLException;

	public Anagrafiche_Lavoratori getAnagrafiche_Lavoratori(int id_lavoratore) throws SQLException;
}
