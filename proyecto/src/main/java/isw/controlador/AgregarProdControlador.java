package isw.controlador;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import com.mysql.cj.Query;
import isw.modelo.Producto;
import isw.proyecto.jdbc.util.conexBd;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AgregarProdControlador implements Initializable {
	
	private static Connection conexion = null;
	
	@FXML
    private Button btnCancelar;
	
	@FXML
    private Button btnAgregar;
	
	 @FXML
	 private TextField fldId;

	 @FXML
	 private TextField fldNombre;
	    
	 @FXML
	 private TextField fldCantidad;

	 @FXML
	 private TextField fldPrecio;
	

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		
		conexion = new conexBd().conectarse();
		btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	ConsultaBd agregarProducto = new ConsultaBd(conexion);

		    		fldId.getText();
					fldNombre.getText();
					fldPrecio.getText();
					fldCantidad.getText(); 

					 agregarProducto.agregarProducto( fldId.getText(), fldNombre.getText(),    Double.parseDouble(fldPrecio.getText())  , Integer.parseInt(fldCantidad.getText()));
					 System.out.println("Producto agregado");


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
