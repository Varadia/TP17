package tools;

import javafx.scene.paint.Color;

public class Personne
{
	private String _pseudo;
	private Color _colorValue;

	public Personne(String pseudo, Color colorValue)
	{
		_pseudo = pseudo;
		_colorValue = colorValue;
	}
	
	public String get_pseudo()
	{
		return _pseudo;
	}
	
	public Color get_colorValue()
	{
		return _colorValue;
	}
}
