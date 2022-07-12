package elaborato.DAO;

import java.util.Date;

public class Disponibilita {
	private int id_disponibilita;
	private int id_lavoratore;
	private Date periodo; // capire che tipo usare per un intervallo
	private String comune;

	public Disponibilita(int id_disponibilita, int id_lavoratore, Date periodo, String comune) {
		// TODO Auto-generated constructor stub
		this.id_disponibilita = id_disponibilita;
		this.id_lavoratore = id_lavoratore;
		this.periodo = periodo;
		this.comune = comune;
	}

	public int getId_disponibilita()
	{
		return id_disponibilita;
	}

	public void setId_disponibilita(int id_disponibilita)
	{
		this.id_disponibilita = id_disponibilita;
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
