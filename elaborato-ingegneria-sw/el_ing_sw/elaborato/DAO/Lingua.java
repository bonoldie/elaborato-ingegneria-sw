package elaborato.DAO;

public class Lingua {
	private int id_lingua;
	private String nome_lingua;
	
	public Lingua(int id_lingua, String nome_lingua) {
		// TODO Auto-generated constructor stub
		super();
		this.id_lingua=id_lingua;
		this.nome_lingua=nome_lingua;
	}

	public int getId_lingua() {
		return id_lingua;
	}

	public void setId_lingua(int id_lingua) {
		this.id_lingua = id_lingua;
	}

	public String getNome_lingua() {
		return nome_lingua;
	}

	public void setNome_lingua(String nome_lingua) {
		this.nome_lingua = nome_lingua;
	}
	

}
