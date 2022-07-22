package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILavoratoreDAO {
	public List<Lavoratore> getAllLavoratore() throws SQLException;

	public Lavoratore getLavoratore(int id_lavoratore) throws SQLException;

	public void updateLavoratore(Lavoratore lavoratore) throws SQLException;
	
	public void insertLavoratore(Lavoratore lavoratore) throws SQLException;

	public void deleteLavoratore(Lavoratore lavoratore);
}
