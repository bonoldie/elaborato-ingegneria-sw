package elaborato.ricerca;

import java.util.HashSet;
import java.util.Set;

import elaborato.DAO.FilterAnagrafica;

public class LavoratoreFilter implements Filter<FilterAnagrafica> {
	
	//per cercare un lavoratore oltre all nome e cogonome posso passrgli l'email visto che � unique
	//oppure l'addetto � obbligato ad usare nome, cognome e email (nel caso di omonimi)
	private static String rifTabella = "a";
	private static String rifColonna_nome = "nome"; 
	private static String rifColonna_cognome = "cognome"; 
	private static String rifColonna_email = "email"; 
	
	private static String sqlPrefix = " SELECT l.id_lavoratore FROM lavoratore l LEFT JOIN anagrafica a ON a.id_anagrafica = l.id_anagrafica";
	
	Set<FilterAnagrafica> dati;
	
	public LavoratoreFilter() {
		this.dati = new HashSet<FilterAnagrafica>();
	}
	
	@Override
	public Set<FilterAnagrafica> getFilterSet() {
		// TODO Auto-generated method stub
		return this.dati;
	}

	@Override
	public Set<FilterAnagrafica> addFilterElement(FilterAnagrafica element) {
		// TODO Auto-generated method stub
		if(this.dati.isEmpty()) {
			this.dati.add(element);
		}
		return null;
	}

	@Override
	public void removeFilterElement(FilterAnagrafica element) {
		// TODO Auto-generated method stub
		this.clearFilterSet();
	}

	@Override
	public void clearFilterSet() {
		// TODO Auto-generated method stub
		this.dati.clear();
	}

	@Override
	public String getFilterQueryString(String collation) {
		// TODO Auto-generated method stub
		if(this.dati.isEmpty() || this.dati.size() != 1) {
			return "";
		}
		
		String totalfilter = null;
		
		FilterAnagrafica f = (FilterAnagrafica) this.dati.toArray()[0];
		if(f.getNome().isEmpty()==false) {
			totalfilter = rifTabella + "." + rifColonna_nome + "=" + "'" + f.getNome() + "'"; 
		}
		if(f.getCognome().isEmpty()==false) {
			if(totalfilter.isEmpty())
				totalfilter = rifTabella + "." + rifColonna_cognome + "=" + "'" + f.getCognome() + "'";
			else
				totalfilter += " AND " + rifTabella + "." + rifColonna_cognome + "=" + "'" + f.getCognome() + "'";		
		}
		if(f.getEmail().isEmpty()==false) {
			if(totalfilter.isEmpty())
				totalfilter = rifTabella + "." + rifColonna_email + "=" + "'" + f.getEmail() + "'";
			else
				totalfilter += " AND " + rifTabella + "." + rifColonna_email + "=" + "'" + f.getEmail() + "'";
		}
		return totalfilter;
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
		return "lavoratore";
	}

	@Override
	public String getIdFilter() {
		// TODO Auto-generated method stub
		return "2";
	}

}
