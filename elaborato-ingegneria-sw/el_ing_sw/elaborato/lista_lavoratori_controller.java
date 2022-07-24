package elaborato;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import elaborato.DAO.Anagrafiche_LavoratoriDAO;
import elaborato.DAO.Anagrafiche_Lavoratori;
import elaborato.DAO.Anagrafiche_LavoratoriDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class lista_lavoratori_controller implements Initializable {

	private Anagrafiche_LavoratoriDAO anagLavDAO  = new Anagrafiche_LavoratoriDAO();
	

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> id_lavoratore;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> nome;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> cognome;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> indirizzo;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> nazionalita;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> luogo_di_nascita;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> email;
	
	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> telefono;
	
	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> automunito;

	@FXML
	TableColumn<Anagrafiche_Lavoratori, String> remove_col;
	
	@FXML
	TableView<Anagrafiche_Lavoratori> lista_lavoratori;
	
	

	public void updateListaLavoratori() throws SQLException {
		this.lista_lavoratori.setItems(FXCollections.observableArrayList(this.anagLavDAO.getAllAnagrafiche_Lavoratori()));
	}

	public Stage showEditLavoratore(int lavoratoreId) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/elaborato/FXML/edit_lavoratore.fxml"));
		Stage editLavoratoreStage = new Stage();
		editLavoratoreStage.initOwner(this.lista_lavoratori.getScene().getWindow());
		
		try {
			editLavoratoreStage.setScene(new Scene((Parent) loader.load()));
			edit_lavoratore_controller controller = loader.getController();
			controller.setLavoratoreId(lavoratoreId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		editLavoratoreStage.initModality(Modality.APPLICATION_MODAL);
		editLavoratoreStage.showAndWait();
		
		return editLavoratoreStage;
	}
	
	public Stage showEditLavoratore() {
		return this.showEditLavoratore(-1);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id_lavoratore.setCellValueFactory(anagLav -> new SimpleStringProperty(Integer.toString(anagLav.getValue().getId_lavoratore())));
		nome.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getNome()));
		cognome.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getCognome()));
		indirizzo.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getIndirizzo()));
		nazionalita.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getNazionalita()));
		luogo_di_nascita.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getLuogo_di_nascita()));
		email.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getEmail()));
		telefono.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().getTelefono()));
		automunito.setCellValueFactory(anagLav -> new SimpleStringProperty(anagLav.getValue().isAutomunito() ? "✓" : "×"));
		
		
		remove_col.setCellValueFactory(ls -> new SimpleStringProperty("-"));
		
		remove_col.setCellFactory((b) -> {
			TableCell<Anagrafiche_Lavoratori, String> tc = new TableCell<>();
			
			tc.setOnMouseClicked(event -> {
			    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("Vuoi eliminare la riga?");
				ButtonType okButton = new ButtonType("Yes");
				ButtonType noButton = new ButtonType("No");
				ButtonType cancelButton = new ButtonType("Cancel");
				alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
				alert.showAndWait().ifPresent(type -> {
				        if (type.getText() == "Yes") {
//				        	try {
//								// Elimina un lavoratore (prima bisogna controllare tutte le referenze)
//							} catch (SQLException e) {
//								e.printStackTrace();
//							}
				        	
				        	try {
								this.updateListaLavoratori();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        } else if (type.getText() == "No") {
				        
				        } else {
				        	
				        }
				});
			});
			
			return tc;
		});
		
		try {
			this.lista_lavoratori.setRowFactory(tv -> {
				TableRow<Anagrafiche_Lavoratori> row = new TableRow<>();

				row.setOnMouseClicked(event -> {

					if (event.getClickCount() == 2 && (!row.isEmpty())) {
						
						this.showEditLavoratore(row.getItem().getId_lavoratore());
						
						// Se siamo qui siamo riusciti a salvare o abbiamo chiuso la schermata di edit e dobbiamo ricaricare la TableView
						try {
							this.updateListaLavoratori();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				return row;
			});

			this.updateListaLavoratori();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// wait until the window close
	}
	
	@FXML
	private void aggiungi_lavoratore(ActionEvent event) {
		this.showEditLavoratore();
		
		try {
			this.updateListaLavoratori();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
