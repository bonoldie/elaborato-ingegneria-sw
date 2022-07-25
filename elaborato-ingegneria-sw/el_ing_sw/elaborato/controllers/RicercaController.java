package elaborato.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import elaborato.DAO.Anagrafiche_LavoratoriDAO;
import elaborato.DAO.Lavoratore_View;
import elaborato.DAO.Lavoratore_ViewDAO;
import elaborato.DB.Database;
import elaborato.ricerca.Filter;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RicercaController implements Initializable {

	private Lavoratore_ViewDAO lavViewDAO = new Lavoratore_ViewDAO();

	List<Filter> filters;// aggiunta
	// lista di liste (se volessi passare pi� filtri contemporaneamente)

	List<List<Filter>> listoflist = new ArrayList<List<Filter>>(); // usata per comperre i filtri in and e or
	List<Filter> filtri_concat = new ArrayList<Filter>(); // usato da listof list

	// fxml table view e colonne

	@FXML
	private TableView<Lavoratore_View> visione_lavoratori;

	@FXML
	private TableColumn<Lavoratore_View, String> id_lavoratore;

	@FXML
	private TableColumn<Lavoratore_View, String> esperienze;

	@FXML
	private TableColumn<Lavoratore_View, String> lingue;

	@FXML
	private TableColumn<Lavoratore_View, String> periodo_disponibilita;

	@FXML
	private TableColumn<Lavoratore_View, String> patenti_lavoratore;

	@FXML
	private TableColumn<Lavoratore_View, String> comuni_disponibilita;

	// fxml bottoni

	@FXML
	private Button crea_listview;

	@FXML
	private ListView<Filter> lista_filtri;
	ObservableList<Filter> filtri_view;

	@FXML
	private ListView<List<Filter>> lista_finale_filtri;
	ObservableList<List<Filter>> filter_view_finale;

	@FXML
	private Button unisci_filtri;

	@FXML
	private Button nuovo_filtro;

	@FXML
	private Button togli_filtro;

	@FXML
	private Button togli_filtro_finale;

	public void updateRicerca() throws SQLException {
		this.visione_lavoratori.setItems(FXCollections.observableArrayList(this.lavViewDAO.getAllLavoratore_View()));
	}

	public RicercaController() {
		this.filters = new ArrayList<Filter>();
	}

	@FXML
	private void crea_listview(ActionEvent event) {

		try {

			if (listoflist.size() == 0) {
				this.updateRicerca();
			}

			Set<Integer> ids = new HashSet<>();
			PreparedStatement ps = Database.getDatabase().getConnection().prepareStatement(this.getFilteredQuery());
			System.out.println(this.getFilteredQuery());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ids.add(rs.getInt("id_lavoratore"));
			}

			System.out.println(ids.size());

			List<Lavoratore_View> filteredLavoratore_View = this.lavViewDAO.getAllLavoratore_View().stream()
					.filter(lw -> ids.contains(lw.getId_lavoratore())).toList();

			this.visione_lavoratori.setItems(FXCollections.observableArrayList(filteredLavoratore_View));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getFilteredQuery() {
		List<String> queryUnion = new ArrayList();

		for (List<Filter> lf : listoflist) {
			List<String> queryIntersect = new ArrayList();

			for (Filter f : lf) {
				queryIntersect.add(" ( " + f.getQueryString("OR") + " ) ");
			}

			queryUnion.add(String.join(" INTERSECT ", queryIntersect));
		}

		return String.join(" UNION ", queryUnion);
	}

	@FXML
	private void nuovo_filtro_oa(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/elaborato/FXML/SceltaFiltro.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.initOwner(nuovo_filtro.getScene().getWindow()); // specifica il proprietario della nuova finestra;
		primaryStage.setScene(new Scene((Parent) loader.load()));

		// wait until the window close
		primaryStage.showAndWait();

		SceltaFiltroController sf_controller = loader.getController();
		Filter filtro = sf_controller.getfiltro(); // Cannot invoke "elaborato.ricerca.Filter.getQueryString(String)"
													// because the return value of "java.util.List.get(int)" is null
													// (quando faccio un datafilter)

		if (filtro == null)
			return;
		if (filtro.getFilterSet().size() == 0)
			return;

		filters.add(filtro);
		initialize(null, null); // aggiorno la listview
	}

	@FXML
	private void togli_filtro_oa(ActionEvent event) {

		// oppure sfruttare il fatto che sono nella stessa posizione
		// filters.remove(0);

		// prendo i filtri selezionati nella list view
		for (Filter f : lista_filtri.getSelectionModel().getSelectedItems()) {
			// cerco nella lista dei filtri lo stesso filtro della list view
			filters.remove(f);
		}

		initialize(null, null); // PICCOLO BUG SE ELIMINO TUTTO NON MI DA LA LISTA VUOTA, RIMANGONO I CAMPI
								// VISUALIZZATI (RISULTA LO STESSO VUOTA)
	}

	@FXML
	private void togli_filtro_finale_oa(ActionEvent event) {

		// sono nella stessa posizione in entrambe le liste, uso gli index
		for (int ll : lista_finale_filtri.getSelectionModel().getSelectedIndices()) { // mi salvo l index dei filtri
																						// finali selezionati
			listoflist.remove(ll); // elimino i filtri finali dalla listoflist
		}

		initialize(null, null);
	}

	@FXML
	private void unisci_filtri_oa(ActionEvent event) {

		List<Filter> invio = new ArrayList<Filter>();

		if (lista_filtri.getSelectionModel().getSelectedItems().size() < 1) {
			return;
		}

		// selezioniamo da lista_filtri i filtri da concatenare ("AND")
		for (Filter f : lista_filtri.getSelectionModel().getSelectedItems()) {
			invio.add(f);
		}
		// inserisco la lisat in listoflist
		listoflist.add(invio);

		initialize(null, null);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		// inizializzo tabella view
		id_lavoratore.setCellValueFactory(
				anagLav -> new SimpleStringProperty(Integer.toString(anagLav.getValue().getId_lavoratore())));
		esperienze.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getEsperienza()));
		lingue.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getLingue()));
		periodo_disponibilita.setCellValueFactory(
				anagLav -> new SimpleStringProperty(anagLav.getValue().getPeriodo_di_disponibilita()));
		patenti_lavoratore
				.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getPatenti_lavoratore()));
		comuni_disponibilita
				.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getComuni_disponibili()));
		try {
			this.updateRicerca();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// devo inizializzare la listview con i valori all'interno della lista filtri
		if (filters.isEmpty()) {
			lista_filtri.getItems().clear();
			// return;
		} else {
			this.filtri_view = FXCollections.observableArrayList(filters);
			lista_filtri.setItems(filtri_view);

			// modifico cosa appare sulla listview (appare il tipo di filtro)
		}
		lista_filtri.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// inizializzazione della listoflist

		this.filter_view_finale = FXCollections.observableArrayList(listoflist);
		lista_finale_filtri.setItems(filter_view_finale);

		if (listoflist.isEmpty()) {
			lista_finale_filtri.getItems().clear();
			// return;
		} else {
			this.filter_view_finale = FXCollections.observableArrayList(listoflist);
			lista_finale_filtri.setItems(filter_view_finale);

			/*
			 * System.out.println("AAAAAAAA"); //test stampa esempio
			 * listoflist.forEach((list) -> {
			 * list.forEach((filtro)->System.out.print(filtro.getQueryString(null)+
			 * "INTERSECT"+"\n")); System.out.println("UNION"); } );
			 */

			// modifico cosa appare sulla listview (appare il tipo di filtro)
			lista_finale_filtri.setCellFactory(list -> {

				ListCell<List<Filter>> cell = new ListCell<List<Filter>>() {
					@Override
					protected void updateItem(List<Filter> item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(String.join("\n", item.stream().map(f -> f.toString()).toList()));
						}
					}
				};

				return cell;
			});

			/*
			 * lista_finale_filtri.setCellFactory(param -> ListCell<List<Filter>> prova =
			 * new ListCell<List<Filter>>() {
			 * 
			 * for()
			 * 
			 * @Override protected void updateItem(List<Filter> filtro, boolean empty) {
			 * super.updateItem(filtro, empty);
			 * 
			 * if (empty || filtro == null || ((Filter) filtro).getNameFilter() == null) {
			 * setText(null); } else { setText(((Filter) filtro).getNameFilter() + " " +
			 * ((Filter) filtro).getDatiFilter()); } } });
			 */
		}

	}

}
