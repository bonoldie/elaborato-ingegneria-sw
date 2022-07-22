package elaborato.ricerca;

import java.util.HashSet;
import java.util.Set;

public class AutomunitoFilter implements Filter<Boolean> {
	
	//ERRORE: Cannot invoke "java.util.Set.add(Object)" because "this.dati" is null
	//
	
	private static String rifTabella = "l";
	private static String rifColonna = "automunito";
	
	private static String sqlPrefix = "SELECT l.id_lavoratore FROM lavoratore l";
	
	Set<Boolean> dati;

	public AutomunitoFilter() {
		this.dati = new HashSet<Boolean>();
	}
	
	@Override
	public Set<Boolean> getFilterSet() {
		// TODO Auto-generated method stub
		return this.dati;
	}

	@Override
	public Set<Boolean> addFilterElement(Boolean element) {
		// TODO Auto-generated method stub
		
		this.dati.add(element);
		return this.dati;
	}

	@Override
	public void removeFilterElement(Boolean element) {
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
		
		Boolean b = (Boolean)this.dati.toArray()[0];
		return rifTabella + "." + rifColonna + "=" + "'" + b + "'";
	}

	@Override
	public String getQueryString(String collation) {
		// TODO Auto-generated method stub
		if(this.dati.isEmpty()) {
			return sqlPrefix;
		}
		
		return sqlPrefix + " WHERE " + this.getFilterQueryString(collation);
	}
	
	@Override
	public String getNameFilter() {
		// TODO Auto-generated method stub
		return "automunito: ";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "7";
	}

	@Override
	public String getDatiFilter() {
		// TODO Auto-generated method stub
		Boolean b = (Boolean)this.dati.toArray()[0];
		if(b == true)
			return "true";
		else
			return "false";
	}
	
	@Override
	public String toString() {
		return this.getNameFilter()+(Boolean)this.dati.toArray()[0];
	}

}
