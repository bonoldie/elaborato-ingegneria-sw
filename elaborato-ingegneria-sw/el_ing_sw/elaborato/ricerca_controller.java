package elaborato;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import elaborato.DAO.FilterAnagrafica;
import elaborato.DAO.Lingua;
import elaborato.DAO.LinguaDAO;
import elaborato.DAO.Patente;
import elaborato.DAO.PatenteDAO;
import elaborato.DAO.Specializzazione;
import elaborato.DAO.SpecializzazioneDAO;
import elaborato.ricerca.AutomunitoFilter;
import elaborato.ricerca.DisponibilitaComuneFilter;
import elaborato.ricerca.DisponibilitaDataFilter;
import elaborato.ricerca.Filter;
import elaborato.ricerca.LavoratoreFilter;
import elaborato.ricerca.LinguaFilter;
import elaborato.ricerca.PatenteFilter;
import elaborato.ricerca.SpecializzazioneFilter;
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
	
	List<Filter> filters;
	
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
	private ListView<Specializzazione> mansioni_indicate_r;
	ObservableList<Specializzazione> specializzazioni;
	
	@FXML
	private void ricercadati(ActionEvent event) {
		this.filters.forEach(f -> System.out.println(f.getQueryString("AND")));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.filters = new ArrayList<>();
		
		LinguaDAO linguaDAO = new LinguaDAO();
		PatenteDAO patenteDAO = new PatenteDAO();
		SpecializzazioneDAO specDAO = new SpecializzazioneDAO();
		
		// Filters test !! NEW !! 
		//PatenteFilter pf = new PatenteFilter();
		//DisponibilitaDataFilter dispDataInizioFilter = new DisponibilitaDataFilter("data_inizio", ">");
		//DisponibilitaDataFilter dispDataFineFilter = new DisponibilitaDataFilter("data_fine", "<");
		//DisponibilitaComuneFilter dispComuneFilter = new DisponibilitaComuneFilter();
		//LinguaFilter lf = new LinguaFilter();
		//SpecializzazioneFilter sf = new SpecializzazioneFilter();
		//filter automunito
		LavoratoreFilter laf =  new LavoratoreFilter();
		AutomunitoFilter af = new AutomunitoFilter();
		
		/*try {
			patenteDAO.getAllPatente().forEach(p -> {
				pf.addFilterElement(p);
			});
			
			dispDataInizioFilter.addFilterElement(LocalDate.now());
			dispDataFineFilter.addFilterElement(LocalDate.now());
			
			linguaDAO.getAllLingue().forEach(l -> {
				lf.addFilterElement(l);
			});
			
			dispComuneFilter.addFilterElement("Civitanova Marche");
			
			specDAO.getAllSpecializzazione().forEach(s -> {
				sf.addFilterElement(s);
			});*/
			FilterAnagrafica test = new FilterAnagrafica("pietro","ronca","prova@");
			laf.addFilterElement(test);
			af.addFilterElement(true);
			
		/*} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Errore nella creazione dei filtri di test");
		}*/
		
		//this.filters.addAll(Arrays.asList(pf, dispDataInizioFilter, dispDataFineFilter, dispComuneFilter, lf, sf));
		this.filters.addAll(Arrays.asList(laf, af));
		
		try {
			this.lingua = FXCollections.observableArrayList(linguaDAO.getAllLingue());
			this.tipo_patente = FXCollections.observableArrayList(patenteDAO.getAllPatente());
			this.specializzazioni = FXCollections.observableArrayList(specDAO.getAllSpecializzazione());
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
