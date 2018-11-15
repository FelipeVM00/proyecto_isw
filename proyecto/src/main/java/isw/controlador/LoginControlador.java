package isw.controlador;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import isw.modelo.Usuario;
import isw.proyecto.jdbc.util.conexBd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.util.Pair;

public class LoginControlador {

	@FXML
	private Button botonIngresar;

	@FXML
	private TextField usuarioLogin;

	@FXML
	private PasswordField contraseña;

	@FXML
	private Button botonModoOffline;
	
	
	private static Connection conexion = null;
	
	
	@FXML
	void clickBotonIngresar(ActionEvent event) throws IOException {
		conexion = new conexBd().conectarse();	
		
		ConsultaBd consultarUsario = new ConsultaBd(conexion);
		Usuario login = new Usuario();
		consultarUsario.consultarUsuario(usuarioLogin.getText(), contraseña.getText(), login);
		Stage stage = (Stage) botonIngresar.getScene().getWindow();
		System.out.println(usuarioLogin.getText()+contraseña.getText());
		if(usuarioLogin.getText().trim().equals(login.getNombre()) && contraseña.getText().trim().equals(login.getContraseña())) {
			Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/menu.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.setFullScreen(true);
			
		}else {
			 Dialog<Pair<String, String>> dialog = new Dialog<>();
    		 ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
    		    	dialog.setTitle("ALERTA");
    		    	dialog.setHeaderText("Usuario o contraseña invalido, por favor intente de nuevo");	
    		    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
    		    	dialog.show();	  
			}
		}
	
	@FXML
	private void salir(ActionEvent event) {
		System.exit(0);
	}

}
