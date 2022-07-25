package tests.Filters;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import elaborato.DAO.FilterAnagrafica;
import elaborato.DAO.Lavoratore;
import elaborato.DAO.Lingua;
import elaborato.DAO.LinguaDAO;
import elaborato.DAO.Patente;
import elaborato.DAO.PatenteDAO;
import elaborato.DAO.SpecializzazioneDAO;
import elaborato.ricerca.AutomunitoFilter;
import elaborato.ricerca.DisponibilitaComuneFilter;
import elaborato.ricerca.LavoratoreFilter;
import elaborato.ricerca.LinguaFilter;
import elaborato.ricerca.PatenteFilter;

public class Filters {
	
	@Test
	void AutogetQueryStringTest() throws SQLException {
		AutomunitoFilter af = new AutomunitoFilter();
		af.addFilterElement(true);
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l WHERE l.automunito='true'",af.getQueryString(null),"query non uguali");
	}
	
	@Test
	void PatentegetQueryStringTest() throws SQLException { //darà probabilmente errore perchè si usa un set
		PatenteFilter pf = new PatenteFilter();
		PatenteDAO pd = new PatenteDAO();
		List<Patente> lista = pd.getAllPatente();
		for(int i=0; i<3; i++){ //provo con solo le prime tre patenti
			pf.addFilterElement(lista.get(i));
		}
		assertEquals(" SELECT l.id_lavoratore FROM lavoratore l left join lavoratore_patente lp on l.id_lavoratore = lp.id_lavoratore join patente p on lp.id_patente = p.id_patente WHERE p.nome_patente='AM'  OR p.nome_patente='A2'  OR p.nome_patente='A1' ",pf.getQueryString("OR"),"query non uguali");
	}
	
	@Test
	void LinguagetQueryStringTest() throws SQLException {
		LinguaFilter lf = new LinguaFilter();
		LinguaDAO ld = new LinguaDAO();
		List<Lingua> lista = ld.getAllLingue();
		for(Lingua l : lista) {
			lf.addFilterElement(l);
		}
		Set<Lingua> test = lf.getFilterSet(); // testo funzionamento add
		assertTrue(test.size()==lista.size());
	}
	
	@Test
	void LavoratoregetQueryStringTest() throws SQLException {
		LavoratoreFilter lf = new LavoratoreFilter();
		FilterAnagrafica element = new FilterAnagrafica("pippo","pietro","gino@ww.com");
		lf.addFilterElement(element);
		assertEquals(" SELECT l.id_lavoratore FROM lavoratore l LEFT JOIN anagrafica a ON a.id_anagrafica = l.id_anagrafica WHERE a.nome='pippo' OR a.cognome='pietro' OR a.email='gino@ww.com'",lf.getQueryString("OR"),"query non uguali");
	}
	
	@Test
	void DsiponibilitagetQueryStringTest() throws SQLException {
		DisponibilitaComuneFilter af = new DisponibilitaComuneFilter();
		af.addFilterElement("Verona");
		assertEquals("SELECT l.id_lavoratore FROM lavoratore l left join disponibilita d ON  d.id_lavoratore = l.id_lavoratore WHERE d.comune='Verona' ",af.getQueryString(null),"query non uguali");
	}
}
