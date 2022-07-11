package elaborato;

import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import elaborato.DAO.Patente;
import elaborato.DB.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class inserimento_controller implements Initializable{
	//dati anagrafici
	@FXML
	private TextField nome_id;
	@FXML
	private TextField cognome_id;
	@FXML
	private TextField naz_id;
	@FXML
	private DatePicker data_n_id;
	@FXML
	private TextField luogo_id;
	@FXML
	private TextField lingua_id;
	@FXML
	private TextField email_id;
	@FXML
	private TextField telefono_id;
	@FXML
	private TextField indirizzo_id;
	@FXML
	private ChoiceBox<String> spec_id;
	ObservableList<String> specializzazioni
		= FXCollections.observableArrayList("bagnino","barman","istruttore di nuoto","viticoltore","floricoltore");
	@FXML
	private ChoiceBox<Boolean> auto_id;
	@FXML
	private ListView<Patente> patenti_list_view;
	//private final String[] tipo_patenti = {"AM"), "A1", "A2", "A","B1","B","BE","C1","C1E","C","CE","D1","D1E","D","DE","KA","KB","CQC","CQCM","CFP","NO"};
	//private final ObservableList<String> tipo_patenti_lista = FXCollections.observableArrayList();
	ObservableList<Patente> tipo_patente = FXCollections.observableArrayList(new Patente(0,"AM"), new Patente(1,"A1"), new Patente(2,"A2"), new Patente(3, "AM"),new Patente(4, "A1"),new Patente(5, "A2"),new Patente(6, "A"),new Patente(7, "B1"),new Patente(8, "B"),new Patente(9, "BE"),new Patente(10, "C1"),new Patente(11, "C1E"),new Patente(12, "C"),new Patente(13, "CE"),new Patente(14, "D1"),new Patente(15, "D1E"),new Patente(16, "D"),new Patente(17, "DE"), new Patente(18, "KA"),new Patente(19, "KB"),new Patente(20, "CQC"),new Patente(21, "CFP"),new Patente(22, "NO"));
	@FXML
	private TextField p_nome_id;
	@FXML
	private TextField p_email_id;
	@FXML
	private TextField p_telefono_id;
	@FXML
	private TextField p_cognome_id;
	
	//disponibilita'
	@FXML
	private TextField periodo_id;
	@FXML
	private TextField comune_id;
	
	@FXML
	private Button invio_dati_db;
	
	@FXML
	private void inviodati(ActionEvent event) throws SQLException {
		//vedere se fare bottoni separati per l'invio di solo alcune parti di dati come patente o lingue 
		//capire come indicare id di altre tabelle e passarli!!
		//st usato per ricerca degli id
		System.out.println("prova");
		Statement st=Database.getDatabase().getConnection().createStatement();
		
		//anagrafica
		PreparedStatement pst_anagrafica= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Anagrafica(luogo_di_nascita, data_di_nascita, nazionalità, nome, cognome, telefono, email) VALUES (?,?,?,?,?,?,?);");
		//luogo_di_nascita, data_di_nascita, nazionalità, nome, cognome, telefono, email
		pst_anagrafica.setString(1, luogo_id.getText());
		LocalDate localdate=data_n_id.getValue();
		pst_anagrafica.setDate(2, java.sql.Date.valueOf(localdate)); //sarebbe una data ma ok
		pst_anagrafica.setString(3, naz_id.getText());
		pst_anagrafica.setString(4, nome_id.getText());
		pst_anagrafica.setString(5, cognome_id.getText());
		pst_anagrafica.setString(6, telefono_id.getText());
		pst_anagrafica.setString(7, email_id.getText());
		pst_anagrafica.executeUpdate();
		//dopo l'inserimento dovrei farmi ritornare dal DAO id_anagrafica?? da passare a chi li serve
		
		//recapito
		PreparedStatement pst_recapito= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Recapito(nome, cognome, telefono, email)"
				+ "VALUES(?,?,?,?);");
		//nome, cognome, telefono, email
		pst_recapito.setString(1, p_nome_id.getText());
		pst_recapito.setString(2, p_cognome_id.getText());
		pst_recapito.setString(3, p_telefono_id.getText());
		pst_recapito.setString(4, p_email_id.getText());
		pst_recapito.executeUpdate();
		
		//lavoratore (id-anagra, id_recapito)
		PreparedStatement pst_lavoratore= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Lavoratore(id_anagrafica, id_recapito_urgenza, indirizzo, specia_esp, automunito)"
				+ "VALUES(?,?,?,?,?);");
		//id_anagrafica, id_recapito_urgenza, indirizzo, specia_esp, lingue_parlate, patenti, automunito
		//dopo l'inserimento dovrei farmi ritornare dal DAO id_anagrafica?? da passare a chi li serve
		ResultSet rs_ultimo_anagrafica=st.executeQuery("SELECT id_anagrafica FROM Anagrafica ORDER BY id_anagrafica DESC LIMIT 1;"); //seleziono l'ultimo id_anagrafica inserito
		rs_ultimo_anagrafica.next(); // devo per forza eseguire un next altrimenti mi punta ad un nodo vuoto
		pst_lavoratore.setInt(1,rs_ultimo_anagrafica.getInt("id_anagrafica"));
		ResultSet rs_ultimo_recapito=st.executeQuery("SELECT id_recapito FROM Recapito ORDER BY id_recapito DESC LIMIT 1;");
		rs_ultimo_recapito.next();
		pst_lavoratore.setInt(2,rs_ultimo_recapito.getInt("id_recapito"));
		pst_lavoratore.setString(3, indirizzo_id.getText());
		pst_lavoratore.setString(4, spec_id.getSelectionModel().getSelectedItem());
		pst_lavoratore.setBoolean(5, auto_id.getValue());
		pst_lavoratore.executeUpdate();
		
		
		//lingua
		PreparedStatement pst_lingua= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Lingua(nome_lingua)"
				+ "VALUES(?);");
		pst_lingua.setString(1, lingua_id.getText()); //sarà da modificare
		pst_lingua.executeUpdate();
		
		//disponibilità
		PreparedStatement pst_disponibilità= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Disponibilità(id_lavoratore, periodo, comune)"
				+ "VALUES(?,?,?);");
		//id_lavoratore, periodo, comune
		ResultSet rs_lavoratore=st.executeQuery("SELECT id_lavoratore FROM Lavoratore ORDER BY id_lavoratore DESC LIMIT 1;");
		rs_lavoratore.next();
		pst_disponibilità.setInt(1, rs_lavoratore.getInt("id_lavoratore"));
		//pst_disponibilità.setString(2, periodo_id.getText());
		pst_disponibilità.setString(3, comune_id.getText());
		pst_disponibilità.executeUpdate();
		
		//lavoro_svolto
		//PreparedStatement pst_lavoro_svolto= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Lavoro_svolto(id_lavoratore, periodo, nome_azienda, mansioni_svolta, luogo_di_lavoro, retribuzione_lorda_giornaliera)"
				//+ "VALUES(?,?,?,?,?,?);");
		//id_lavoratore, periodo, nome_azienda, mansioni_svolta, luogo_di_lavoro, retribuzione_lorda_giornaliera
		//pst_lavoro_svolto. capire se farlo separato e molti a molti
		//lavoratore_lingua
		PreparedStatement pst_lavoratore_lingua= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Lavoratore_Lingua(id_lingua, id_lavoratore)"
				+ "VALUES(?,?)");
		ResultSet rs_lingua=st.executeQuery("SELECT id_lingua FROM Lingua ORDER BY id_lingua DESC LIMIT 1;");
		rs_lingua.next();
		pst_lavoratore_lingua.setInt(1, rs_lingua.getInt("id_lingua"));
		pst_lavoratore_lingua.setInt(2,rs_lavoratore.getInt("id_lavoratore"));
		pst_lavoratore_lingua.executeUpdate();
		
		//lavoratore_patente
		PreparedStatement pst_lavoratore_patente= Database.getDatabase().getConnection().prepareStatement("INSERT INTO Lavoratore_Patente(id_patente, id_lavoratore)"
				+ "VALUES(?,?);");
		//ResultSet rs_patente=st.executeQuery("SELECT id_patente FROM Patente ORDER BY id_patente DESC LIMIT 1;");
		//rs_patente.next();
		//pst_lavoratore_patente.setInt(1, rs_patente.getInt("id_patente"));
		for(Patente o : patenti_list_view.getSelectionModel().getSelectedItems()) {
			pst_lavoratore_patente.setInt(1, o.getId_patente());
			pst_lavoratore_patente.setInt(2, rs_lavoratore.getInt("id_lavoratore"));
			pst_lavoratore_patente.executeUpdate();
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		spec_id.setItems(specializzazioni);
		//
		auto_id.getItems().add(true);
		auto_id.getItems().add(false);
		//
		
		patenti_list_view.setItems(tipo_patente);
		patenti_list_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

}
