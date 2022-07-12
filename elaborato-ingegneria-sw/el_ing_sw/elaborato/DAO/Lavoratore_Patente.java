package elaborato.DAO;

public class Lavoratore_Patente {
	private int id_patente;
	private int id_lavoratore;

	public Lavoratore_Patente(int id_patente, int id_lavoratore) {
		// TODO Auto-generated constructor stub
		this.id_patente = id_patente;
		this.id_lavoratore = id_lavoratore;
	}

	public int getId_patente() {
		return id_patente;
	}

	public void setId_patente(int id_patente) {
		this.id_patente = id_patente;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

}
