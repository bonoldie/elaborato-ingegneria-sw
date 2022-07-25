package testsDAO;



import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import elaborato.DAO.Anagrafica;
import elaborato.DAO.AnagraficaDAO;
import elaborato.DB.Database;


class AnagraficaDAOTest {

	@Test
	void getAll() throws SQLException {
		AnagraficaDAO anadao = new AnagraficaDAO();
		anadao.getAllAnagrafica();
		
	}
	
	@Test
	void insertAnagrafica() throws SQLException {
		Database.getDatabase().getConnection().setAutoCommit(false);
		Anagrafica an = new Anagrafica(0, "sdfb", LocalDate.parse("2020-12-21"), "serg" , "afae", "sver", "1234567890", "efwe@wfe");
		AnagraficaDAO anadao = new AnagraficaDAO();
		anadao.insertAnagrafica(an);
		Database.getDatabase().getConnection().rollback();
		Database.getDatabase().getConnection().setAutoCommit(true);
	}
	
	@Test
	void updateAnagrafica() throws SQLException {
		Database.getDatabase().getConnection().setAutoCommit(false);
		Anagrafica an = new Anagrafica(0, "sdfb", LocalDate.parse("2020-12-21"), "serg" , "afae", "sver", "1234567890", "efwe@wfe");
		AnagraficaDAO anadao = new AnagraficaDAO();
		anadao.insertAnagrafica(an);
		an.setCognome("prova");
		anadao.updateAnagrafica(an);
		Database.getDatabase().getConnection().rollback();
		Database.getDatabase().getConnection().setAutoCommit(true);
	}

}
