package testsFiltri;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import elaborato.DAO.Patente;
import elaborato.DAO.SpecializzazioneDAO;
import elaborato.ricerca.AutomunitoFilter;
import elaborato.ricerca.PatenteFilter;

public class Filters {
	
	@Test
	void AutogetQueryStringTest() throws SQLException {
		AutomunitoFilter af = new AutomunitoFilter();
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}
	
	@Test
	void PatentegetQueryStringTest() throws SQLException {
		AutomunitoFilter af = new AutomunitoFilter();
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}
	
	/*@Test
	void AutogetQueryStringTest() throws SQLException {
		PatenteFilter af = new PatenteFilter();
		Patente af;
		af.
		
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}
	
	@Test
	void AutogetQueryStringTest() throws SQLException {
		AutomunitoFilter af = new AutomunitoFilter();
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}
	
	@Test
	void AutogetQueryStringTest() throws SQLException {
		AutomunitoFilter af = new AutomunitoFilter();
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}
	
	@Test
	void AutogetQueryStringTest() throws SQLException {
		AutomunitoFilter af = new AutomunitoFilter();
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}*/
}
