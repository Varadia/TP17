package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Model;
import view.View;
 
public class MainApplication extends Application 
{
	public void start(Stage primaryStage) 
	{	
		View vue = new View();
		Model mdl = new Model();

		vue.init(mdl);
		mdl.init(vue);
		
		Scene scene = new Scene(vue, Color.WHITE);
		primaryStage.setTitle("Commande");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		
		primaryStage.show();
		
		mdl.start();
		vue.start();
	}
  
    public static void main(String[] args) 
    {
    	Application.launch(MainApplication.class);
    }
}