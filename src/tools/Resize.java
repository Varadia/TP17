package tools;

import javafx.scene.Scene;

public class Resize
{
	public static double getHeight(Scene scene, double height)
	{			
		return height * (scene.getHeight() / 1080);
	}
	
	public static double getWidth(Scene scene, double width)
	{			
		return width * (scene.getWidth() / 1920);
	}
}
