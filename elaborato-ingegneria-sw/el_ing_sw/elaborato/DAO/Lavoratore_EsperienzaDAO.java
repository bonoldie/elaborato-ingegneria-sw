package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import elaborato.DB.Database;

public class Lavoratore_EsperienzaDAO implements ILavoratore_EsperienzaDAO {

	@Override
	public List<Lavoratore_Esperienza> getAllLavoratore_Esperienza() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lavoratore_Esperienza> getLavoratore_esperienza(int id_lavoratore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLavoratore_Esperienza(Lavoratore_Esperienza lavoratore_esperienza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLavoratore_Esperienza(Lavoratore_Esperienza lavoratore_esperienza) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst_lavoratore_esperienza = null;
		pst_lavoratore_esperienza = Database.getDatabase().getConnection()
				.prepareStatement("INSERT INTO Lavoratore_Esperienza(id_lavoratore, esperienza) VALUES (?,?);", Statement.RETURN_GENERATED_KEYS);
		pst_lavoratore_esperienza.setInt(1 ,lavoratore_esperienza.getId_lavoratore());
		pst_lavoratore_esperienza.setString(2 ,lavoratore_esperienza.getEsperienza());
		pst_lavoratore_esperienza.executeUpdate();
		
		ResultSet r = pst_lavoratore_esperienza.getGeneratedKeys();
		r.next();
		lavoratore_esperienza.setId_lavoratore(r.getInt(1));
		
	}

	@Override
	public void deleteLavoratore_Esperienza(Lavoratore_Esperienza lavoratore_esperienza) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst_lavoratore_esperienza = null;
		pst_lavoratore_esperienza = Database.getDatabase().getConnection()
				.prepareStatement("DELETE FROM Lavoratore_Esperienza WHERE id_lavoratore= ? AND esperienza= ?;");
		pst_lavoratore_esperienza.setInt(1 ,lavoratore_esperienza.getId_lavoratore());
		pst_lavoratore_esperienza.setString(2 ,lavoratore_esperienza.getEsperienza());
		pst_lavoratore_esperienza.executeUpdate();
	}

}
