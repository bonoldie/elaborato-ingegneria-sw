package elaborato;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ricerca3_controller implements Initializable{
	
	@FXML 
	private Button crea_listview;
	
	@FXML
	private Button nuovo_filtro;
	
	@FXML
	private void crea_listview(ActionEvent event) {
		
	}
	
	@FXML
	private void nuovo_filtro_oa(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("scelta_filtro.fxml"));

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("scegliere_filtro");
		primaryStage.setScene(scene);
		// specifico la modalita della nuova finestra
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(nuovo_filtro.getScene().getWindow()); // specifica il proprietario della nuova finestra;
																	// mi da problemi
		primaryStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
