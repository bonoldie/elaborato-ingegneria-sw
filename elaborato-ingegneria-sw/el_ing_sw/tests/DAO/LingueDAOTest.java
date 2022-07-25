package tests.DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import elaborato.DAO.LavoratoreDAO;
import elaborato.DAO.LinguaDAO;

public class LingueDAOTest {
	@Test
	void getAllLingue() throws SQLException {
		LinguaDAO anadao = new LinguaDAO();
		assertTrue(anadao.getAllLingue().size()>0,()->"lista lingue vuota o non raggiunta");
	}
}
