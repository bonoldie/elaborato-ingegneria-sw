package elaborato;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import elaborato.DAO.Lingua;
import elaborato.DAO.LinguaDAO;
import elaborato.DAO.Patente;
import elaborato.DAO.PatenteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ricerca_controller implements Initializable{

	@FXML
	private TextField id_lavoratore_r;
	
	@FXML
	private TextField nome_r;
	
	@FXML
	private TextField cognome_r;
	
	@FXML
	private TextField luogo_di_residenza_r;
	
	@FXML
	private ChoiceBox<Boolean> disponibilita_auto_r;
	
	@FXML
	private DatePicker data_inizio_r;
	
	@FXML
	private DatePicker data_fine_r;
	
	@FXML
	private ListView<Patente> patente_r;
	ObservableList<Patente> tipo_patente;
	
	@FXML
	private ListView<Lingua> lingua_r;
	ObservableList<Lingua> lingua;
	
	@FXML
	private Button ricerca_dati;
	
	@FXML
	private ListView<String> mansioni_indicate_r;
	ObservableList<String> specializzazioni = FXCollections.observableArrayList("bagnino", "barman",
			"istruttore di nuoto", "viticultore", "floricultore");
	
	@FXML
	private void ricercadati(ActionEvent event) {
		System.out.println("prova");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		LinguaDAO linguaDAO = new LinguaDAO();
		PatenteDAO patenteDAO = new PatenteDAO();

		try {
			this.lingua = FXCollections.observableArrayList(linguaDAO.getAllLingue());
			this.tipo_patente = FXCollections.observableArrayList(patenteDAO.getAllPatente());
		}catch (SQLException e) {
			System.out.println(e);
			System.out.println("Errore nel caricamento delle lingue e patenti");
			return;
		}
		
		mansioni_indicate_r.setItems(specializzazioni);
		mansioni_indicate_r.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		//
		disponibilita_auto_r.getItems().add(true);
		disponibilita_auto_r.getItems().add(false);
		//

		patente_r.setItems(tipo_patente);
		patente_r.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		lingua_r.setItems(lingua);
		lingua_r.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

}
