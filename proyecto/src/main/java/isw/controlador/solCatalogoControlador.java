package isw.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Pair;

public class solCatalogoControlador {

	@FXML
    private Button botonVolver;
	
	@FXML
    private Button botonGuardarCatalogo;
	
	@FXML
    private Button botonExportar;
	
	@FXML
    private Button botonFiltrar;
	
	@FXML
    void clickBotonVolver(ActionEvent event) throws IOException {
		Stage stage = (Stage) botonVolver.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/gestPedidos.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
	
	@FXML
    void clickBotonExportar(ActionEvent event) {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
    	ImageView a = new ImageView(new Image(getClass().getResourceAsStream("/isw/vista/pdf.png")));
    	a.resize(20, 10);
    	ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
    	dialog.setTitle("exportar documento");
    	dialog.setHeaderText("archivo guardado con exito");	
    	dialog.setGraphic(a);
    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
    	dialog.show();	
    }
	
	@FXML
    void clickBotonFiltrar(ActionEvent event) throws IOException {
	
    }
	
	@FXML
    void clickBotonGuardarCatalogo(ActionEvent event) {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
    	ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
    	dialog.setTitle("guardar catalogo");
    	dialog.setHeaderText("el catalogo ha sido guardado \nrevise la opcion realizar pedidos");	
    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
    	dialog.show();
    }

}
