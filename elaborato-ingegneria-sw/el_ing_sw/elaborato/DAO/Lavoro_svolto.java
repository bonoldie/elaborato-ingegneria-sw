package elaborato.DAO;

import java.math.BigDecimal;
import java.util.Date;

public class Lavoro_svolto {
	private int id_lavoro_svolto;
	private int id_lavoratore;
	private Date periodo; // controllare se va bene il tipo
	private String nome_azienda;
	private String luogo_di_lavoro;
	private BigDecimal retribuzione_lorda_giornaliera;

	public Lavoro_svolto(int id_lavoro_svolto, int id_lavoratore, Date periodo, String nome_azienda,
			String mansione_svolta, String luogo_di_lavoro, BigDecimal retribuzione_lorda_giornaliera) {
		// TODO Auto-generated constructor stub
		super();
		this.id_lavoro_svolto = id_lavoro_svolto;
		this.id_lavoratore = id_lavoratore;
		this.periodo = periodo;
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

	public Date getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
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
