package elaborato.DAO;

public class Lavoratore_Esperienza {
	private int id_lavoratore;
	private int id_esperienza;
	
	public Lavoratore_Esperienza(int id_lavoratore, int id_esperienza) {
		super();
		this.id_lavoratore = id_lavoratore;
		this.id_esperienza = id_esperienza;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

	public int getId_esperienza() {
		return id_esperienza;
	}

	public void setId_esperienza(int id_esperienza) {
		this.id_esperienza = id_esperienza;
	}

}
