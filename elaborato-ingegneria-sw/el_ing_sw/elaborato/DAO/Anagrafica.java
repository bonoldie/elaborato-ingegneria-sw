package elaborato.DAO;
import java.time.LocalDate;

public class Anagrafica {
	private int id_anagrafica;
	private String luogo_di_nascita;
	private LocalDate data_di_nascita; // esiste anche il LocalDate di sql
	private String nazionalita;
	private String nome;
	private String cognome;
	private String telefono; // attenzione check db
	private String email;

	public Anagrafica(int id_anagrafica, String luogo_di_nascita, LocalDate data_di_nascita, String nazionalita, String nome, String cognome, String telefono, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.id_anagrafica=id_anagrafica;
		this.luogo_di_nascita=luogo_di_nascita;
		this.data_di_nascita = data_di_nascita;
		this.nazionalita = nazionalita;
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

	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	public String getNazionalita()
	{
		return nazionalita;
	}

	public void setNazionalita(String nazionalita)
	{
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

}
