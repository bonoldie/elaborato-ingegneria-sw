package elaborato.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import elaborato.DAO.Lingua;
import elaborato.DAO.Patente;
import elaborato.DAO.PatenteDAO;
import elaborato.ricerca.AutomunitoFilter;
import elaborato.ricerca.Filter;
import elaborato.ricerca.PatenteFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class PatenteController implements Initializable {
	@FXML
	private Button invio_dati;

	@FXML
	private ListView<Patente> patenti;
	ObservableList<Patente> tipo_patente;

	private PatenteFilter filtro;

	// Event Listener on Button[#invio_dati].onAction
	@FXML
	public void getpatente_oa(ActionEvent event) {
		// TODO Autogenerated
		PatenteFilter pf = new PatenteFilter();

		// passo una sola patente
		// pf.addFilterElement(patenti.getSelectionModel().getSelectedItem());

		// passo piu patenti al filtro
		for (Patente p : patenti.getSelectionModel().getSelectedItems()) {
			pf.addFilterElement(p);
		}
		filtro = pf;
		System.out.printf("%s", filtro.getQueryString("and"));
		/*
		 * FXMLLoader loader = new FXMLLoader(getClass().getResource("ricerca3.fxml"));
		 * ricerca3_controller controller = loader.getController();
		 * controller.filters.add(af); return af;
		 */
		invio_dati.getScene().getWindow().hide();
	}

	public Filter getfilter() {
		// TODO Auto-generated method stub
		return filtro;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		PatenteDAO patenteDAO = new PatenteDAO();

		try {
			this.tipo_patente = FXCollections.observableArrayList(patenteDAO.getAllPatente());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		patenti.setItems(tipo_patente);
		patenti.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
