package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestVentasControlador {
	
	@FXML
    private Button botonProducto;

    @FXML
    private Button botonEmp;

    @FXML
    private Button botonReporte;

    @FXML
    void clickBtnEmp(ActionEvent event) throws IOException {
    	Stage stage = (Stage) botonEmp.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/empleadoVentas.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
    }

    @FXML
    void clickBtnProduc(ActionEvent event) throws IOException {
    	Stage stage = (Stage) botonProducto.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/productoVentas.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
    }

    @FXML
    void clickBtnReporte(ActionEvent event) {
    	
    }

}
