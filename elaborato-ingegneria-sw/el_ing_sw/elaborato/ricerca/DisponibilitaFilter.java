package elaborato.ricerca;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DisponibilitaFilter implements Filter<LocalDate> {
	
	private static String rifTabella = "d";
	private String rifColonna;
	private String rifOperator;

	private static String sqlPrefix = "SELECT l.id_lavoratore FROM lavoratore l left join disponibilita d ON  d.id_lavoratore = l.id_lavoratore";
	
	Set<LocalDate> date;
	
	public DisponibilitaFilter(String rifColonna, String rifOperator) {
		this.rifColonna = rifColonna;
		this.rifOperator = rifOperator;
		
		this.date = new HashSet<>();
	}
	
	@Override
	public Set<LocalDate> getFilterSet() {
		return this.date;
	}

	@Override
	public Set<LocalDate> addFilterElement(LocalDate element) {
		if(this.date.isEmpty()) {
			this.date.add(element);
		}
		return null;
	}

	@Override
	public void removeFilterElement(LocalDate element) {
		this.clearFilterSet();
	}

	@Override
	public void clearFilterSet() {
		this.date.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		if(this.date.isEmpty() || this.date.size() != 1) {
			return "";
		}
		
		LocalDate d = (LocalDate) this.date.toArray()[0];
	
		return rifTabella + "." + this.rifColonna + this.rifOperator +"'" + d.toString() + "' ";
	}

	@Override
	public String getQueryString(String collation) {
		if(this.date.isEmpty()){
			return sqlPrefix;
		}
		
		return sqlPrefix + " WHERE " + this.getFilterQueryString(collation);
	}
	
}
