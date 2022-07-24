package elaborato;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import elaborato.DAO.Anagrafica;
import elaborato.DAO.AnagraficaDAO;
import elaborato.DAO.Anagrafiche_Lavoratori;
import elaborato.DAO.Anagrafiche_LavoratoriDAO;
import elaborato.DAO.Disponibilita;
import elaborato.DAO.DisponibilitaDAO;
import elaborato.DAO.Lavoratore;
import elaborato.DAO.LavoratoreDAO;
import elaborato.DAO.Lavoratore_Esperienza;
import elaborato.DAO.Lavoratore_EsperienzaDAO;
import elaborato.DAO.Lavoratore_Lingua;
import elaborato.DAO.Lavoratore_LinguaDAO;
import elaborato.DAO.Lavoratore_Patente;
import elaborato.DAO.Lavoratore_PatenteDAO;
import elaborato.DAO.Lavoro_svolto;
import elaborato.DAO.Lavoro_svoltoDAO;
import elaborato.DAO.Lingua;
import elaborato.DAO.LinguaDAO;
import elaborato.DAO.Patente;
import elaborato.DAO.PatenteDAO;
import elaborato.DAO.Recapito;
import elaborato.DAO.RecapitoDAO;
import elaborato.DAO.Specializzazione;
import elaborato.DAO.SpecializzazioneDAO;
import elaborato.DB.Database;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class edit_lavoratore_controller implements Initializable {
	private int lavoratoreId;

	LavoratoreDAO lavoratoreDAO = new LavoratoreDAO();
	AnagraficaDAO anagraficaDAO = new AnagraficaDAO();

	// Lavoratore_EsperienzaDAO lavoratoreEsperienzaDAO = new
	// Lavoratore_EsperienzaDAO();

	LinguaDAO linguaDAO = new LinguaDAO();
	Lavoratore_LinguaDAO lavoratoreLinguaDAO = new Lavoratore_LinguaDAO();

	PatenteDAO patenteDAO = new PatenteDAO();
	Lavoratore_PatenteDAO lavoratorePatenteDAO = new Lavoratore_PatenteDAO();

	SpecializzazioneDAO specDAO = new SpecializzazioneDAO(); // AGGIUNTA
	Lavoratore_EsperienzaDAO lavoratoreEsperienzaDAO = new Lavoratore_EsperienzaDAO(); // AGGIUNTA

	DisponibilitaDAO disponibilitaDAO = new DisponibilitaDAO();

	RecapitoDAO recapitoDAO = new RecapitoDAO();

	// Fields

	@FXML
	TextField nome_tf;

	@FXML
	TextField cognome_tf;

	@FXML
	TextField nazionalita_tf;

	@FXML
	DatePicker data_nascita_dp;

	@FXML
	TextField indirizzo_tf;

	@FXML
	TextField luogo_di_nascita_tf;

	@FXML
	TextField email_tf;

	@FXML
	TextField telefono_tf;

	@FXML
	ListView<Specializzazione> specializzazioni_lw; // MODIFICA

	@FXML
	CheckBox automunito_cb;

	@FXML
	TextField nome_em_tf;

	@FXML
	TextField cognome_em_tf;

	@FXML
	TextField email_em_tf;

	@FXML
	TextField telefono_em_tf;

	@FXML
	DatePicker disp_data_inizio_dp;

	@FXML
	DatePicker disp_data_fine_dp;

	@FXML
	TextField disp_comune_tf;

	@FXML
	ListView<Patente> patenti_lw;

	@FXML
	ListView<Lingua> lingue_lw;

	@FXML
	private void salva_edit_lavoratore(ActionEvent event) {

		try {
			// Prima convalito i vari campi
			this.validateFields();
		} catch (Exception e) {
			this.displayError(e.getMessage());
			return;
		}

		try {
			// Disabilita auto-commit
			Database.getDatabase().getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (this.lavoratoreId < 0) {
			// INSERT
			Anagrafica anagrafica = new Anagrafica(0, luogo_di_nascita_tf.getText(), data_nascita_dp.getValue(),
					nazionalita_tf.getText(), nome_tf.getText(), cognome_tf.getText(), telefono_tf.getText(),
					email_tf.getText());
			Recapito recapito = new Recapito(0, nome_em_tf.getText(), cognome_em_tf.getText(), telefono_em_tf.getText(),
					email_em_tf.getText());

			try {
				anagraficaDAO.insertAnagrafica(anagrafica);
				recapitoDAO.insertRecapito(recapito);

				Lavoratore lavoratore = new Lavoratore(0, anagrafica.getId_anagrafica(), recapito.getId_recapito(),
						indirizzo_tf.getText(), automunito_cb.isSelected());
				lavoratoreDAO.insertLavoratore(lavoratore);

				disponibilitaDAO.insertDisponibilita(new Disponibilita(0, lavoratore.getId_lavoratore(),
						disp_data_inizio_dp.getValue(), disp_data_fine_dp.getValue(), disp_comune_tf.getText()));

				lavoratorePatenteDAO.sync(lavoratore, patenti_lw.getSelectionModel().getSelectedItems());
				lavoratoreLinguaDAO.sync(lavoratore, lingue_lw.getSelectionModel().getSelectedItems());
				lavoratoreEsperienzaDAO.sync(lavoratore, specializzazioni_lw.getSelectionModel().getSelectedItems());

				Database.getDatabase().getConnection().commit();
			} catch (Exception e) {

				try {
					Database.getDatabase().getConnection().rollback();
					Database.getDatabase().getConnection().setAutoCommit(true);
				} catch (SQLException eRollback) {
					eRollback.printStackTrace();
				}

				this.displayError(e.getMessage());
				return;
			}

		} else {
			try {

				Lavoratore lavoratore;

				lavoratore = lavoratoreDAO.getLavoratore(lavoratoreId);
				lavoratore.setIndirizzo(indirizzo_tf.getText());
				lavoratore.setAutomunito(automunito_cb.isSelected());
				lavoratoreDAO.updateLavoratore(lavoratore);

				Anagrafica anagrafica = new Anagrafica(lavoratore.getId_anagrafica(), luogo_di_nascita_tf.getText(),
						data_nascita_dp.getValue(), nazionalita_tf.getText(), nome_tf.getText(), cognome_tf.getText(),
						telefono_tf.getText(), email_tf.getText());
				anagraficaDAO.updateAnagrafica(anagrafica);

				Recapito recapito = new Recapito(lavoratore.getId_recapito_urgenza(), nome_em_tf.getText(),
						cognome_em_tf.getText(), telefono_em_tf.getText(), email_em_tf.getText());
				recapitoDAO.updateRecapito(recapito);

				Disponibilita disponibilita;
				disponibilita = disponibilitaDAO.getDisponibilitaByLavoratoreId(lavoratore.getId_lavoratore());
				disponibilita.setComune(disp_comune_tf.getText());
				disponibilita.setData_inizio(disp_data_inizio_dp.getValue());
				disponibilita.setData_fine(disp_data_fine_dp.getValue());
				disponibilitaDAO.updateDisponibilita(disponibilita);

				lavoratorePatenteDAO.sync(lavoratore,
						this.automunito_cb.isSelected() ? patenti_lw.getSelectionModel().getSelectedItems()
								: new ArrayList<Patente>());
				lavoratoreLinguaDAO.sync(lavoratore, lingue_lw.getSelectionModel().getSelectedItems());
				lavoratoreEsperienzaDAO.sync(lavoratore, specializzazioni_lw.getSelectionModel().getSelectedItems());

				Database.getDatabase().getConnection().commit();
			} catch (SQLException e) {
				try {
					Database.getDatabase().getConnection().rollback();
					Database.getDatabase().getConnection().setAutoCommit(true);
				} catch (SQLException eRollback) {
					eRollback.printStackTrace();
				}
				this.displayError(e.getMessage());
				return;
			}
		}

		// Abilita auto-commit
		try {
			Database.getDatabase().getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.chiudi_edit_lavoratore(null);
	}

	private void displayError(String message) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Dati invalidi");
		alert.setHeaderText("Dati invalidi");
		alert.setContentText(message);
		alert.getButtonTypes().setAll(ButtonType.CLOSE);

		alert.show();

		Timeline closingAlertAnimation = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
			alert.close();
		}));

		closingAlertAnimation.setCycleCount(1);
		closingAlertAnimation.play();
	}

	public void validateFields() throws Exception {
		if (!Pattern.compile("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$").matcher(disp_data_inizio_dp.getValue().toString())
				.matches()
				|| !Pattern.compile("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$").matcher(disp_data_fine_dp.getValue().toString())
						.matches()) {
			throw new Exception("Date di disponibilità non valide");
		}
		
		if (!Pattern.compile("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$").matcher(data_nascita_dp.getValue().toString())
				.matches()) {
			throw new Exception("Data di nascita non valida");
		}
		
		// RFC 5322 
		if (!Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(email_em_tf.getText()).matches()
				|| !Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(email_tf.getText()).matches()) {
			throw new Exception("Email non valida");
		}
		
		if (disp_data_inizio_dp.getValue().isBefore(data_nascita_dp.getValue())) {
			throw new Exception("Data di inizio disponibilità antecedente alla data di nascita");
		}

		if (disp_data_inizio_dp.getValue().isAfter(disp_data_fine_dp.getValue())) {
			throw new Exception("Data di inizio disponibilità successiva alla data di fine disponibilità");
		}
		
		if (data_nascita_dp.getValue().isAfter(LocalDate.now())) {
			throw new Exception("Data di nascita non valida");
		}

		if (telefono_tf.getText().length() != 10) {
			throw new Exception("Campo telefono di anagrafica non valido");
		}

		if (telefono_em_tf.getText().length() != 10) {
			throw new Exception("Campo telefono di recapito non valido");
		}
	}

	@FXML
	private void chiudi_edit_lavoratore(ActionEvent event) {
		((Stage) nome_tf.getScene().getWindow()).close();
	}

	public void setLavoratoreId(int lavoratoreId) {
		this.lavoratoreId = lavoratoreId;

		this.syncFields();
	}

	public void clearFields() {
		nome_tf.clear();
		cognome_tf.clear();
		nazionalita_tf.clear();
		data_nascita_dp.setValue(LocalDate.now());
		luogo_di_nascita_tf.clear();
		indirizzo_tf.clear();
		telefono_tf.clear();
		specializzazioni_lw.getSelectionModel().clearSelection();
		automunito_cb.setSelected(false);
		nome_em_tf.clear();
		cognome_em_tf.clear();
		email_em_tf.clear();
		telefono_em_tf.clear();
		disp_data_inizio_dp.setValue(LocalDate.now());
		disp_data_fine_dp.setValue(LocalDate.now());
		disp_comune_tf.clear();
		lingue_lw.getSelectionModel().clearSelection();

		patenti_lw.getSelectionModel().clearSelection();
		this.patenti_lw.setDisable(!automunito_cb.isSelected());
	}

	private void syncFields() {
		if (this.lavoratoreId < 0) {
			this.clearFields();
			return;
		}

		try {
			Lavoratore lavoratore = lavoratoreDAO.getLavoratore(lavoratoreId);
			Anagrafica anagrafica = anagraficaDAO.getAnagrafica(lavoratore.getId_anagrafica());
			Recapito recapito = recapitoDAO.getRecapito(lavoratore.getId_recapito_urgenza());
			Disponibilita disponibilita = disponibilitaDAO
					.getDisponibilitaByLavoratoreId(lavoratore.getId_lavoratore());

			List<Lavoratore_Esperienza> lavoratoreEsperienza = lavoratoreEsperienzaDAO
					.getLavoratore_esperienza(lavoratore.getId_lavoratore());
			List<Lavoratore_Patente> lavoratorePatente = lavoratorePatenteDAO
					.getLavoratore_Patente(lavoratore.getId_lavoratore());
			List<Lavoratore_Lingua> lavoratoreLingue = lavoratoreLinguaDAO
					.getLavoratore_Lingua(lavoratore.getId_lavoratore());

			nome_tf.setText(anagrafica.getNome());
			cognome_tf.setText(anagrafica.getCognome());
			nazionalita_tf.setText(anagrafica.getNazionalita());
			luogo_di_nascita_tf.setText(anagrafica.getLuogo_di_nascita());
			telefono_tf.setText(anagrafica.getTelefono());
			email_tf.setText(anagrafica.getEmail());
			data_nascita_dp.setValue(anagrafica.getData_di_nascita());
			indirizzo_tf.setText(lavoratore.getIndirizzo());
			automunito_cb.setSelected(lavoratore.isAutomunito());

			// specializzazioni_cb.getSelectionModel();

			nome_em_tf.setText(recapito.getNome());
			cognome_em_tf.setText(recapito.getCognome());
			email_em_tf.setText(recapito.getEmail());
			telefono_em_tf.setText(recapito.getTelefono());

			disp_data_inizio_dp.setValue(disponibilita.getData_inizio());
			disp_data_fine_dp.setValue(disponibilita.getData_fine());
			disp_comune_tf.setText(disponibilita.getComune());

			patenti_lw.getItems().forEach(p -> {
				lavoratorePatente.forEach(lp -> {
					if (p.getId_patente() == lp.getId_patente()) {
						int index = patenti_lw.getItems().indexOf(p);
						patenti_lw.getSelectionModel().select(index);
						patenti_lw.getFocusModel().focus(index);
					}
				});
			});

			// AGGIUNTA
			specializzazioni_lw.getItems().forEach(s -> {
				lavoratoreEsperienza.forEach(le -> {
					if (s.getId_specializzazione() == le.getId_esperienza()) {
						int index = specializzazioni_lw.getItems().indexOf(s);
						specializzazioni_lw.getSelectionModel().select(index);
						specializzazioni_lw.getFocusModel().focus(index);
					}
				});
			});

			lingue_lw.getItems().forEach(l -> {
				lavoratoreLingue.forEach(ll -> {
					if (l.getId_lingua() == ll.getId_lingua()) {
						int index = lingue_lw.getItems().indexOf(l);
						lingue_lw.getSelectionModel().select(index);
						lingue_lw.getFocusModel().focus(index);
					}
				});
			});

			this.patenti_lw.setDisable(!automunito_cb.isSelected());
		} catch (SQLException e) {
			this.displayError(e.getMessage());
			return;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.lingue_lw.setItems(FXCollections.observableArrayList(linguaDAO.getAllLingue()));
			this.patenti_lw.setItems(FXCollections.observableArrayList(patenteDAO.getAllPatente()));
			this.specializzazioni_lw.setItems(FXCollections.observableArrayList(specDAO.getAllSpecializzazione()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Attiva/Disattiva le patatenti
		automunito_cb.setOnMouseClicked(e -> {
			this.patenti_lw.setDisable(!automunito_cb.isSelected());
		});

		this.lingue_lw.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.patenti_lw.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.specializzazioni_lw.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // AGGIUNTA

		this.setLavoratoreId(-1);
	}
}
