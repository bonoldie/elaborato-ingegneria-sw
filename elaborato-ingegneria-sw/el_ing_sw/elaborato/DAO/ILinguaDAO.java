package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILinguaDAO {
	public List<Lingua> getAllLingue() throws SQLException ; 

	public Lingua getLingua(int id_lingua);

	public void updateLingua(Lingua lingua);

	public void deleteLingua(Lingua lingua);
}
