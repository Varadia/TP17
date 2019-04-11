package view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import stock.Controller;
import tools.Resize;

public class View extends BorderPane
{
	private static BorderPane _root;
	
	public View()
	{
		_root = new BorderPane();
		this.setCenter(_root);
	}
	
	public void start()
	{
		Scene scene = _root.getScene();
		_root.setMaxSize(Resize.getWidth(scene, 1400), Resize.getHeight(scene, 800));
		
		changeView(new V_connexion().get_mainPane());
	}
	
	public static void changeView(Node page)
	{
		Controller._actualNode = page;
		_root.getChildren().clear();
		_root.setCenter(page);
	}
}
