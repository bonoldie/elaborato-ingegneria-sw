package elaborato.DAO;

public class Lavoratore_View {
	private int id_lavoratore;
	private String esperienza;
	private String lingue;
	private String periodo_di_disponibilità;
	private String patenti_lavoratore;
	private String comuni_disponibili;
	
	public Lavoratore_View(int id_lavoratore, String esperienza, String lingue, String periodo_di_disponibilità,
			String patenti_lavoratore, String comuni_disponibili) {
		super();
		this.id_lavoratore = id_lavoratore;
		this.esperienza = esperienza;
		this.lingue = lingue;
		this.periodo_di_disponibilità = periodo_di_disponibilità;
		this.patenti_lavoratore = patenti_lavoratore;
		this.comuni_disponibili = comuni_disponibili;
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
	
	public String getLingue() {
		return lingue;
	}
	
	public void setLingue(String lingue) {
		this.lingue = lingue;
	}
	
	public String getPeriodo_di_disponibilità() {
		return periodo_di_disponibilità;
	}
	
	public void setPeriodo_di_disponibilità(String periodo_di_disponibilità) {
		this.periodo_di_disponibilità = periodo_di_disponibilità;
	}
	
	public String getPatenti_lavoratore() {
		return patenti_lavoratore;
	}
	
	public void setPatenti_lavoratore(String patenti_lavoratore) {
		this.patenti_lavoratore = patenti_lavoratore;
	}
	
	public String getComuni_disponibili() {
		return comuni_disponibili;
	}
	
	public void setComuni_disponibili(String comuni_disponibili) {
		this.comuni_disponibili = comuni_disponibili;
	}
	
}
