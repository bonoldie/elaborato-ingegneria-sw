package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILavoratore_PatenteDAO {
	public List<Lavoratore_Patente> getAllLavoratore_Patente() throws SQLException;

	public List<Lavoratore_Patente>  getLavoratore_Patente(int id_lavoratore) throws SQLException;
	
	public void insertLavoratore_Patente(Lavoratore_Patente lavoratore_patente) throws SQLException;
	
	public void updateLavoratore_Patente(Lavoratore_Patente lavoratore_patente);

	public void deleteLavoratore_Patente(Lavoratore_Patente lavoratore_patente) throws SQLException;
}
