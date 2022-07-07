package elaborato.DAO;

import java.util.Date;

public class DisponibilitÓ {
	private int id_disponibilitÓ;
	private int id_lavoratore;
	private Date periodo; //capire che tipo usare per un intervallo
	private String comune;
	
	public DisponibilitÓ(int id_disponibilitÓ, int id_lavoratore, Date periodo, String comune) {
		// TODO Auto-generated constructor stub
		this.id_disponibilitÓ=id_disponibilitÓ;
		this.id_lavoratore=id_lavoratore;
		this.periodo=periodo;
		this.comune=comune;
	}

	public int getId_disponibilitÓ() {
		return id_disponibilitÓ;
	}

	public void setId_disponibilitÓ(int id_disponibilitÓ) {
		this.id_disponibilitÓ = id_disponibilitÓ;
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
