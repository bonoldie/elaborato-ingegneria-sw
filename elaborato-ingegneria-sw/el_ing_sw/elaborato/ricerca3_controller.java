package elaborato;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import elaborato.ricerca.Filter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ricerca3_controller implements Initializable{
	List<Filter> filters;//aggiunta
	//lista di liste (se volessi passare più filtri contemporaneamente)
	/*ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>(); //esempio
	ArrayList<String> singleList = new ArrayList<String>();
	singleList.add("hello");
	singleList.add("world");
	listOLists.add(singleList);*/
	
	@FXML 
	private Button crea_listview;
	
	@FXML
	private ListView<Filter> lista_filtri;
	ObservableList<Filter> filtri_view;
	
	@FXML
	private Button nuovo_filtro;
	
	@FXML
	private Button togli_filtro;
	
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
		Filter filtro = sf_controller.getfiltro(); //Cannot invoke "elaborato.ricerca.Filter.getQueryString(String)" because the return value of "java.util.List.get(int)" is null (quando faccio un datafilter)
		filters.add(filtro);
		System.out.printf("%s\n",filtro.getQueryString(null));
		
		initialize(null, null); //aggiorno la listview
	}
	
	@FXML
	private void togli_filtro_oa() {
		
		//oppure sfruttare il fatto che sono nella stessa posizione
		//filters.remove(0);
		
		//prendo i filtri selezionati nella list view
		for(Filter f : lista_filtri.getSelectionModel().getSelectedItems()) {
			//cerco nella lista dei filtri lo stesso filtro della list view
			filters.remove(f);
		}
		
		initialize(null, null); //PICCOLO BUG SE ELIMINO TUTTO NON MI DA LA LISTA VUOTA, RIMANGONO I CAMPI VISUALIZZATI (RISULTA LO STESSO VUOTA)
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
		//devo inizializzare la listview con i valori all'interno della lista filtri
		if(filters.isEmpty()) {
			lista_filtri.getItems().clear();
			//return;
		}
		else {
			this.filtri_view = FXCollections.observableArrayList(filters);
			lista_filtri.setItems(filtri_view);
			
			//modifico cosa appare sulla listview (appare il tipo di filtro)
			
			lista_filtri.setCellFactory(param -> new ListCell<Filter>() {
	            @Override
	            protected void updateItem(Filter filtro, boolean empty) {
	                super.updateItem(filtro, empty);

	                if (empty || filtro == null || filtro.getNameFilter() == null) {
	                    setText(null);
	                } else {
	                    setText(filtro.getNameFilter() + " " + filtro.getDatiFilter());
	                }
	            }
	        });
		}
		lista_filtri.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
}
