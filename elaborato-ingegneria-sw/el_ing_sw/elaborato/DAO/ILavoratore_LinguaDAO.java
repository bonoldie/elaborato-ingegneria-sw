package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILavoratore_LinguaDAO {
	public List<Lavoratore_Lingua> getAllLavoratore_Lingua() throws SQLException;

	public Lavoratore_Lingua getLavoratore_Lingua(int id_lingua); // serve anche id_lavoratore??

	public void updateLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua);
	
	public void insertLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua) throws SQLException;

	public void deleteLavoratore_Lingua(Lavoratore_Lingua lavoratore_lingua);
}
