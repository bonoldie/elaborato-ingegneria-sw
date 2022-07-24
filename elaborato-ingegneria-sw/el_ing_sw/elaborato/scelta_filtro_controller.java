package elaborato;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import elaborato.ricerca.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class scelta_filtro_controller implements Initializable{
	@FXML
	private ChoiceBox<String> tipi_filtro;
	@FXML
	private Button visiona_finestra_filtro;
	
	//private String controllo_tipo_filtro;
	
	private Filter filtro;
	
	/*private AutomunitoFilter filtro_af;
	private DisponibilitaComuneFilter filtro_dcf;
	private DisponibilitaDataFilter filtro_ddf;
	private LavoratoreFilter filtro_laf;
	private LinguaFilter filtro_lf;
	private PatenteFilter filtro_pf;
	private SpecializzazioneFilter filtro_sf;*/
	
	private FXMLLoader show(String path, String title) throws IOException {
		FXMLLoader loader = null;
		Parent root = null;
		
		try {
			loader = new FXMLLoader(getClass().getResource(path));
			root = (Parent) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.initOwner(this.visiona_finestra_filtro.getScene().getWindow());
		primaryStage.showAndWait();
		
		return loader;
		
		
	}
	
	
	public Filter getfiltro() {
		//inseire i vari switch/if in bae al controllo_tipo_filtro
		return filtro;
	}

	// Event Listener on Button[#visiona_finestra_filtro].onAction
	@FXML
	public void visiona_finestra_filtro_oa(ActionEvent event) throws IOException {
		// TODO Autogenerated
		
		//in base a che filtro o scelto apro diverse finestre
		Parent root = null;
		Scene scene = null;
		Stage primaryStage = null;
		FXMLLoader loader= null;
		
		switch(tipi_filtro.getSelectionModel().getSelectedItem()) {
		
		case "automunito":
			loader = this.show("/elaborato/FXML/automunito.fxml", "Filtro automunito");
			automunito_controller am_controller = loader.getController();
			filtro = am_controller.getfilter();
			break;
			
		case "comune":
			loader =  this.show("/elaborato/FXML/comune.fxml", "Filtro comune");
			comune_controller c_controller = loader.getController();
			filtro = c_controller.getfilter();
			break;
			
		case "disponibilita":
			loader =  this.show("/elaborato/FXML/periodo.fxml", "Filtro periodo");
			periodo_controller p_controller = loader.getController();
			filtro = p_controller.getfilter();
			break;
			
		case "lavoratore":
			loader =  this.show("/elaborato/FXML/lavoratore.fxml", "Filtro lavoratore");
			lavoratore_controller la_controller = loader.getController();
			filtro = la_controller.getfilter();
			break;
			
		case "lingua":
			loader =  this.show("/elaborato/FXML/lingua.fxml", "Filtro lingua");	
			lingua_controller l_controller = loader.getController();
			filtro = l_controller.getfilter();
			break;
			
		case "patente":
			loader =  this.show("/elaborato/FXML/patente.fxml", "Filtro patente");	
			patente_controller pa_controller = loader.getController();
			filtro = pa_controller.getfilter();
			break;
			
		case "specializzazione":
			loader =  this.show("/elaborato/FXML/specializzazione.fxml", "Filtro specializzazione");	
			specializzazione_controller sp_controller = loader.getController();
			filtro = sp_controller.getfilter();
			break;
			
		}
		
		visiona_finestra_filtro.getScene().getWindow().hide();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tipi_filtro.getItems().addAll("automunito","comune","disponibilita","lavoratore","lingua","patente","specializzazione"); //manca SPECIALIZZAZIONE!!
		//tipi_filtro.getItems().addAll(filtro_af.getNameFilter(),filtro_dcf.getNameFilter(),filtro_ddf.getNameFilter(),filtro_laf.getNameFilter(),filtro_lf.getNameFilter(),filtro_pf.getNameFilter(),filtro_sf.getNameFilter()); //dovrei inizializzarlo chiamando getNameFilter

	}
}
