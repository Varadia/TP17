package application;

import javafx.scene.layout.BorderPane;
import model.Model;

public class View extends BorderPane
{
	private Model _mdl;
	private BorderPane _mainPane;
	
	public void init(Model mdl)
	{
		_mdl = mdl;
	}
	
	public void start()
	{
		_mainPane = new BorderPane();
		
		this.setCenter(_mainPane);
	}
	
	public Model get_mdl()
	{
		return _mdl;
	}
}
