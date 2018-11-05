package isw.controlador;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MenuControlador {

    @FXML
    private Button botonCaja;

    @FXML
    private Button botonGestInv;

    @FXML
    void clickBotonCaja(ActionEvent event) throws IOException {
  	  Stage stage = (Stage) botonCaja.getScene().getWindow();
  	  Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/caja.fxml"));
  	  Scene scene = new Scene(root);
  	  stage.setScene(scene);
  	  stage.show();
  	  //stage.setFullScreen(true);
    }

    @FXML
    void clickBotonGestInv(ActionEvent event) {
    	
    }
}
