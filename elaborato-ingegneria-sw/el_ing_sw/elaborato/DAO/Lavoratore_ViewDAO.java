package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class Lavoratore_ViewDAO implements ILavoratore_ViewDAO {

	@Override
	public List<Lavoratore_View> getAllLavoratore_View() throws SQLException {
		// TODO Auto-generated method stub
		List<Lavoratore_View> lavoratori_view = new ArrayList<>();
		
		Statement st_lavoratore_view = Database.getDatabase().getConnection().createStatement();
		
		ResultSet r = st_lavoratore_view.executeQuery("SELECT * FROM dettagli_lavoratori;");
		
		
		while(r.next()) {
			lavoratori_view.add(new Lavoratore_View(r.getInt("id_lavoratore"), r.getString("specializzazione"), r.getString("lingue"), r.getString("periodo_disponibilita"), r.getString("patenti_lavoratore"), r.getString("comuni_disponibilita")));
		}
		return lavoratori_view;
	}

	@Override
	public Lavoratore_View getLavoratore_View(int id_lavoratore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLavoratore_View(Lavoratore_View lavoratore) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertLavoratore_View(Lavoratore_View lavoratore) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLavoratore_View(Lavoratore_View lavoratore) {
		// TODO Auto-generated method stub

	}

}
