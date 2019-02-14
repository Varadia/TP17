package model;

import application.View;

public class Model
{
	private View _vue;
	
	public void init(View vue)
	{
		_vue = vue;
	}
	
	public void start()
	{
		
	}
	
	public View get_vue()
	{
		return _vue;
	}
}
