package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SolCatalogoControlador {

	@FXML
    private Button botonVolver;
	
	@FXML
    private Button botonRealizarPed;
	
	@FXML
    void clickBotonVolver(ActionEvent event) throws IOException {
		Stage stage = (Stage) botonVolver.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/gestPedidos.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
	
	@FXML
    void clickBotonRealizarPed(ActionEvent event) throws IOException {
	
    }

}
