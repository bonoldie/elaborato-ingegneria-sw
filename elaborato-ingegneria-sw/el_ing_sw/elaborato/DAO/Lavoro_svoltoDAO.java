package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class Lavoro_svoltoDAO implements ILavoro_svoltoDAO {

	public Lavoro_svoltoDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Lavoro_svolto> getAllLavoro_svolto() throws SQLException {
		List<Lavoro_svolto> lavori_svolti = new ArrayList<>();

		ResultSet rs_lavori_svolti;

			Statement st_anagrafica = Database.getDatabase().getConnection().createStatement();	
			
			rs_lavori_svolti = st_anagrafica.executeQuery("SELECT * FROM lavoro_svolto ");
			
			while(rs_lavori_svolti.next()) {
				lavori_svolti.add(
						new Lavoro_svolto(
								rs_lavori_svolti.getInt("id_lavoro_svolto"),
								rs_lavori_svolti.getInt("id_lavoratore"),
								rs_lavori_svolti.getDate("data_inizio").toLocalDate(),
								rs_lavori_svolti.getDate("data_fine").toLocalDate(),
								rs_lavori_svolti.getString("nome_azienda"),
								rs_lavori_svolti.getString("mansione_svolta"),
								rs_lavori_svolti.getString("luogo_di_lavoro"),
								rs_lavori_svolti.getBigDecimal("retri_lorda_giornaliera")
								)
						
						);
			}

		
		return lavori_svolti;
	}

	@Override
	public Lavoro_svolto getLavoro_svolto(int id_lavoro_svolto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLavoro_svolto(Lavoro_svolto lavoro_svolto) throws SQLException {
		PreparedStatement pst_lavoro_svolto = Database.getDatabase().getConnection()
				.prepareStatement("INSERT INTO lavoro_svolto(id_lavoro_svolto, id_lavoratore, data_inizio, data_fine, nome_azienda, mansione_svolta, luogo_di_lavoro, retri_lorda_giornaliera) VALUES (?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		pst_lavoro_svolto.setInt(1, lavoro_svolto.getId_lavoro_svolto());
		pst_lavoro_svolto.setInt(2, lavoro_svolto.getId_lavoratore());
		pst_lavoro_svolto.setDate(3, java.sql.Date.valueOf(lavoro_svolto.getData_inizio()));
		pst_lavoro_svolto.setDate(4, java.sql.Date.valueOf(lavoro_svolto.getData_fine()));
		pst_lavoro_svolto.setString(5, lavoro_svolto.getNome_azienda());
		pst_lavoro_svolto.setString(6, lavoro_svolto.getNome_azienda());
		pst_lavoro_svolto.setString(7, lavoro_svolto.getLuogo_di_lavoro());
		pst_lavoro_svolto.setBigDecimal(8, lavoro_svolto.getRetribuzione_lorda_giornaliera());
		
		pst_lavoro_svolto.executeUpdate();
		
		ResultSet r = pst_lavoro_svolto.getGeneratedKeys();
		r.next();
		lavoro_svolto.setId_lavoratore(r.getInt(1));
	}
	
	@Override
	public void updateLavoro_svolto(Lavoro_svolto lavoro_svolto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLavoro_svolto(Lavoro_svolto lavoro_svolto) throws SQLException {
		// TODO Auto-generated method stub
		if(lavoro_svolto==null) { //attivarlo ogni volta apro aggiorna
			PreparedStatement pst_lavoro_svolto = Database.getDatabase().getConnection()
					.prepareStatement("DELETE FROM Lavoro_svolto WHERE current_date-data_fine>1825;");
			pst_lavoro_svolto.executeUpdate();
		}
		else {
			PreparedStatement pst_lavoro_svolto = Database.getDatabase().getConnection()
					.prepareStatement("DELETE FROM Lavoro_svolto WHERE id_lavoro_svolto=?;");
			pst_lavoro_svolto.setInt(1, lavoro_svolto.getId_lavoro_svolto());
			pst_lavoro_svolto.executeUpdate();
		}
	}

}
