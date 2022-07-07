package elaborato.DAO;

import java.util.Date;

public class Disponibilit� {
	private int id_disponibilit�;
	private int id_lavoratore;
	private Date periodo; //capire che tipo usare per un intervallo
	private String comune;
	
	public Disponibilit�(int id_disponibilit�, int id_lavoratore, Date periodo, String comune) {
		// TODO Auto-generated constructor stub
		this.id_disponibilit�=id_disponibilit�;
		this.id_lavoratore=id_lavoratore;
		this.periodo=periodo;
		this.comune=comune;
	}

	public int getId_disponibilit�() {
		return id_disponibilit�;
	}

	public void setId_disponibilit�(int id_disponibilit�) {
		this.id_disponibilit� = id_disponibilit�;
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
