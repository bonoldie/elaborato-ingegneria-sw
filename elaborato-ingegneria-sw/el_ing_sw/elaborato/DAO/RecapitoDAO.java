package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class RecapitoDAO implements IRecapitoDAO {

	public RecapitoDAO() {
	}

	@Override
	public List<Recapito> getAllRecapito() throws SQLException {
		// TODO Auto-generated method stub
		List<Recapito> recapiti = new ArrayList<>();

		ResultSet rs_recapito;

		Statement st_recapito = Database.getDatabase().getConnection().createStatement();

		rs_recapito = st_recapito.executeQuery("SELECT * FROM recapito ");

		while (rs_recapito.next()) {
			recapiti.add(new Recapito(rs_recapito.getInt("id_recapito"), rs_recapito.getString("nome"),
					rs_recapito.getString("cognome"), rs_recapito.getString("telefono"),
					rs_recapito.getString("email")));
		}

		return recapiti;
	}

	@Override
	public Recapito getRecapito(int id_recapito) throws SQLException {
		ResultSet rs_recapito;

		PreparedStatement pst_recapito = Database.getDatabase().getConnection()
				.prepareStatement("SELECT * FROM recapito WHERE id_recapito=? LIMIT 1");
		pst_recapito.setInt(1, id_recapito);
		rs_recapito = pst_recapito.executeQuery();

		while (rs_recapito.next()) {
			return new Recapito(rs_recapito.getInt("id_recapito"), rs_recapito.getString("nome"),
					rs_recapito.getString("cognome"), rs_recapito.getString("telefono"),
					rs_recapito.getString("email"));
		}

		return null;
	}

	@Override
	public void insertRecapito(Recapito recapito) throws SQLException {
		PreparedStatement pst_recapito = Database.getDatabase().getConnection().prepareStatement(
				"INSERT INTO Recapito(nome, cognome, telefono, email) VALUES (?,?,?,?);",
				Statement.RETURN_GENERATED_KEYS);
		pst_recapito.setString(1, recapito.getNome());
		pst_recapito.setString(2, recapito.getCognome());
		pst_recapito.setString(3, recapito.getTelefono());
		pst_recapito.setString(4, recapito.getEmail());
		pst_recapito.executeUpdate();

		ResultSet r = pst_recapito.getGeneratedKeys();
		r.next();
		recapito.setId_recapito(r.getInt(1));
	}

	@Override
	public void updateRecapito(Recapito recapito) throws SQLException {
		PreparedStatement pst_recapito = Database.getDatabase().getConnection()
				.prepareStatement("UPDATE recapito SET nome=?, cognome=? WHERE id_recapito=?;");
		pst_recapito.setString(1, recapito.getNome());
		pst_recapito.setString(2, recapito.getCognome());
		pst_recapito.setInt(3, recapito.getId_recapito());

		pst_recapito.executeUpdate();

		// Email separata per controllo constraint
		if (this.getRecapito(recapito.getId_recapito()).getEmail() != recapito.getEmail()) {
			pst_recapito = Database.getDatabase().getConnection()
					.prepareStatement("UPDATE recapito SET email=? WHERE id_recapito=?;");
			pst_recapito.setString(1, recapito.getEmail());
			pst_recapito.setInt(2, recapito.getId_recapito());
			pst_recapito.executeUpdate();
		}

		// Telefono separato per controllo constraint

		if (this.getRecapito(recapito.getId_recapito()).getTelefono() != recapito.getTelefono()) {
			pst_recapito = Database.getDatabase().getConnection()
					.prepareStatement("UPDATE recapito SET telefono=? WHERE id_recapito=?;");
			pst_recapito.setString(1, recapito.getTelefono());
			pst_recapito.setInt(2, recapito.getId_recapito());
			pst_recapito.executeUpdate();
		}

	}

	@Override
	public void deleteRecapito(Recapito recapito) {
		// TODO Auto-generated method stub

	}

}
