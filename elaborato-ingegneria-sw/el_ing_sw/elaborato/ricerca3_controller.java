package elaborato;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import elaborato.ricerca.Filter;
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
	List<Filter> filters;//aggiunta
	
	@FXML 
	private Button crea_listview;
	
	@FXML
	private Button nuovo_filtro;
	
	public ricerca3_controller() {
		this.filters = new ArrayList<Filter>();
	}
	
	@FXML
	private void crea_listview(ActionEvent event) {
		int i;
		System.out.printf("procdccece\n");
		//System.out.println(Arrays.toString(filters.toArray()));
		for(i=0;i<filters.size();i++) {
			System.out.printf("%s\n",filters.get(i).getQueryString(null));
		}
	}
	
	@FXML
	private void nuovo_filtro_oa(ActionEvent event) throws IOException {
		/*Parent root = FXMLLoader.load(getClass().getResource("scelta_filtro.fxml"));

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("scegliere_filtro");
		primaryStage.setScene(scene);
		// specifico la modalita della nuova finestra
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(nuovo_filtro.getScene().getWindow()); // specifica il proprietario della nuova finestra;
		
		//block execution until the window closes
		//primaryStage.showAndWait(); 
		
		//close this window
		//nome_bottone.getScene().getWindow().hide();
		
		// mi da problemi
		primaryStage.show();*/
		FXMLLoader loader= new FXMLLoader(getClass().getResource("scelta_filtro.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.initOwner(nuovo_filtro.getScene().getWindow()); // specifica il proprietario della nuova finestra;
		primaryStage.setScene(new Scene ((Parent) loader.load()));
		
		//wait until the window close
		primaryStage.showAndWait();
		
		scelta_filtro_controller sf_controller = loader.getController();
		Filter filtro = sf_controller.getfiltro();
		filters.add(filtro);
		System.out.printf("%s\n",filtro.getQueryString(null));
	}
	
	//aggiunta
	/*private void insertfilter(Filter filtro) {
		//inviare una lettera per saper che cast fare esempio (automunitoFilter)
		filters.add(filtro);
		System.out.printf("%s\n",filters);
	}*/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
