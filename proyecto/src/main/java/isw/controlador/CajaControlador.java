package isw.controlador;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import isw.modelo.Producto;
import isw.proyecto.jdbc.util.conexBd;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.print.PrinterJob;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewFocusModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.Pair;


public class CajaControlador implements Initializable{
	
	private static Connection conexion = null;
	
	@FXML
    private Text idFactura;

    @FXML
    private Text fecha;

    @FXML
    private TableView<Producto> tablaFactura;

    @FXML
    private TableColumn<Producto, String> idPro;

    @FXML
    private TableColumn<Producto, String> nombrePro;

    @FXML
    private TableColumn<Producto, String> cantPro;

    @FXML
    private TableColumn<Producto, String> precioPro;

    @FXML
    private VBox boxFactura;
    
    @FXML
    private Text iva;

    @FXML
    private Text total;

    @FXML
    private ScrollPane stock;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnX;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btnEfectivo;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btnCredito;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;

    @FXML
    private Button btnP;

    @FXML
    private Button btnGenerarFactura;

    @FXML
    void clck00(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "00");
    }

    @FXML
    void click0(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "0");
    }

    @FXML
    void click1(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "1");
    }

    @FXML
    void click2(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "2");
    }

    @FXML
    void click3(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "3");
    }

    @FXML
    void click4(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "4");
    }

    @FXML
    void click5(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "5");
    }

    @FXML
    void click6(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "6");
    }

    @FXML
    void click7(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "7");
    }

    @FXML
    void click8(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "8");
    }

    @FXML
    void click9(ActionEvent event) {
    	modificaCampo.setText(modificaCampo.getText() + "9");
    }

    @FXML
    void clickBorrar(ActionEvent event) {
    	modificaCampo.deleteText(modificaCampo.getLength()-1, modificaCampo.getLength());
    }

    @FXML
    void clickCredito(ActionEvent event) {
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	ImageView a = new ImageView(new Image(getClass().getResourceAsStream("/isw/vista/credito.png")));
    	a.resize(400, 300);
    	ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
    	dialog.setTitle("Recibir credito");
    	dialog.setHeaderText("Servicio no disponible actualmente");	
    	dialog.setGraphic(a);
    	dialog.getDialogPane().getButtonTypes().add(btnOk);;
    	dialog.show();	
    }

    @FXML
    void clickEfectivo(ActionEvent event) {
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Recibir efectivo");
    	ImageView a = new ImageView(new Image(getClass().getResourceAsStream("/isw/vista/efectivo.png")));
    	a.resize(400, 300);
    	dialog.setGraphic(a);
    	ButtonType btnOk = new ButtonType("CALCULAR", ButtonData.APPLY);
    	dialog.getDialogPane().getButtonTypes().addAll(btnOk);
    	GridPane grid = new GridPane();
    	grid.setHgap(100);
    	grid.setVgap(100);
    	grid.setPadding(new Insets(20, 150, 10, 10));
    	TextField recibe = new TextField();
    	recibe.setPromptText("CON CUANTO PAGA");
    	TextField cambio = new TextField();
    	grid.add(new Label("RECIBE:"), 0, 0);
    	grid.add(recibe, 1, 0);
    	grid.add(new Label("CAMBIO:"), 0, 1);
    	grid.add(cambio, 1, 1);  	
    	dialog.getDialogPane().setContent(grid);
    	dialog.show();	
    	double tot = Double.valueOf(total.getText().replace("TOTAL:    ", ""));
    	recibe.textProperty().addListener((observable, oldValue, newValue) -> {
    		cambio.setText(String.valueOf((Double.valueOf(recibe.getText()))-tot));
    	});
    }

    @FXML
    void clickGenerarFactura(ActionEvent event) {
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	ImageView a = new ImageView(new Image(getClass().getResourceAsStream("/isw/vista/imprimiendo.gif")));
    	ButtonType btnOk = new ButtonType("OK", ButtonData.OK_DONE);
    	dialog.setTitle("Generar factura");
    	dialog.setHeaderText("Imprimiento factura");	
    	dialog.setGraphic(a);
    	dialog.getDialogPane().getButtonTypes().add(btnOk);
    	imprimir(boxFactura);
    	dialog.show();	
    } 

    @FXML
    void clickP(ActionEvent event) {
    	
    	modificaCampo.setText(modificaCampo.getText() + ".");
    }

    @FXML
    void clickX(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnX.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/caja.fxml"));
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    private TextField modificaCampo;

    @FXML
    private Button btnAgregar;
    
    @FXML
    void clickAgregar(ActionEvent event) {
    	if(modificaCampo.getLength() == 0) {
    		tablaFactura.getItems().add(new Producto("", "", "", ""));	
    	}
    	else {
    		tablaFactura.getItems().add(consultarProducto2(modificaCampo.getText()));	
    	}
    }

	public void initialize(URL arg0, ResourceBundle arg1) {			
		conexion = new conexBd().conectarse();	
		tablaFactura.setEditable(true);
		idPro.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
    	nombrePro.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
    	cantPro.setCellValueFactory(new PropertyValueFactory<Producto, String>("cantidad"));
    	precioPro.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));
		idPro.setCellFactory(TextFieldTableCell.<Producto>forTableColumn());
		nombrePro.setCellFactory(TextFieldTableCell.<Producto>forTableColumn());
		cantPro.setCellFactory(TextFieldTableCell.<Producto>forTableColumn());
		precioPro.setCellFactory(TextFieldTableCell.<Producto>forTableColumn());
			
		idPro.setOnEditCommit((CellEditEvent<Producto, String> event) -> {
			TablePosition<Producto, String> pos = event.getTablePosition();
	    	String nId = event.getNewValue(); 
	    	int row = pos.getRow();
	    	Producto producto = event.getTableView().getItems().get(row);
	    	producto.setId(nId);
	    });
		nombrePro.setOnEditCommit((CellEditEvent<Producto, String> event) -> {
            TablePosition<Producto, String> pos = event.getTablePosition();
            String nId = event.getNewValue(); 
            int row = pos.getRow();
            Producto producto = event.getTableView().getItems().get(row);
            producto.setNombre(nId);
        });
		cantPro.setOnEditCommit((CellEditEvent<Producto, String> event) -> {
            TablePosition<Producto, String> pos = event.getTablePosition();
            String nId = event.getNewValue(); 
            int row = pos.getRow();
            Producto producto = event.getTableView().getItems().get(row);
            producto.setCantidad(nId);
        });
		precioPro.setOnEditCommit((CellEditEvent<Producto, String> event) -> {
            TablePosition<Producto, String> pos = event.getTablePosition();
            String nId = event.getNewValue(); 
            int row = pos.getRow();
            Producto producto = event.getTableView().getItems().get(row);
            producto.setPrecio(nId);
        });
		fecha.setText(fecha.getText() + " " + java.time.LocalDate.now());
		idFactura.setText(idFactura.getText() + " " + String.valueOf((int) (Math.random() * 10000)));
		HBox hb = new HBox();
		Image [] img = new Image[6];
		ImageView [] imgProductos = new ImageView[6];
		final String[] urlImgs = new String [] { "arroz.png", "cereal.png", "gaseosa.png",
				"harina.png", "jabon.png", "leche.png"};	
		for(int i = 0; i < 6; i++) {
			img[i] = new Image(getClass().getResourceAsStream("/isw/vista/"+urlImgs[i]));
			imgProductos[i] = new ImageView(img[i]);
			imgProductos[i].setId(urlImgs[i]);
			imgProductos[i].setFitWidth(250);
			imgProductos[i].setFitHeight(300);
			imgProductos[i].setCursor(Cursor.HAND);
			final ImageView a = imgProductos[i];
			a.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
		         agregarProducto(a.getId());
		         event.consume();
		     });
			hb.getChildren().add(imgProductos[i]);
			stock.setContent(hb);
		}	
		PauseTransition wait = new PauseTransition(Duration.seconds(0.05));
	    wait.setOnFinished((e) -> {
	    	sumatoria();
	        wait.playFromStart();
	    });
	    wait.play();	
	}
	
	private void sumatoria() {
		double sum = 0;
		for(Producto pro : tablaFactura.getItems()) {
			sum += Double.valueOf(pro.getPrecio());
		}
		iva.setText("IVA 19%:           " + String.valueOf(sum*0.19));
		sum += sum * 0.19;
		total.setText("TOTAL:    " + sum);
	}

	private Producto consultarProducto(String nombre) {
		ConsultaBd agregar = new ConsultaBd(conexion);
		return agregar.consultarProducto(nombre);
	}
	
	private Producto consultarProducto2(String id) {
		ConsultaBd agregar = new ConsultaBd(conexion);
		return agregar.consultarProducto2(id);
	}
	
	private void agregarProducto(String nombre) {
		nombre = nombre.substring(0,1).toUpperCase()+nombre.substring(1).toLowerCase();
		nombre = nombre.replace(".png", "");
		tablaFactura.getItems().add(consultarProducto(nombre));	
	}
	
	private void imprimir(Node node)	    {
	        PrinterJob job = PrinterJob.createPrinterJob();
	        if (job != null)
	        {
	            boolean printed = job.printPage(node);	 
	            if (printed)	            {
	                job.endJob();
	            }
	            else
	            {
	            	System.out.println("Error al imprimir");
	            }
	        }
	    }
}
