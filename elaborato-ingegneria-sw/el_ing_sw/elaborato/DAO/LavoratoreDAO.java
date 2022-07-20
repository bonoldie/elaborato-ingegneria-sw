package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class LavoratoreDAO implements ILavoratoreDAO {

	public LavoratoreDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lavoratore> getAllLavoratore() {
		// TODO Auto-generated method stub
		List<Lavoratore> lavoratori = new ArrayList<>();
		
		return lavoratori;
	}

	@Override
	public Lavoratore getLavoratore(int id_lavoratore) throws SQLException {
		ResultSet rs_lavoratore;

			PreparedStatement pst_lavoratore = Database.getDatabase().getConnection().prepareStatement("SELECT * FROM lavoratore WHERE id_lavoratore=? LIMIT 1");	
			pst_lavoratore.setInt(1, id_lavoratore);
			rs_lavoratore = pst_lavoratore.executeQuery();
			
			while(rs_lavoratore.next()) {
				return new Lavoratore(
								rs_lavoratore.getInt("id_lavoratore"),
								rs_lavoratore.getInt("id_anagrafica"),
								rs_lavoratore.getInt("id_recapito_urgenza"),
								rs_lavoratore.getString("indirizzo"),
								rs_lavoratore.getBoolean("automunito")
								);
			}

		
		return null;
	}
	
	@Override
	public void updateLavoratore(Lavoratore lavoratore) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertLavoratore(Lavoratore lavoratore) throws SQLException {
		PreparedStatement pst_lavoratore = Database.getDatabase().getConnection()
				.prepareStatement("INSERT INTO lavoratore(id_anagrafica, id_recapito_urgenza, indirizzo, automunito) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		pst_lavoratore.setInt(1, lavoratore.getId_anagrafica());
		pst_lavoratore.setInt(2, lavoratore.getId_recapito_urgenza());
		pst_lavoratore.setString(3, lavoratore.getIndirizzo());
		pst_lavoratore.setBoolean(4, lavoratore.isAutomunito());
		pst_lavoratore.executeUpdate();
		
		ResultSet r = pst_lavoratore.getGeneratedKeys();
		r.next();
		lavoratore.setId_lavoratore(r.getInt(1));
	}

	@Override
	public void deleteLavoratore(Lavoratore lavoratore) {
		// TODO Auto-generated method stub

	}

}
