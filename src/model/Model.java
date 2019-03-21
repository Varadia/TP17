package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import tools.Personne;
import view.View;

public class Model
{
	private View _vue;
	
	public void init(View vue)
	{
		_vue = vue;
	}
	
	public void savePersonne(ArrayList<TextField> pseudoList, ArrayList<ColorPicker> colorList)
	{
		try
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp17_bdd", "root", "");
			Statement state = connex.createStatement();
			state.executeUpdate("INSERT INTO Groupe(numeroTable) VALUES (1);");
			
			String query;
			for (int i=0 ; i<pseudoList.size() ; i++)
			{
				query = "INSERT INTO Client(pseudo, couleur, idGroupe) VALUES";
				query += "('"+pseudoList.get(i).getText();
				query += "', '"+colorList.get(i).getValue();
				query += "', 1);";
				state.executeUpdate(query);
			}
			
			connex.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Personne> loadPersonne()
	{
		ArrayList<Personne> personneList = new ArrayList<Personne>();
		try
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp17_bdd", "root", "");
			Statement state = connex.createStatement();
			ResultSet result = state.executeQuery("SELECT pseudo, couleur FROM Client");
			
			while (result.next())
			{
				personneList.add(new Personne(result.getObject(1).toString(), Color.valueOf(result.getObject(2).toString())));
			}
			
			connex.close();
			return personneList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public View get_vue()
	{
		return _vue;
	}
}
