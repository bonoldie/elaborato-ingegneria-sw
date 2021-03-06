package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class LinguaDAO implements ILinguaDAO {

	public LinguaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lingua> getAllLingue() throws SQLException {
		// TODO Auto-generated method stub
		List<Lingua> lingue = new ArrayList<>();

		ResultSet rs_lingua;

		Statement st_lingua = Database.getDatabase().getConnection().createStatement();

		rs_lingua = st_lingua.executeQuery("SELECT * FROM lingua ");

		while (rs_lingua.next()) {
			lingue.add(new Lingua(rs_lingua.getInt("id_lingua"), rs_lingua.getString("nome_lingua")));
		}

		return lingue;
	}

	@Override
	public Lingua getLingua(int id_lingua) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs_lingua;

		PreparedStatement pst_lingua = Database.getDatabase().getConnection()
				.prepareStatement("SELECT * FROM lingua WHERE id_lingua=? LIMIT 1");
		pst_lingua.setInt(1, id_lingua);
		rs_lingua = pst_lingua.executeQuery();

		while (rs_lingua.next()) {
			return new Lingua(rs_lingua.getInt("id_lingua"), rs_lingua.getString("nome_lingua"));
		}

		return null;
	}

	@Override
	public void updateLingua(Lingua lingua) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLingua(Lingua lingua) {
		// TODO Auto-generated method stub

	}

}
