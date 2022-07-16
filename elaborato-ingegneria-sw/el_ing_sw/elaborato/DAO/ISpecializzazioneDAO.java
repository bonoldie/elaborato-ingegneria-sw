package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ISpecializzazioneDAO {
	public List<Specializzazione> getAllSpecializzazione() throws SQLException;

	public Specializzazione getSpecializzazione(int id_specializzazione) throws SQLException;

	public void updateSpecializzazione(Specializzazione specializzazione);

	public void deleteSpecializzazione(Specializzazione specializzazione);
	
	public void insertSpecializzazione(Specializzazione specializzazione) throws SQLException;
}