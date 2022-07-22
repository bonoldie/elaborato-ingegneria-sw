package elaborato;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

import elaborato.ricerca.AutomunitoFilter;
import elaborato.ricerca.Filter;
import javafx.event.ActionEvent;

import javafx.scene.control.ChoiceBox;

public class automunito_controller implements Initializable{
	@FXML
	private CheckBox automunito_cb;
	@FXML
	private Button invio_dati;
	
	private AutomunitoFilter filtro;

	// Event Listener on Button[#invio_dati].onAction
	public AutomunitoFilter getfilter() {
		return filtro;
	}
	
	@FXML
	public void getautomunito_oa(ActionEvent event) {
		//deve ritornare i valori per la listview
		//ritorna un filtro automunito
		AutomunitoFilter af= new AutomunitoFilter();
		af.addFilterElement(automunito_cb.isSelected());
		filtro = af;		
		System.out.printf("%s",filtro.getQueryString(null));
		invio_dati.getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
