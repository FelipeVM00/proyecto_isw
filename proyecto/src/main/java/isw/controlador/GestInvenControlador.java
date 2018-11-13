package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestInvenControlador {
	
	@FXML
    private Button btnVolver;
	
	@FXML
    private Button btnAgregar;
	
	@FXML
    private Button btnEliminar;
	
	@FXML
    void clickBtnVolver(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnVolver.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/menu.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
    }
	
	@FXML
    void clickBtnAgregar(ActionEvent event) throws IOException {
		
		Stage stage = (Stage) btnAgregar.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/agregarProducto.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
		
	@FXML
	void clickBtnEliminar(ActionEvent event) throws IOException {
			
		Stage stage = (Stage) btnEliminar.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/eliminarProducto.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
}
	
}
