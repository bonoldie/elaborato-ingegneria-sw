package elaborato.DAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Lavoro_svolto {
	private int id_lavoro_svolto;
	private int id_lavoratore;
	private LocalDate data_inizio; 
	private LocalDate data_fine; 
	private String mansione_svolta;
	private String nome_azienda;
	private String luogo_di_lavoro;
	private BigDecimal retribuzione_lorda_giornaliera;
	
	
	public Lavoro_svolto(int id_lavoro_svolto, int id_lavoratore, LocalDate data_inizio, LocalDate data_fine,
			String mansione_svolta, String nome_azienda, String luogo_di_lavoro,
			BigDecimal retribuzione_lorda_giornaliera) {
		super();
		this.id_lavoro_svolto = id_lavoro_svolto;
		this.id_lavoratore = id_lavoratore;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.mansione_svolta = mansione_svolta;
		this.nome_azienda = nome_azienda;
		this.luogo_di_lavoro = luogo_di_lavoro;
		this.retribuzione_lorda_giornaliera = retribuzione_lorda_giornaliera;
	}
	
	public int getId_lavoro_svolto() {
		return id_lavoro_svolto;
	}
	public void setId_lavoro_svolto(int id_lavoro_svolto) {
		this.id_lavoro_svolto = id_lavoro_svolto;
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
	public String getMansione_svolta() {
		return mansione_svolta;
	}
	public void setMansione_svolta(String mansione_svolta) {
		this.mansione_svolta = mansione_svolta;
	}
	public String getNome_azienda() {
		return nome_azienda;
	}
	public void setNome_azienda(String nome_azienda) {
		this.nome_azienda = nome_azienda;
	}
	public String getLuogo_di_lavoro() {
		return luogo_di_lavoro;
	}
	public void setLuogo_di_lavoro(String luogo_di_lavoro) {
		this.luogo_di_lavoro = luogo_di_lavoro;
	}
	public BigDecimal getRetribuzione_lorda_giornaliera() {
		return retribuzione_lorda_giornaliera;
	}
	public void setRetribuzione_lorda_giornaliera(BigDecimal retribuzione_lorda_giornaliera) {
		this.retribuzione_lorda_giornaliera = retribuzione_lorda_giornaliera;
	}
	
	



}
