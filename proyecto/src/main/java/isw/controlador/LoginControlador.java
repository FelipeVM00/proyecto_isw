package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControlador {

	@FXML
	private Button botonIngresar;

	@FXML
	private TextField usuarioLogin;

	@FXML
	private PasswordField contraseña;

	@FXML
	private Button botonModoOffline;

	@FXML
	void clickBotonIngresar(ActionEvent event) throws IOException {
		Stage stage = (Stage) botonIngresar.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/menu.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		//stage.setFullScreen(true);
	}

	@FXML
	private void salir(ActionEvent event) {
		System.exit(0);
	}

}
