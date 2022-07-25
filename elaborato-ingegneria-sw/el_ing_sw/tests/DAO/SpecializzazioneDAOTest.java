package tests.DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import elaborato.DAO.SpecializzazioneDAO;

public class SpecializzazioneDAOTest {
	@Test
	void getAllLingue() throws SQLException {
		SpecializzazioneDAO anadao = new SpecializzazioneDAO();
		assertTrue(anadao.getAllSpecializzazione().size()>0,()->"lista lingue vuota o non raggiunta");
	}
}
