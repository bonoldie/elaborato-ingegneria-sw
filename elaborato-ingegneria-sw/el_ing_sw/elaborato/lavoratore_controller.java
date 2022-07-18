package elaborato;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import elaborato.DAO.FilterAnagrafica;
import elaborato.ricerca.DisponibilitaComuneFilter;
import elaborato.ricerca.Filter;
import elaborato.ricerca.LavoratoreFilter;
import javafx.event.ActionEvent;

public class lavoratore_controller {
	@FXML
	private Button invio_dati;
	@FXML
	private TextField nome;
	@FXML
	private TextField cognome;
	@FXML
	private TextField email;
	
	private LavoratoreFilter filtro;

	// Event Listener on Button[#invio_dati].onAction
	@FXML
	public void getlavoratore_oa(ActionEvent event) {
		// TODO Autogenerated
		LavoratoreFilter f= new LavoratoreFilter();
		FilterAnagrafica dati_da_passare = new FilterAnagrafica(nome.getText(),cognome.getText(),email.getText());
		f.addFilterElement(dati_da_passare);
		filtro = f;
		System.out.printf("%s",f.getQueryString(null));
		//chiusura
		invio_dati.getScene().getWindow().hide();
	}

	public Filter getfilter() {
		// TODO Auto-generated method stub
		return filtro;
	}
}
