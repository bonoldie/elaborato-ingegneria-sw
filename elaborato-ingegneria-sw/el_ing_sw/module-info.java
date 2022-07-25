module el_ing_sw {
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires org.junit.jupiter.api;

	opens elaborato to javafx.graphics, javafx.fxml; // aggiungere in caso di
	opens elaborato.controllers to javafx.graphics, javafx.fxml;
	opens elaborato.FXML to javafx.graphics, javafx.fxml;
	// cannot access class elaborato.Main (in module el_ing_sw) because module
	// el_ing_sw does not export elaborato to module javafx.graphics
}