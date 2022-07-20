package elaborato.ricerca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import elaborato.DAO.Patente;

public class DisponibilitaComuneFilter implements Filter<String> {
	
	private static String rifTabella = "d";
	private static String rifColonna = "comune";

	private static String sqlPrefix = "SELECT l.id_lavoratore FROM lavoratore l left join disponibilita d ON  d.id_lavoratore = l.id_lavoratore";
	
	Set<String> comuni;
	
	public DisponibilitaComuneFilter() {
		this.comuni = new HashSet<String>();
	}
	
	@Override
	public Set<String> getFilterSet() {
		return this.comuni;
	}

	@Override
	public Set<String> addFilterElement(String element) {
		this.comuni.add(element);
		return this.comuni;
	}

	@Override
	public void removeFilterElement(String element) {
		this.comuni.remove(element);
	}

	@Override
	public void clearFilterSet() {
		this.comuni.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		List<String> query = new ArrayList<String>();

		for (String comune : this.comuni) {
			query.add(rifTabella + "." + rifColonna + "='" + comune + "' ");
		}

		return String.join(" " + collation + " ", query);
	}

	@Override
	public String getQueryString(String collation) {
		if(this.comuni.isEmpty()){
			return sqlPrefix;
		}
		
		return sqlPrefix + " WHERE " + this.getFilterQueryString(collation);
	}

	@Override
	public String getNameFilter() {
		// TODO Auto-generated method stub
		return "comune :";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "3";
	}

	@Override
	public String getDatiFilter() {
		// TODO Auto-generated method stub
		/*for (String s : comuni) {
			System. out. println(s);
			}*/
		//usare solo con list view in ricerca3_controller
		List<String> list = new ArrayList<String>(comuni);
		return list.get(0);
	}

}
