package elaborato.DAO;

public class Lavoratore_Lingua {
	private int id_lingua;
	private int id_lavoratore;

	public Lavoratore_Lingua(int id_lingua, int id_lavoratore) {
		// TODO Auto-generated constructor stub
		super();
		this.id_lingua = id_lingua;
		this.id_lavoratore = id_lavoratore;
	}

	public int getId_lingua() {
		return id_lingua;
	}

	public void setId_lingua(int id_lingua) {
		this.id_lingua = id_lingua;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

}
