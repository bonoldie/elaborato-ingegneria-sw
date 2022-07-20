package elaborato;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import elaborato.DAO.Lingua;
import elaborato.DAO.LinguaDAO;
import elaborato.DAO.Specializzazione;
import elaborato.DAO.SpecializzazioneDAO;
import elaborato.ricerca.Filter;
import elaborato.ricerca.LinguaFilter;
import elaborato.ricerca.SpecializzazioneFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class specializzazione_controller implements Initializable{
	@FXML
	private Button invio_dati;
	@FXML
	private ListView<Specializzazione> specializzazioni_view;
	ObservableList<Specializzazione> spec;
	
	private SpecializzazioneFilter filtro;
	
	@FXML 
	public void getspec_oa(ActionEvent event) {
		// TODO Autogenerated
		SpecializzazioneFilter sf= new SpecializzazioneFilter();
		
		//solo una sola lingua
		//lf.addFilterElement(lingue.getSelectionModel().getSelectedItem());
		
		//passo piu lingue
		for(Specializzazione s : specializzazioni_view.getSelectionModel().getSelectedItems()) {
			sf.addFilterElement(s);
		}
		
		filtro = sf;
		System.out.printf("%s",filtro.getQueryString("and"));
		
		invio_dati.getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		SpecializzazioneDAO specDAO = new SpecializzazioneDAO();
		
		try {
			this.spec = FXCollections.observableArrayList(specDAO.getAllSpecializzazione());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		specializzazioni_view.setItems(spec);
		specializzazioni_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	public Filter getfilter() {
		// TODO Auto-generated method stub
		return filtro;
	}
}
