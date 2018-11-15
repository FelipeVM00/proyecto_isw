package isw.controlador;

import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import isw.proyecto.jdbc.util.conexBd;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import javafx.util.Pair;

public class EliminarProdControlador implements Initializable {
	
	private static Connection conexion = null;
	
	@FXML
    private Button btnCancelar;
	
	@FXML
    private Button btnAceptar;
	
	@FXML
	private TextField fldId;

	@FXML
	private TextField fldNombre;
	
	@FXML
	private TextField fldCantidad;
	
	@FXML
    void clickBtnCancelar(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/gestionarInventario.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
    }

	
	
	public void initialize(URL location, ResourceBundle resources) {
    		fldNombre.setText("");
			fldId.setText("");

		conexion = new conexBd().conectarse();
		btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
	
		    	
		    	ConsultaBd eliminarProducto = new ConsultaBd(conexion);
		    	if (fldNombre.getText().trim().isEmpty() ) {
		    		if ( fldId.getText().trim().isEmpty()) {
		    		 Dialog<Pair<String, String>> dialog = new Dialog<>();
		    		 ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
		    		    	dialog.setTitle("ALERTA");
		    		    	dialog.setHeaderText("Por favor llene el campo de Id o el de Nombre");	
		    		    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
		    		    	dialog.show();	  
		    		}
		    		eliminarProducto.eliminarProducto( fldCantidad.getText(), fldId.getText());
		    		 Dialog<Pair<String, String>> dialog = new Dialog<>();
		    		 ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
		    		    	dialog.setTitle("EXITO");
		    		    	dialog.setHeaderText("Producto eliminado");	
		    		    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
		    		    	dialog.show();	  
		    	}else {
		    		eliminarProducto.eliminarProducto2( fldCantidad.getText(), fldNombre.getText());
		    		 Dialog<Pair<String, String>> dialog = new Dialog<>();
		    		 ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
		    		    	dialog.setTitle("EXITO");
		    		    	dialog.setHeaderText("Producto eliminado");	
		    		    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
		    		    	dialog.show();	 
		    	}

		    }
		});
		
		btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/isw/vista/gestionarInventario.fxml"));
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
					stage.setFullScreen(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    });

	}

}
