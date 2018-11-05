package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class GestPedControlador {

	@FXML
    private Button botonVolver;
	
	@FXML
    private Button botonAceptar;
	
	@FXML
    private RadioButton botonSolicitarCatalogo;
	
	@FXML
    private RadioButton botonRealizarPedido;
	
	@FXML
    private RadioButton botonRecibirPedido;
	
	@FXML
    private RadioButton botonVerificarPedido;
		
	@FXML
    private RadioButton botonPagarPedido;
	
	@FXML
    void clickBotonVolver(ActionEvent event) throws IOException {
		Stage stage = (Stage) botonVolver.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/menu.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
    }
	
	@FXML
    void clickBotonAceptar(ActionEvent event) throws IOException {
		if(botonSolicitarCatalogo.isSelected()) {
			Stage stage = (Stage) botonAceptar.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/solicitarCatalogo.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		if(botonRealizarPedido.isSelected()) {
			Stage stage = (Stage) botonAceptar.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/realizarPedido.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		
	}
}
