package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import stock.Data;

public class V_connexion
{
	private VBox _mainPane;
	
	public V_connexion()
	{
		_mainPane = new VBox();
		Text text = new Text("Bienvenue à la borne de commande !");
		
		HBox box_nbrPersonne = new HBox();
		Text txt_nbrPersonne = new Text("Nombres de personnes");
		VBox box_personne = new VBox();
		Spinner<Integer> spin_nbrPersonne = new Spinner<Integer>();		
		SpinnerValueFactory<Integer> valueFactory = 
				new SpinnerValueFactory<Integer>()
				{
					public void decrement(int steps)
					{
						int value = this.getValue();
						if (value > 1)
						{
							addPersonne(box_personne, value-steps);
			                this.setValue(value-steps);
						}
		            }

					public void increment(int steps)
					{
						int value = this.getValue();
						if (value < 4)
						{
							addPersonne(box_personne, value+steps);
			                this.setValue(value+steps);
						}
					}
				};
				
		Button b_valider = new Button("Valider");
		b_valider.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	Boolean isEmpty = true;
		    	for (int i=0 ; i<Data._pseudoList.size() ; i++)
		    	{
			    	if (Data._pseudoList.get(i).getText().length() > 2)
			    	{
			    		isEmpty = false;
			    	}
		    	}
		    	if (!isEmpty)
		    	{
			    	View.changeView(new V_pagePrincipale().get_mainPane());
		    	}
		    }
		});
		
		if (Data._pseudoList == null)
		{
			Data._pseudoList = new ArrayList<TextField>();
			Data._colorList = new ArrayList<ColorPicker>();
			
			valueFactory.setValue(1);
			addPersonne(box_personne, valueFactory.getValue());
		}
		else
		{
			valueFactory.setValue(Data._pseudoList.size());
			setPersonne(box_personne, valueFactory.getValue());
		}
		
		
		box_personne.setPrefHeight(300);
		
		text.setFont(Font.font("Arial", 20));
		
		txt_nbrPersonne.setTextAlignment(TextAlignment.CENTER);
		spin_nbrPersonne.setValueFactory(valueFactory);
		spin_nbrPersonne.setPrefWidth(100);
		
		box_nbrPersonne.setSpacing(10);
		box_nbrPersonne.setPadding(new Insets(40,0,20,0));
		box_nbrPersonne.getChildren().add(txt_nbrPersonne);
		box_nbrPersonne.getChildren().add(spin_nbrPersonne);
		
		_mainPane.setAlignment(Pos.CENTER);
		
		_mainPane.getChildren().add(text);
		_mainPane.getChildren().add(box_nbrPersonne);
		_mainPane.getChildren().add(box_personne);
		_mainPane.getChildren().add(b_valider);
	}
	
	private void setPersonne(VBox pane, int value)
	{
		for (int i=0 ; i<value ; i++)
		{
			HBox subpane = new HBox();
			
			Text txt_personne = new Text("Convive n°" + (i+1));
			TextField txtfield_personne = Data._pseudoList.get(i);
			ColorPicker color_personne = Data._colorList.get(i);
			
			subpane.setAlignment(Pos.CENTER);
			subpane.setPadding(new Insets(4,0,4,0));
			subpane.setSpacing(10);
			subpane.getChildren().add(txt_personne);
			subpane.getChildren().add(txtfield_personne);
			subpane.getChildren().add(color_personne);
			
			pane.getChildren().add(subpane);
		}
	}

	public void addPersonne(VBox pane, int value)
	{			
		if (Data._pseudoList.size() < value)
		{
			for (int i=0 ; i<(value-Data._pseudoList.size()) ; i++)
			{
				HBox subpane = new HBox();
				
				Text txt_personne = new Text("Convive n°" + (Data._pseudoList.size()+1));
				TextField txtfield_personne = new TextField();
				ColorPicker color_personne = new ColorPicker();
				
				subpane.setAlignment(Pos.CENTER);
				subpane.setPadding(new Insets(4,0,4,0));
				subpane.setSpacing(10);
				subpane.getChildren().add(txt_personne);
				subpane.getChildren().add(txtfield_personne);
				subpane.getChildren().add(color_personne);
				
				Data._pseudoList.add(txtfield_personne);
				Data._colorList.add(color_personne);
				pane.getChildren().add(subpane);
			}
		}
		else if (Data._pseudoList.size() > value)
		{
			for (int i=0 ; i<(Data._pseudoList.size()-value) ; i++)
			{				
				pane.getChildren().remove(Data._pseudoList.size()-1);
				Data._pseudoList.remove(Data._pseudoList.size()-1);
				Data._colorList.remove(Data._colorList.size()-1);
			}
		}
	}
	
	public Node get_mainPane()
	{
		return _mainPane;
	}
}


