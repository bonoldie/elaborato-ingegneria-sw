package elaborato.DAO;

public class Specializzazione {
	private int id_specializzazione;
	private String nome_specializzazione;
	
	public Specializzazione(int id_specializzazione, String nome_specializzazione) {
		super();
		this.id_specializzazione = id_specializzazione;
		this.nome_specializzazione = nome_specializzazione;
	}
	
	public int getId_specializzazione() {
		return id_specializzazione;
	}
	
	public void setId_specializzazione(int id_specializzazione) {
		this.id_specializzazione = id_specializzazione;
	}
	
	public String getNome_specializzazione() {
		return nome_specializzazione;
	}
	
	public void setNome_specializzazione(String nome_specializzazione) {
		this.nome_specializzazione = nome_specializzazione;
	}
	
	@Override
	public String toString() {
		return this.getNome_specializzazione();
	}
	
}
