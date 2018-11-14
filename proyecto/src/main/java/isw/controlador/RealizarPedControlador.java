package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import javafx.util.Pair;

public class RealizarPedControlador {
	
	@FXML
    private Button botonVolver;
	
	@FXML
    private Button botonQuitar;
	
	@FXML
    private Button botonAgregar;
	
	@FXML
    void clickBotonVolver(ActionEvent event) throws IOException {
		Stage stage = (Stage) botonVolver.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/gestPedidos.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
	
	@FXML
    void clickBotonAgregar(ActionEvent event) {
							
	}
	

}
