package elaborato.ricerca;

import java.util.Set;

public interface Filter<T> {
	public Set<T> getFilterSet();
	public Set<T> addFilterElement(T element);
	public void removeFilterElement(T element);
	public void clearFilterSet();
	
	public String getFilterQueryString(String collation);
	
}
