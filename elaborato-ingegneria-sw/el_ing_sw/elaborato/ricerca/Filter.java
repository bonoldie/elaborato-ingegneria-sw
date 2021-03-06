package elaborato.ricerca;

import java.util.Set;

public interface Filter<T extends Object> {
	public Set<T> getFilterSet();
	public Set<T> addFilterElement(T element);
	public void removeFilterElement(T element);
	public void clearFilterSet();
	
	public String getFilterQueryString(String collation);
	public String getQueryString(String collation);
	public String getNameFilter();
	public String getIdFilter();
	
	//lo uso per ritornarmi le varibaili inserite
	public String getDatiFilter();
}
