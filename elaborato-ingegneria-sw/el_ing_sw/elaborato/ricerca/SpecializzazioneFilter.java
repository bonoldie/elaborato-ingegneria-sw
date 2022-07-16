package elaborato.ricerca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import elaborato.DAO.Patente;
import elaborato.DAO.Specializzazione;

public class SpecializzazioneFilter implements Filter<Specializzazione> {
	private static String rifTabella = "le";
	private static String rifColonna = "esperienza";

	private static String sqlPrefix = "SELECT l.id_lavoratore	FROM lavoratore l  left join lavoratore_esperienza le on l.id_lavoratore = le.id_lavoratore";

	private Set<Specializzazione> specs;
		
	
	public SpecializzazioneFilter() {
		this.specs = new HashSet<Specializzazione>();
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

	@Override
	public String getNameFilter() {
		// TODO Auto-generated method stub
		return "specializzazione";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "6";
	}

}
