package elaborato.ricerca;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import elaborato.DAO.Patente;
import elaborato.DAO.Specializzazione;

public class SpezializzazioneFilter implements Filter<Specializzazione> {
	private static String rifTabella = "lavoratore_esperienza";
	private static String rifColonna = "esperienza";

	private static String sqlPrefix = " SELECT l.id_lavoratore FROM lavoratore l left join lavoratore_patente lp on l.id_lavoratore = lp.id_lavoratore join patente p on lp.id_patente = p.id_patente";

	private Set<Specializzazione> specs;
		
	
	public SpezializzazioneFilter() {
		
	}
	
	@Override
	public Set<Specializzazione> getFilterSet() {
		return specs;
	}

	@Override
	public Set<Specializzazione> addFilterElement(Specializzazione element) {
		this.specs.add(element);
		return this.specs;
	}

	@Override
	public void removeFilterElement(Specializzazione element) {
		if (this.specs.contains(element)) {
			specs.remove(element);
		}
	}

	@Override
	public void clearFilterSet() {
		this.specs.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		List<String> query = new ArrayList<String>();

		for (Specializzazione s : this.specs) {
			query.add(rifTabella + "." + rifColonna + "='" + s.getNome_specializzazione() + "' ");
		}

		return String.join(" " + collation + " ", query);
	}
	
	public String getQueryString(String collation) {
		if(this.specs.isEmpty()){
			return sqlPrefix;
		}
		
		return sqlPrefix + " WHERE " + this.getFilterQueryString(collation);
	}

}
