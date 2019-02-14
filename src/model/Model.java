package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

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
		try
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			connex.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public View get_vue()
	{
		return _vue;
	}
}
