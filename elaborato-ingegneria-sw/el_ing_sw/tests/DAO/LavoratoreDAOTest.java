package tests.DAO;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import elaborato.DAO.Lavoratore;
import elaborato.DAO.LavoratoreDAO;
import elaborato.DAO.Lavoratore;
import elaborato.DAO.LavoratoreDAO;
import elaborato.DB.Database;

public class LavoratoreDAOTest {
	@Test
	void getAllLavoratore() throws SQLException {
		LavoratoreDAO anadao = new LavoratoreDAO();
		anadao.getAllLavoratore();
		
	}
	
	@Test
	void insertLavoratore() throws SQLException {
		Database.getDatabase().getConnection().setAutoCommit(false);
		Lavoratore an = new Lavoratore(0, 1, 1, "serg" , true);
		LavoratoreDAO anadao = new LavoratoreDAO();
		anadao.insertLavoratore(an);
		Database.getDatabase().getConnection().commit();
		Database.getDatabase().getConnection().rollback();
		Database.getDatabase().getConnection().setAutoCommit(true);
	}
	
	@Test
	void updateLavoratore() throws SQLException {
		Database.getDatabase().getConnection().setAutoCommit(false);
		Lavoratore an = new Lavoratore(0, 1, 1, "serg" , true);
		LavoratoreDAO anadao = new LavoratoreDAO();
		anadao.insertLavoratore(an);
		an.setAutomunito(false);
		anadao.updateLavoratore(an);
		Database.getDatabase().getConnection().commit();
		Database.getDatabase().getConnection().rollback();
		Database.getDatabase().getConnection().setAutoCommit(true);
	}

}
