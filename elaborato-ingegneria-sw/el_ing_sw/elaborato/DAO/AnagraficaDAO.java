package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class AnagraficaDAO implements IAnagraficaDAO {

	public AnagraficaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Anagrafica> getAllAnagrafica() throws SQLException {
		List<Anagrafica> anagrafiche = new ArrayList<>();

		ResultSet rs_anagrafica;

		Statement st_anagrafica = Database.getDatabase().getConnection().createStatement();

		rs_anagrafica = st_anagrafica.executeQuery("SELECT * FROM anagrafica ");

		while (rs_anagrafica.next()) {
			anagrafiche.add(new Anagrafica(rs_anagrafica.getInt("id_anagrafica"),
					rs_anagrafica.getString("luogo_di_nascita"), rs_anagrafica.getDate("data_di_nascita").toLocalDate(),
					rs_anagrafica.getString("nazionalita"), rs_anagrafica.getString("nome"),
					rs_anagrafica.getString("cognome"), rs_anagrafica.getString("telefono"),
					rs_anagrafica.getString("email")));
		}

		return anagrafiche;
	}

	@Override
	public Anagrafica getAnagrafica(int id_anagrafica) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst_anagrafica = Database.getDatabase().getConnection()
				.prepareStatement("SELECT * FROM Anagrafica a WHERE a.id_anagrafica=? LIMIT 1");
		pst_anagrafica.setInt(1, id_anagrafica);

		ResultSet rs_anagrafica = pst_anagrafica.executeQuery();

		while (rs_anagrafica.next()) {
			return new Anagrafica(rs_anagrafica.getInt("id_anagrafica"), rs_anagrafica.getString("luogo_di_nascita"),
					rs_anagrafica.getDate("data_di_nascita").toLocalDate(), rs_anagrafica.getString("nazionalita"),
					rs_anagrafica.getString("nome"), rs_anagrafica.getString("cognome"),
					rs_anagrafica.getString("telefono"), rs_anagrafica.getString("email"));
		}

		return null;

	}

	@Override
	public void updateAnagrafica(Anagrafica anagrafica) throws SQLException {
		// o facciamo eliminare completamente la riga e la facciamo rinserire oppure:
		PreparedStatement pst_anagrafica = Database.getDatabase().getConnection().prepareStatement(
				"UPDATE anagrafica SET luogo_di_nascita=?, data_di_nascita=?, nazionalita=?, nome=?, cognome=? WHERE id_anagrafica=?;"); // passargli
																																			// anche
																																			// l'id_lavoratore??

		pst_anagrafica.setString(1, anagrafica.getLuogo_di_nascita());
		pst_anagrafica.setDate(2, java.sql.Date.valueOf(anagrafica.getData_di_nascita()));
		pst_anagrafica.setString(3, anagrafica.getNazionalita());
		pst_anagrafica.setString(4, anagrafica.getNome());
		pst_anagrafica.setString(5, anagrafica.getCognome());

		pst_anagrafica.setInt(6, anagrafica.getId_anagrafica());
		pst_anagrafica.executeUpdate();

		// Email separata per controllo constraint
		if (this.getAnagrafica(anagrafica.getId_anagrafica()).getEmail() != anagrafica.getEmail()) {
			pst_anagrafica = Database.getDatabase().getConnection()
					.prepareStatement("UPDATE anagrafica SET email=? WHERE id_anagrafica=?;");
			pst_anagrafica.setString(1, anagrafica.getEmail());
			pst_anagrafica.setInt(2, anagrafica.getId_anagrafica());
			pst_anagrafica.executeUpdate();
		}

		// Telefono separato per controllo constraint
		pst_anagrafica = Database.getDatabase().getConnection()
				.prepareStatement("UPDATE anagrafica SET telefono=? WHERE id_anagrafica=?;");
		pst_anagrafica.setString(1, anagrafica.getTelefono());
		pst_anagrafica.setInt(2, anagrafica.getId_anagrafica());
		pst_anagrafica.executeUpdate();
	}

	@Override
	public void insertAnagrafica(Anagrafica anagrafica) throws SQLException {
		PreparedStatement pst_anagrafica = Database.getDatabase().getConnection().prepareStatement(
				"INSERT INTO Anagrafica(luogo_di_nascita, data_di_nascita, nazionalita, nome, cognome, telefono, email) VALUES (?,?,?,?,?,?,?);",
				Statement.RETURN_GENERATED_KEYS);

		pst_anagrafica.setString(1, anagrafica.getLuogo_di_nascita());

		pst_anagrafica.setDate(2, java.sql.Date.valueOf(anagrafica.getData_di_nascita()));
		pst_anagrafica.setString(3, anagrafica.getNazionalita());
		pst_anagrafica.setString(4, anagrafica.getNome());
		pst_anagrafica.setString(5, anagrafica.getCognome());
		pst_anagrafica.setString(6, anagrafica.getTelefono());
		pst_anagrafica.setString(7, anagrafica.getEmail());
		pst_anagrafica.executeUpdate();

		ResultSet r = pst_anagrafica.getGeneratedKeys();
		r.next();
		anagrafica.setId_anagrafica(r.getInt(1));
	}

	@Override
	public void deleteAnagrafica(Anagrafica anagrafica) throws SQLException { // al posto di passargli l'intera
																				// anagrafica se gli passo solo gli id??
		// TODO Auto-generated method stub
		PreparedStatement pst_anagrafica = Database.getDatabase().getConnection()
				.prepareStatement("DELETE FROM Anagrafica WHERE id_anagrafica=?;"); // passargli anche l'id_lavoratore??
		pst_anagrafica.setInt(2, anagrafica.getId_anagrafica());
		pst_anagrafica.executeUpdate();
	}

}
