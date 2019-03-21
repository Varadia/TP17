package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import model.Model;
import tools.Resize;

public class V_connexion
{
	private Model _mdl;
	private VBox _mainPane;
	private ArrayList<TextField> _pseudoList;
	private ArrayList<ColorPicker> _colorList;
	
	public VBox start(Scene scene, Model mdl)
	{
		_mdl = mdl;
		_mainPane = new VBox();
		_pseudoList = new ArrayList<TextField>();
		_colorList = new ArrayList<ColorPicker>();
		
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
		    	if (_pseudoList.get(0).getText().length() > 2)
		    	{
			    	_mdl.savePersonne(_pseudoList, _colorList);
			    	View.changeView(new V_pagePrincipale().start(scene, _mdl));
		    	}
		    }
		});
		
		valueFactory.setValue(1);
		addPersonne(box_personne, valueFactory.getValue());
		
		box_personne.setPrefHeight(Resize.getHeight(scene, 300));
		
		text.setFont(Font.font("Arial", 20));
		
		txt_nbrPersonne.setTextAlignment(TextAlignment.CENTER);
		spin_nbrPersonne.setValueFactory(valueFactory);
		spin_nbrPersonne.setPrefWidth(Resize.getWidth(scene, 100));
		
		box_nbrPersonne.setSpacing(10);
		box_nbrPersonne.setPadding(new Insets(40,0,20,0));
		box_nbrPersonne.getChildren().add(txt_nbrPersonne);
		box_nbrPersonne.getChildren().add(spin_nbrPersonne);
		
		_mainPane.setAlignment(Pos.CENTER);
		
		_mainPane.getChildren().add(text);
		_mainPane.getChildren().add(box_nbrPersonne);
		_mainPane.getChildren().add(box_personne);
		_mainPane.getChildren().add(b_valider);
		
		return _mainPane;
	}
	
	//Ajouter une liste pour ne remove que le dernier élément
	public void addPersonne(VBox pane, int value)
	{
		pane.getChildren().clear();
		_pseudoList.clear();
		_colorList.clear();
		
		for (int i=0 ; i<value ; i++)
		{
			HBox subpane = new HBox();
			
			Text txt_personne = new Text("Convive n°" + (i+1));
			TextField txtfield_personne = new TextField();
			ColorPicker color_personne = new ColorPicker();
			
			subpane.setAlignment(Pos.CENTER);
			subpane.setPadding(new Insets(4,0,4,0));
			subpane.setSpacing(10);
			subpane.getChildren().add(txt_personne);
			subpane.getChildren().add(txtfield_personne);
			subpane.getChildren().add(color_personne);
			
			_pseudoList.add(txtfield_personne);
			_colorList.add(color_personne);
			pane.getChildren().add(subpane);
		}
	}
}
