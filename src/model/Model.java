package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import stock.Data;
import tools.Personne;

public class Model
{
	public void savePersonne()
	{
		try
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp17_bdd", "root", "");
			Statement state = connex.createStatement();
			state.executeUpdate("INSERT INTO Groupe(numeroTable) VALUES (1);");
			
			String query;
			for (int i=0 ; i<Data._pseudoList.size() ; i++)
			{
				query = "INSERT INTO Client(pseudo, couleur, idGroupe) VALUES";
				query += "('"+Data._pseudoList.get(i).getText();
				query += "', '"+Data._colorList.get(i).getValue();
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
}
