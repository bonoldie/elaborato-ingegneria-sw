package elaborato;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ricerca2_controller implements Initializable{
	
	
	Button composerAddButton;
	
	@FXML
	ListView<Button> ricerca_composer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ricerca_composer.setItems(FXCollections.observableArrayList(composerAddButton));
	}

}
