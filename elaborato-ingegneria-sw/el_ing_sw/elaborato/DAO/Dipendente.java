package elaborato.DAO;

public class Dipendente {
	private int id_dipendente;
	private int id_anagrafica;
	private String login;
	private String password;
	
	public Dipendente(int id_dipendente, int id_anagrafica, String login, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.id_dipendente=id_dipendente;
		this.id_anagrafica=id_anagrafica;
		this.login=login;
		this.password=password;
	}

	public int getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(int id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public int getId_anagrafica() {
		return id_anagrafica;
	}

	public void setId_anagrafica(int id_anagrafica) {
		this.id_anagrafica = id_anagrafica;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
