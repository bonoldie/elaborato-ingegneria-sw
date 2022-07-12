package elaborato.DAO;

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
	public List<Lingua> getAllLingue() {
		// TODO Auto-generated method stub
		List<Lingua> lingue = new ArrayList<>();
		
		ResultSet rs_lingua;
		try {
			Statement st_lingua = Database.getDatabase().getConnection().createStatement();	
			
			rs_lingua = st_lingua.executeQuery("SELECT * FROM lingua ");
			
			while(rs_lingua.next()) {
				lingue.add(
						new Lingua(
								rs_lingua.getInt("id_lingua"),
								rs_lingua.getString("nome_lingua")
								)
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lingue;
	}

	@Override
	public Lingua getLingua(int id_lingua) {
		// TODO Auto-generated method stub
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
