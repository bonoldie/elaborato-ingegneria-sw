package elaborato.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

import elaborato.ricerca.DisponibilitaComuneFilter;
import elaborato.ricerca.DisponibilitaDataFilter;
import elaborato.ricerca.Filter;
import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;

public class PeriodoController implements Initializable {
	@FXML
	private Button invio_data;
	@FXML
	private DatePicker data;
	@FXML
	private ChoiceBox<String> data_if;
	@FXML
	private ChoiceBox<String> operatore;

	private DisponibilitaDataFilter filtro;

	// Event Listener on Button[#invio_data].onAction
	@FXML
	public void getperiodo_oa(ActionEvent event) { // da completare
		// TODO Autogenerated
		//
		// f.addFilterElement(data_inizio.getValue(),data_fine.getValue()); //non devo
		// passare due date?
		// filtro = f;
		//
		// chiusura
		DisponibilitaDataFilter f = new DisponibilitaDataFilter(data_if.getSelectionModel().getSelectedItem(),
				operatore.getSelectionModel().getSelectedItem());
		f.addFilterElement(data.getValue());
		filtro = f;
		System.out.printf("%s", f.getQueryString(null));
		invio_data.getScene().getWindow().hide();
	}

	public Filter getfilter() {
		// TODO Auto-generated method stub
		return filtro;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		data_if.getItems().addAll("data_inizio", "data_fine");
		operatore.getItems().addAll("<", ">", "=", ">=", "<=");
	}
}
