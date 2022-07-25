package elaborato.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController implements Initializable {

	@FXML
	Pane lavoratori_bt;

	@FXML
	Pane lavori_bt;

	@FXML
	Pane ricerca_bt;

	private void show(String path, String title) {

		Parent root;

		try {
			root = FXMLLoader.load(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(this.ricerca_bt.getScene().getWindow());
		primaryStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lavoratori_bt.setOnMouseClicked(e -> {
			this.show("/elaborato/FXML/ListaLavoratori.fxml", "Lista lavoratori");
		});

		lavori_bt.setOnMouseClicked(e -> {
			this.show("/elaborato/FXML/ListaLavoriSvolti.fxml", "Lista lavori");
		});

		ricerca_bt.setOnMouseClicked(e -> {
			this.show("/elaborato/FXML/Ricerca.fxml", "Ricerca lavoratori");
		});

		Arrays.asList(lavoratori_bt, lavori_bt, ricerca_bt).forEach(p -> {
			p.setOnMouseEntered(e -> {
				p.setStyle("-fx-background-color: #bbb;");
			});

			p.setOnMouseExited(e -> {
				p.setStyle("-fx-background-color: #ccc;");
			});
		});

	}

}
