package elaborato;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import elaborato.DAO.Anagrafica;
import elaborato.DAO.AnagraficaDAO;
import elaborato.DAO.Anagrafiche_Lavoratori;
import elaborato.DAO.Anagrafiche_LavoratoriDAO;
import elaborato.DAO.Lavoratore;
import elaborato.DAO.LavoratoreDAO;
import elaborato.DAO.Lavoro_svolto;
import elaborato.DAO.Lavoro_svoltoDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class edit_lavoro_svolto_controller implements Initializable {

	private Lavoro_svolto lavoro_svolto;
	private Lavoro_svoltoDAO lsDAO = new Lavoro_svoltoDAO();
	private Anagrafiche_LavoratoriDAO anagLavDAO = new Anagrafiche_LavoratoriDAO();

	@FXML
	TextField id_lavoratore_tf;
	
	@FXML
	ChoiceBox<Anagrafiche_Lavoratori> id_lavoratore_cb;
	

	@FXML
	DatePicker data_inizio_dp;

	@FXML
	DatePicker data_fine_dp;

	@FXML
	TextField nome_azienda_tf;

	@FXML
	TextField luogo_lavoro_tf;

	@FXML
	TextField mansione_tf;

	@FXML
	TextField retribuzione_tf;

	@FXML
	Button chiudi_bt;

	@FXML
	private void salva_lavoro_svolto(ActionEvent event) {
		Lavoro_svolto updatedLavoroSvolto = new Lavoro_svolto(0, id_lavoratore_cb.getValue().getId_lavoratore(),
				data_inizio_dp.getValue(), data_fine_dp.getValue(), mansione_tf.getText(), nome_azienda_tf.getText(),
				luogo_lavoro_tf.getText(), new BigDecimal(retribuzione_tf.getText()));
		
		try {
			if (this.lavoro_svolto.getId_lavoro_svolto() != 0) {
				
				updatedLavoroSvolto.setId_lavoro_svolto(this.lavoro_svolto.getId_lavoro_svolto());
		
				lsDAO.updateLavoro_svolto(updatedLavoroSvolto);
			} else {
				
				lsDAO.insertLavoro_svolto(updatedLavoroSvolto);
			}	
			
			((Stage) chiudi_bt.getScene().getWindow()).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void chiudi_lavoro_svolto(ActionEvent event) {
		((Stage) chiudi_bt.getScene().getWindow()).close();
	}

	public void setLavoroSvoltoInstance(Lavoro_svolto ls) {
		this.lavoro_svolto = ls;
		
		this.syncFields();
	}

	private void syncFields() {
		if(this.lavoro_svolto.getId_lavoratore() != 0) {
			try {
				id_lavoratore_cb.setValue(this.anagLavDAO.getAnagrafiche_Lavoratori(this.lavoro_svolto.getId_lavoratore()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Sto modificando un record esistente quindi disabilito la modifica del lavoratore
		id_lavoratore_cb.setDisable(this.lavoro_svolto.getId_lavoro_svolto() != 0);
		
		data_inizio_dp.setValue(this.lavoro_svolto.getData_inizio());
		data_fine_dp.setValue(this.lavoro_svolto.getData_fine());
		nome_azienda_tf.setText(this.lavoro_svolto.getNome_azienda());
		luogo_lavoro_tf.setText(this.lavoro_svolto.getLuogo_di_lavoro());
		mansione_tf.setText(this.lavoro_svolto.getMansione_svolta());
		retribuzione_tf.setText(this.lavoro_svolto.getRetribuzione_lorda_giornaliera().toString());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			this.id_lavoratore_cb.setItems(FXCollections.observableArrayList(this.anagLavDAO.getAllAnagrafiche_Lavoratori()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.setLavoroSvoltoInstance(
				new Lavoro_svolto(0, 0, LocalDate.now(), LocalDate.now(), "", "", "", new BigDecimal(0)));
	}

}
