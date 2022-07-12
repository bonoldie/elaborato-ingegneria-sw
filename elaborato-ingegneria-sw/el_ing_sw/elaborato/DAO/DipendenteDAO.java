package elaborato.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import elaborato.DB.Database;

public class DipendenteDAO implements IDipendenteDAO {

	public DipendenteDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Dipendente> getAllDipendente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dipendente getDipendente(int id_dipendente) {
		// TODO Auto-generated method stub
		// Database.getDatabase().getConnection().prepareStatement("");
		return null;
	}

	@Override
	public void updateDipendente(Dipendente dipendente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDipendente(Dipendente dipendente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean getDipendenteLogin(String login, String password) {
		// TODO Auto-generated method stub
		// controllo credenziali per accesso
		try {

			Statement st = Database.getDatabase().getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT d.login, d.password, d.id_dipendente FROM Dipendenti d");

			while (rs.next()) {
				// controllo che il login e la password siano corrette
				if (rs.getString("login").equals(login) == true) {
					if (rs.getString("password").equals(password) == true) {
						return true;
					}
					return false;
				}
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
