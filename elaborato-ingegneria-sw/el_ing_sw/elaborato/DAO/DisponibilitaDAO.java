package elaborato.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elaborato.DB.Database;

public class DisponibilitaDAO implements IDisponibilitaDAO {

	public DisponibilitaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Disponibilita> getAllDisponibilita() throws SQLException {
		List<Disponibilita> disponibilita = new ArrayList<>();

		ResultSet rs_disponibilita;

			Statement st_disponibilita = Database.getDatabase().getConnection().createStatement();	
			
			rs_disponibilita = st_disponibilita.executeQuery("SELECT * FROM anagrafica ");
			
			while(rs_disponibilita.next()) {
				disponibilita.add(
						new Disponibilita(
								rs_disponibilita.getInt("id_disponibilita"),
								rs_disponibilita.getInt("id_lavoratore"),
								rs_disponibilita.getDate("data_inizio").toLocalDate(),
								rs_disponibilita.getDate("data_fine").toLocalDate(),
								rs_disponibilita.getString("comune")
								)
						);
			}

		
		return disponibilita;
	}

	@Override
	public Disponibilita getDisponibilita(int id_disponibilita) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void insertDisponibilita(Disponibilita disponibilita) throws SQLException {
		PreparedStatement pst_disponibilita = Database.getDatabase().getConnection()
				.prepareStatement("INSERT INTO Disponibilita(id_lavoratore, data_inizio, data_fine, comune) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		pst_disponibilita.setInt(1, disponibilita.getId_lavoratore());
		pst_disponibilita.setDate(2, java.sql.Date.valueOf(disponibilita.getData_inizio()));
		pst_disponibilita.setDate(3, java.sql.Date.valueOf(disponibilita.getData_fine()));
		pst_disponibilita.setString(4, disponibilita.getComune());
		pst_disponibilita.executeUpdate();
		
		ResultSet r = pst_disponibilita.getGeneratedKeys();
		r.next();
		disponibilita.setId_lavoratore(r.getInt(1));
	}
	
	@Override
	public void updateDisponibilita(Disponibilita disponibilita) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDisponibilita(Disponibilita disponibilita) {
		// TODO Auto-generated method stub

	}

}
