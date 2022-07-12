package elaborato.DAO;

public class Patente {
	private int id_patente;
	private String nome_patente;

	public Patente(int id_patente, String nome_patente) {
		super();
		this.id_patente = id_patente;
		this.nome_patente = nome_patente;
	}

	public int getId_patente() {
		return id_patente;
	}

	public void setId_patente(int id_patente) {
		this.id_patente = id_patente;
	}

	public String getNome_patente() {
		return nome_patente;
	}

	public void setNome_patente(String nome_patente) {
		this.nome_patente = nome_patente;
	}

	@Override
	public String toString() {
		return getNome_patente();
	}

}
