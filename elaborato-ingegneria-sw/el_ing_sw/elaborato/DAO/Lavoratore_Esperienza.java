package elaborato.DAO;

public class Lavoratore_Esperienza {
	private int id_lavoratore;
	private String esperienza;
	
	public Lavoratore_Esperienza(int id_lavoratore, String esperienza) {
		super();
		this.id_lavoratore = id_lavoratore;
		this.esperienza = esperienza;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

	public String getEsperienza() {
		return esperienza;
	}

	public void setEsperienza(String esperienza) {
		this.esperienza = esperienza;
	}

}
