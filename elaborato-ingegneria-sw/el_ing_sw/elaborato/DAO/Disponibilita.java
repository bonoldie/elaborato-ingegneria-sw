package elaborato.DAO;

import java.time.LocalDate;
import java.util.Date;

public class Disponibilita {
	private int id_disponibilita;
	private int id_lavoratore;
	private LocalDate data_inizio; 
	private LocalDate data_fine; 
	private String comune;
	
	public Disponibilita(int id_disponibilita, int id_lavoratore, LocalDate data_inizio, LocalDate data_fine,
			String comune) {
		super();
		this.id_disponibilita = id_disponibilita;
		this.id_lavoratore = id_lavoratore;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.comune = comune;
	}

	public int getId_disponibilita() {
		return id_disponibilita;
	}

	public void setId_disponibilita(int id_disponibilita) {
		this.id_disponibilita = id_disponibilita;
	}

	public int getId_lavoratore() {
		return id_lavoratore;
	}

	public void setId_lavoratore(int id_lavoratore) {
		this.id_lavoratore = id_lavoratore;
	}

	public LocalDate getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}

	public LocalDate getData_fine() {
		return data_fine;
	}

	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	

}
