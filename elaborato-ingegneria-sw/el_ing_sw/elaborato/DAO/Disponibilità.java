package elaborato.DAO;

import java.util.Date;

public class Disponibilità {
	private int id_disponibilità;
	private int id_lavoratore;
	private Date periodo; //capire che tipo usare per un intervallo
	private String comune;
	
	public Disponibilità(int id_disponibilità, int id_lavoratore, Date periodo, String comune) {
		// TODO Auto-generated constructor stub
		this.id_disponibilità=id_disponibilità;
		this.id_lavoratore=id_lavoratore;
		this.periodo=periodo;
		this.comune=comune;
	}

	public int getId_disponibilità() {
		return id_disponibilità;
	}

	public void setId_disponibilità(int id_disponibilità) {
		this.id_disponibilità = id_disponibilità;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

	public Date getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}
	

}
