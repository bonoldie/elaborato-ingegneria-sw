package elaborato.ricerca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import elaborato.DAO.Lingua;
import elaborato.DAO.Patente;

public class PatenteFilter implements Filter<Patente> {

	private static String rifTabella = "p";
	private static String rifColonna = "nome_patente";

	private static String sqlPrefix = " SELECT l.id_lavoratore FROM lavoratore l left join lavoratore_patente lp on l.id_lavoratore = lp.id_lavoratore join patente p on lp.id_patente = p.id_patente";

	private Set<Patente> patenti;

	public PatenteFilter(Patente... p) {
		patenti = new HashSet<Patente>();

		for (Patente patente : p) {
			patenti.add(patente);
		}
	}

	@Override
	public Set<Patente> addFilterElement(Patente patente) {
		patenti.add(patente);
		return this.patenti;
	}

	@Override
	public void removeFilterElement(Patente patente) {
		if (patenti.contains(patente)) {
			patenti.remove(patente);
		}
	}

	@Override
	public void clearFilterSet() {
		this.patenti.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		List<String> query = new ArrayList<String>();

		for (Patente p : patenti) {
			query.add(rifTabella + "." + rifColonna + "='" + p.getNome_patente() + "' ");
		}

		return String.join(" " + collation + " ", query);
	}

	@Override
	public String getQueryString(String collation) {
		if(this.patenti.isEmpty()){
			return sqlPrefix;
		}
		
		return sqlPrefix + " WHERE " + this.getFilterQueryString(collation);
	}

	@Override
	public Set<Patente> getFilterSet() {
		return this.patenti;
	}

	@Override
	public String getNameFilter() {
		// TODO Auto-generated method stub
		return "patente";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "5";
	}

	@Override
	public String getDatiFilter() {
		// TODO Auto-generated method stub
		String dati = "";
		for (Patente s : patenti) {
			dati+= s.getNome_patente() +" ";
		}
		return dati;
	}
}
