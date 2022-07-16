package elaborato.ricerca;

import java.util.Set;

public class AutomunitoFilter implements Filter<String> {
	
	//ERRORE: Cannot invoke "java.util.Set.add(Object)" because "this.dati" is null
	//
	
	private static String rifTabella = "l";
	private static String rifColonna = "automunito";
	
	private static String sqlPrefix = "SELECT l.id_lavoratore FROM lavoratore l";
	
	Set<String> dati;

	@Override
	public Set<String> getFilterSet() {
		// TODO Auto-generated method stub
		return this.dati;
	}

	@Override
	public Set<String> addFilterElement(String element) {
		// TODO Auto-generated method stub
		this.dati.add(element);
		return this.dati;
	}

	@Override
	public void removeFilterElement(String element) {
		// TODO Auto-generated method stub
		this.dati.remove(element);
	}

	@Override
	public void clearFilterSet() {
		// TODO Auto-generated method stub
		this.dati.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		// TODO Auto-generated method stub
		if(this.dati.isEmpty() || this.dati.size()!= 1) {
			return "";
		}
		
		String b = (String)this.dati.toArray()[0];
		return rifTabella + "." + rifColonna + "=" + "'" + b + "'";
	}

	@Override
	public String getQueryString(String collation) {
		// TODO Auto-generated method stub
		if(this.dati.isEmpty()) {
			return sqlPrefix;
		}
		
		return sqlPrefix + "WHERE" + this.getFilterQueryString(collation);
	}
	
	@Override
	public String getNameFilter() {
		// TODO Auto-generated method stub
		return "automunito";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "7";
	}

}
