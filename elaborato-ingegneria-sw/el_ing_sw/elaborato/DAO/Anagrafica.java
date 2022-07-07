package elaborato.DAO;

import java.util.Date;

public class Anagrafica {
	private int id_anagrafica;
	private String luogo_di_nascita;
	private Date data_di_nascita; //esiste anche il date di sql 
	private String nazionalità;
	private String nome;
	private String cognome;
	private String telefono; //attenzione check db
	private String email;
	
	public Anagrafica(int id_anagrafica, String luogo_di_nascita, Date data_di_nascita, String nazionalità, String nome, String cognome, String telefono, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.id_anagrafica=id_anagrafica;
		this.luogo_di_nascita=luogo_di_nascita;
		this.data_di_nascita = data_di_nascita;
		this.nazionalità = nazionalità;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}

	public int getId_anagrafica() {
		return id_anagrafica;
	}

	public void setId_anagrafica(int id_anagrafica) {
		this.id_anagrafica = id_anagrafica;
	}

	public String getLuogo_di_nascita() {
		return luogo_di_nascita;
	}

	public void setLuogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
	}

	public Date getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(Date data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	public String getNazionalità() {
		return nazionalità;
	}

	public void setNazionalità(String nazionalità) {
		this.nazionalità = nazionalità;
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
	

}
