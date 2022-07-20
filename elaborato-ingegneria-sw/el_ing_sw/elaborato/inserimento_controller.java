package elaborato;

import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import elaborato.DAO.Anagrafica;
import elaborato.DAO.AnagraficaDAO;
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
import elaborato.DAO.Lingua;
import elaborato.DAO.LinguaDAO;
import elaborato.DAO.Patente;
import elaborato.DAO.PatenteDAO;
import elaborato.DAO.Recapito;
import elaborato.DAO.RecapitoDAO;
import elaborato.DAO.Specializzazione;
import elaborato.DAO.SpecializzazioneDAO;
import elaborato.DB.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class inserimento_controller implements Initializable {
	// dati anagrafici
	@FXML
	private TextField nome_id;
	@FXML
	private TextField cognome_id;
	@FXML
	private TextField naz_id;
	@FXML
	private DatePicker data_n_id;
	@FXML
	private TextField luogo_id;
	@FXML
	private TextField email_id;
	@FXML
	private TextField telefono_id;
	@FXML
	private TextField indirizzo_id;
	@FXML
	private ListView<Specializzazione> spec_list_view;
	ObservableList<Specializzazione> specializzazioni;
	@FXML
	private ChoiceBox<Boolean> auto_id;
	@FXML
	private ListView<Patente> patenti_list_view;
	ObservableList<Patente> tipo_patente;
	
	@FXML
	private TextField p_nome_id;
	@FXML
	private TextField p_email_id;
	@FXML
	private TextField p_telefono_id;
	@FXML
	private TextField p_cognome_id;

	// disponibilita'
	@FXML
	private DatePicker disp_data_inizio;
	@FXML
	private DatePicker disp_data_fine;
	
	@FXML
	private TextField comune_id;

	@FXML
	private Button invio_dati_db;

	@FXML
	private ListView<Lingua> lingua_view;
	ObservableList<Lingua> lingua;

	@FXML
	private void inviodati(ActionEvent event) throws SQLException {
		AnagraficaDAO anagraficaDAO = new AnagraficaDAO();
		RecapitoDAO reacapitoDAO = new RecapitoDAO();
		LavoratoreDAO lavoratoreDAO = new LavoratoreDAO();
		DisponibilitaDAO disponibilitaDAO = new DisponibilitaDAO();
		Lavoratore_PatenteDAO lpDAO = new Lavoratore_PatenteDAO();
		Lavoratore_LinguaDAO llDAO = new Lavoratore_LinguaDAO();
		Lavoratore_EsperienzaDAO leDAO = new Lavoratore_EsperienzaDAO(); //aggiunto
	
		
		
		// vedere se fare bottoni separati per l'invio di solo alcune parti di dati come
		// patente o lingue
		// capire come indicare id di altre tabelle e passarli!!
		// st usato per ricerca degli id

		// anagrafica
		Anagrafica insertedAnagrafica = new Anagrafica(0, luogo_id.getText(), data_n_id.getValue(), naz_id.getText(),
				nome_id.getText(), cognome_id.getText(), telefono_id.getText(), email_id.getText());
		try {
			anagraficaDAO.insertAnagrafica(insertedAnagrafica);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento dell'anagrafica");
			return;
		}

		Recapito insertedRecapito = new Recapito(0, p_nome_id.getText(), p_cognome_id.getText(), p_telefono_id.getText(),
				p_email_id.getText());
		try {
			reacapitoDAO.insertRecapito(insertedRecapito);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento del recapito");
			return;
		}
		
		Lavoratore insertedLavoratore = new Lavoratore(0, insertedAnagrafica.getId_anagrafica(), insertedRecapito.getId_recapito(), indirizzo_id.getText(), auto_id.getValue());
		
		try {
			lavoratoreDAO.insertLavoratore(insertedLavoratore);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento del lavoratore");
			return;
		}
		
		/*
		Lavoratore insertedLavoro_svolto = new Lavoro_svolto(0, insertedLavoratore.getId_lavoratore().getId_recapito(), indirizzo_id.getText(), auto_id.getValue());
		
		try {
			lavoratoreDAO.insertLavoratore(insertedLavoratore);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento del lavoratore");
		}
		*/
		
		
		Disponibilita disponibilita = new Disponibilita(0, insertedLavoratore.getId_lavoratore(), disp_data_inizio.getValue(), disp_data_fine.getValue() ,comune_id.getText());

		try {
			disponibilitaDAO.insertDisponibilita(disponibilita);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento della disponibilità");
			return;
		}
		
		
		try {
			for(Patente p : patenti_list_view.getSelectionModel().getSelectedItems()) {
				lpDAO.insertLavoratore_Patente(new Lavoratore_Patente(insertedLavoratore.getId_lavoratore(), p.getId_patente()));
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento delle patenti");
			return;
		}
		
		
		
		try {
			for(Lingua l : lingua_view.getSelectionModel().getSelectedItems()) {
				llDAO.insertLavoratore_Lingua(new Lavoratore_Lingua(insertedLavoratore.getId_lavoratore(), l.getId_lingua()));
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento delle lingue");
			return;
		}
		
		//aggiunto
		try {
			for(Specializzazione s : spec_list_view.getSelectionModel().getSelectedItems()) {
				leDAO.insertLavoratore_Esperienza(new Lavoratore_Esperienza(insertedLavoratore.getId_lavoratore(), s.getId_specializzazione()));
				//.insertLavoratore_Lingua(new Lavoratore_Lingua(insertedLavoratore.getId_lavoratore(), l.getId_lingua()));
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nell'inserimento delle esperienze");
			return;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Data from DAOs
		LinguaDAO linguaDAO = new LinguaDAO();
		PatenteDAO patenteDAO = new PatenteDAO();
		SpecializzazioneDAO specDAO = new SpecializzazioneDAO();

		try {
			this.lingua = FXCollections.observableArrayList(linguaDAO.getAllLingue());
			this.tipo_patente = FXCollections.observableArrayList(patenteDAO.getAllPatente());
			this.specializzazioni = FXCollections.observableArrayList(specDAO.getAllSpecializzazione());
		}catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nel caricamento delle lingue e patenti");
			return;
		}
	

		// TODO Auto-generated method stub
		//aggiunto
		spec_list_view.setItems(specializzazioni);
		spec_list_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		//
		auto_id.getItems().add(true);
		auto_id.getItems().add(false);
		//

		patenti_list_view.setItems(tipo_patente);
		patenti_list_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		lingua_view.setItems(lingua);
		lingua_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

}
