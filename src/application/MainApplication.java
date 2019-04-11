package application;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import stock.Controller;
import view.View;
 
public class MainApplication extends Application 
{
	public void start(Stage primaryStage) 
	{	
		View vue = new View();
		Controller._vue = vue;
		
		Scene scene = new Scene(vue, Color.WHITE);
		primaryStage.setTitle("Commande");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setMinHeight(primScreenBounds.getHeight() * 0.4);
		primaryStage.setMinWidth(primScreenBounds.getHeight() * 0.4);
		primaryStage.centerOnScreen();
		
		vue.start();
	}
  
    public static void main(String[] args) 
    {
    	Application.launch(MainApplication.class);
    }
}