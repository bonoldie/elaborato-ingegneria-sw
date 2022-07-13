package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILavoratore_EsperienzaDAO {
	public List<Lavoratore_Esperienza> getAllLavoratore_Esperienza() throws SQLException;

	public List<Lavoratore_Esperienza> getLavoratore_esperienza(int id_lavoratore);

	public void updateLavoratore_Esperienza(Lavoratore_Esperienza lavoratore_esperienza);
	
	public void insertLavoratore_Esperienza(Lavoratore_Esperienza lavoratore_esperienza) throws SQLException;

	public void deleteLavoratore_Esperienza(Lavoratore_Esperienza lavoratore_esperienza);
}
