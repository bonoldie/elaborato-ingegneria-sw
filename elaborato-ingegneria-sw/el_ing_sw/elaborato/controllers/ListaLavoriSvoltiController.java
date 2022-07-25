package elaborato.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import elaborato.DAO.AnagraficaDAO;
import elaborato.DAO.Anagrafiche_LavoratoriDAO;
import elaborato.DAO.Lavoratore_View;
import elaborato.DAO.Lavoratore_ViewDAO;
import elaborato.DAO.Lavoro_svolto;
import elaborato.DAO.Lavoro_svoltoDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListaLavoriSvoltiController implements Initializable {

	private Lavoro_svoltoDAO lsDAO = new Lavoro_svoltoDAO();
	private Anagrafiche_LavoratoriDAO anagLavDAO = new Anagrafiche_LavoratoriDAO();

	@FXML
	TableColumn<Lavoro_svolto, String> id_lavoratore;

	@FXML
	TableColumn<Lavoro_svolto, String> data_inizio;

	@FXML
	TableColumn<Lavoro_svolto, String> data_fine;

	@FXML
	TableColumn<Lavoro_svolto, String> nome_azienda;

	@FXML
	TableColumn<Lavoro_svolto, String> luogo_di_lavoro;

	@FXML
	TableColumn<Lavoro_svolto, String> mansione_svolta;

	@FXML
	TableColumn<Lavoro_svolto, String> retri_lorda_giornaliera;

	@FXML
	TableColumn<Lavoro_svolto, String> remove_col;

	@FXML
	TableView<Lavoro_svolto> lista_lavori_svolti;

	public void updateListaLavoriSvolti() throws SQLException {
		this.lista_lavori_svolti.setItems(FXCollections.observableArrayList(this.lsDAO.getAllLavoro_svolto()));
	}

	public Stage showEditLavoroSvolto(Lavoro_svolto lavoro_svolto) {
		Lavoro_svolto selectedLavoroSvolto = lavoro_svolto;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/elaborato/FXML/EditLavoroSvolto.fxml"));
		Stage editLavoroSvoltoStage = new Stage();
		editLavoroSvoltoStage.initOwner(lista_lavori_svolti.getScene().getWindow());

		try {
			editLavoroSvoltoStage.setScene(new Scene((Parent) loader.load()));
			EditLavoroSvoltoController controller = loader.getController();
			controller.setLavoroSvoltoInstance(selectedLavoroSvolto);
		} catch (IOException e) {
			e.printStackTrace();
		}

		editLavoroSvoltoStage.initModality(Modality.APPLICATION_MODAL);
		editLavoroSvoltoStage.showAndWait();

		return editLavoroSvoltoStage;
	}

	public Stage showEditLavoroSvolto() {
		return this.showEditLavoroSvolto(
				new Lavoro_svolto(0, 0, LocalDate.now(), LocalDate.now(), "", "", "", new BigDecimal(0)));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id_lavoratore.setCellValueFactory(ls -> {
			try {
				return new SimpleStringProperty(
						anagLavDAO.getAnagrafiche_Lavoratori(ls.getValue().getId_lavoratore()).toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		});
		data_inizio.setCellValueFactory(ls -> new SimpleStringProperty(ls.getValue().getData_inizio().toString()));
		data_fine.setCellValueFactory(ls -> new SimpleStringProperty(ls.getValue().getData_fine().toString()));
		nome_azienda.setCellValueFactory(ls -> new SimpleStringProperty(ls.getValue().getNome_azienda()));
		luogo_di_lavoro.setCellValueFactory(ls -> new SimpleStringProperty(ls.getValue().getLuogo_di_lavoro()));
		mansione_svolta.setCellValueFactory(ls -> new SimpleStringProperty(ls.getValue().getMansione_svolta()));
		retri_lorda_giornaliera.setCellValueFactory(
				ls -> new SimpleStringProperty("€ " + ls.getValue().getRetribuzione_lorda_giornaliera().toString()));

		remove_col.setCellValueFactory(ls -> new SimpleStringProperty("-"));

		remove_col.setCellFactory((b) -> {
			TableCell<Lavoro_svolto, String> tc = new TableCell<>();

			tc.setOnMouseClicked(event -> {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("Vuoi eliminare la riga?");
				ButtonType okButton = new ButtonType("Yes");
				ButtonType noButton = new ButtonType("No");
				ButtonType cancelButton = new ButtonType("Cancel");
				alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
				alert.showAndWait().ifPresent(type -> {
					if (type.getText() == "Yes") {
						try {
							lsDAO.deleteLavoro_svolto(tc.getTableRow().getItem());

						} catch (SQLException e) {
							e.printStackTrace();
						}

						try {
							this.updateListaLavoriSvolti();
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
			this.lista_lavori_svolti.setRowFactory(tv -> {
				TableRow<Lavoro_svolto> row = new TableRow<>();

				row.setOnMouseClicked(event -> {

					if (event.getClickCount() == 2 && (!row.isEmpty())) {

						this.showEditLavoroSvolto(row.getItem());

						// Se siamo qui siamo riusciti a salvare o abbiamo chiuso la schermata di edit e
						// dobbiamo ricaricare la TableView
						try {
							this.updateListaLavoriSvolti();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				return row;
			});

			this.updateListaLavoriSvolti();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// wait until the window close
	}

	@FXML
	private void aggiungi_lavoro_svolto(ActionEvent event) {
		this.showEditLavoroSvolto();

		try {
			this.updateListaLavoriSvolti();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
