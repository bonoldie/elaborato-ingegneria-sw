package elaborato.DAO;

public class Recapito {
	private int id_recapito;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;

	public Recapito(int id_recapito, String nome, String cognome, String telefono, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.id_recapito = id_recapito;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}

	public int getId_recapito() {
		return id_recapito;
	}

	public void setId_recapito(int id_recapito) {
		this.id_recapito = id_recapito;
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
