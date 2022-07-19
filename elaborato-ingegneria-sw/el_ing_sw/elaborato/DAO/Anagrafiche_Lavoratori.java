package elaborato.DAO;

import java.time.LocalDate;

public class Anagrafiche_Lavoratori {
	private int id_lavoratore;
	private int id_anagrafica;
	private int id_recapito_urgenza;
	private String indirizzo;
	private boolean automunito;
	private String luogo_di_nascita;
	private LocalDate data_di_nascita;
	private String nazionalita;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;

	public Anagrafiche_Lavoratori(int id_lavoratore, int id_anagrafica, int id_recapito_urgenza, String indirizzo,
			boolean automunito, String luogo_di_nascita, LocalDate data_di_nascita, String nazionalita, String nome,
			String cognome, String telefono, String email) {
		super();
		this.id_lavoratore = id_lavoratore;
		this.id_anagrafica = id_anagrafica;
		this.id_recapito_urgenza = id_recapito_urgenza;
		this.indirizzo = indirizzo;
		this.automunito = automunito;
		this.luogo_di_nascita = luogo_di_nascita;
		this.data_di_nascita = data_di_nascita;
		this.nazionalita = nazionalita;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
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

	public boolean isAutomunito() {
		return automunito;
	}

	public void setAutomunito(boolean automunito) {
		this.automunito = automunito;
	}

	public String getLuogo_di_nascita() {
		return luogo_di_nascita;
	}

	public void setLuogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
	}

	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "[" + this.getId_lavoratore() + "]" + this.getNome() + " " + this.getCognome();
	}

}
