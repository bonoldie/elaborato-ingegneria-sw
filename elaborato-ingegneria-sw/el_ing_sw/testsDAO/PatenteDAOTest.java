package testsDAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import elaborato.DAO.PatenteDAO;

public class PatenteDAOTest {
	@Test
	void getAllLingue() throws SQLException {
		PatenteDAO anadao = new PatenteDAO();
		assertTrue(anadao.getAllPatente().size()>0,()->"lista patenti vuota o non raggiunta");
	}
}
