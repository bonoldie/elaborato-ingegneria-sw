package elaborato.ricerca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import elaborato.DAO.Lingua;
import elaborato.DAO.Patente;

public class LinguaFilter implements Filter<Lingua> {

	private static String rifTabella = "li";
	private static String rifColonna = "nome_lingua";

	private static String sqlPrefix = " SELECT l.id_lavoratore FROM lavoratore l left join lavoratore_lingua ll  on l.id_lavoratore = ll.id_lavoratore  join  lingua li ON  ll.id_lingua  = li.id_lingua ";

	private Set<Lingua> lingue;
	
	public LinguaFilter() {
		this.lingue = new HashSet<Lingua>();
	}
	
	@Override
	public Set<Lingua> getFilterSet() {
		return this.lingue;
	}

	@Override
	public Set<Lingua> addFilterElement(Lingua element) {
		this.lingue.add(element);
		return this.lingue;
	}

	@Override
	public void removeFilterElement(Lingua element) {
		if(this.lingue.contains(element)) {
			this.lingue.remove(element);
		}
	}

	@Override
	public void clearFilterSet() {
		this.lingue.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		List<String> query = new ArrayList<String>();

		for (Lingua l : this.lingue) {
			query.add(rifTabella + "." + rifColonna + "='" + l.getNome_lingua() + "' ");
		}

		return String.join(" " + collation + " ", query);
	}

	@Override
	public String getQueryString(String collation) {
		if(this.lingue.isEmpty()){
			return sqlPrefix;
		}
		
		return sqlPrefix + " WHERE " + this.getFilterQueryString(collation);
	}

	@Override
	public String getNameFilter() {
		// TODO Auto-generated method stub
		return "Lingua";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "1";
	}

}
