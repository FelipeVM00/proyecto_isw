package isw.proyecto;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
	@Override
	public void start(Stage stage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/isw/vista/login.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();   
	//	stage.setFullScreen(true);
	}
	public static void main( String[] args )
	{
	        launch(args);
	}
}
