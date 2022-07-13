package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILavoratore_ViewDAO {
	public List<Lavoratore_View> getAllLavoratore_View() throws SQLException;

	public Lavoratore_View getLavoratore_View(int id_lavoratore);

	public void updateLavoratore_View(Lavoratore_View lavoratore);
	
	public void insertLavoratore_View(Lavoratore_View lavoratore) throws SQLException;

	public void deleteLavoratore_View(Lavoratore_View lavoratore);
}
