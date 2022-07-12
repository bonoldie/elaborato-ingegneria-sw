package elaborato.DAO;

public class Lavoratore {
	private int id_lavoratore;
	private int id_anagrafica;
	private int id_recapito_urgenza;
	private String indirizzo;
	private String spec_esp; // capire come succede
	private boolean automunito;

	public Lavoratore(int id_lavoratore, int id_anagrafica, int id_recapito_urgenza, String indirizzo, String spec_esp,
			boolean automunito) {
		// TODO Auto-generated constructor stub
		super();
		this.id_lavoratore = id_lavoratore;
		this.id_anagrafica = id_anagrafica;
		this.id_recapito_urgenza = id_recapito_urgenza;
		this.indirizzo = indirizzo;
		this.spec_esp = spec_esp;
		this.automunito = automunito;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

	public int getId_anagrafica() {
		return id_anagrafica;
	}

	public void setId_anagrafica(int id_anagrafica) {
		this.id_anagrafica = id_anagrafica;
	}

	public int getId_recapito_urgenza() {
		return id_recapito_urgenza;
	}

	public void setId_recapito_urgenza(int id_recapito_urgenza) {
		this.id_recapito_urgenza = id_recapito_urgenza;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getSpec_esp() {
		return spec_esp;
	}

	public void setSpec_esp(String spec_esp) {
		this.spec_esp = spec_esp;
	}

	public boolean isAutomunito() {
		return automunito;
	}

	public void setAutomunito(boolean automunito) {
		this.automunito = automunito;
	}

}
