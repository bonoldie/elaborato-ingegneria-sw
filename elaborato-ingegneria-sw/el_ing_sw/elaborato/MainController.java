package elaborato;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import elaborato.DAO.DipendenteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	//vari field
	@FXML
	TextField login;
	@FXML
	PasswordField password;
	@FXML
	Text risultato_login;
	@FXML
	Button Sign_in; 
	
	@FXML
	private void controllo_credenziali(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		System.out.println("prova");
		//risultato_login.setText("prova"); //mi da errore non so se serve qualche 
		
		//da inserire dopo il controllo delle credenziali *****
		//test
		
		DipendenteDAO log= new DipendenteDAO();
		Boolean d = log.getDipendenteLogin(login.getText(), password.getText()); 
		
		if(d==true) {
			Parent root = FXMLLoader.load(getClass().getResource("ric_ins.fxml"));
			
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Ricerca/Inserimento");
			primaryStage.setScene(scene);
			//specifico la modalità della nuova finestra
			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(Sign_in.getScene().getWindow()); 
			primaryStage.show();
		}
		else
		{
			//inserirlo in un label nell'interfaccia
			System.out.println("rinserire le credenziali");
		}
	}
	
	public void initialize(URL url, ResourceBundle resources){
		// TODO Auto-generated constructor stub
	}
	

}
