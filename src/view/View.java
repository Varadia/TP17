package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import model.Model;
import tools.Resize;

public class View extends BorderPane
{
	private Model _mdl;
	private BorderPane _mainPane;
	
	public void init(Model mdl)
	{
		_mdl = mdl;
		
		_mainPane = new BorderPane();
		this.setCenter(_mainPane);
	}
	
	public void start()
	{
		Scene scene = _mainPane.getScene();
		_mainPane.setMaxSize(Resize.getHeight(scene, 1000), Resize.getHeight(scene, 600));
		
		_mainPane.setCenter((new V_connexion()).start(scene));
	}
	
	public Model get_mdl()
	{
		return _mdl;
	}
}
