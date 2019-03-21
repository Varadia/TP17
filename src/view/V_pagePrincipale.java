package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Model;

public class V_pagePrincipale
{
	private Model _mdl;
	private VBox _mainPane;
	
	public VBox start(Scene scene, Model mdl)
	{
		_mdl = mdl;
		_mainPane = new VBox();
		HBox header = new HBox();
		VBox body = new VBox();
		VBox footer = new VBox();
		
		HBox footer_right = new HBox();
		Button b_retour = new Button("Retour");
		b_retour.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	View.changeView(new V_connexion().start(scene, _mdl));
		    }
		});
		Text tapas_total = new Text("0/20");
		Button b_commander = new Button("Commander");
		
		_mdl.loadPersonne();
		
		footer_right.setAlignment(Pos.CENTER_RIGHT);
		footer_right.getChildren().add(tapas_total);
		footer_right.getChildren().add(b_commander);
		
		footer.getChildren().add(b_retour);
		footer.getChildren().add(footer_right);
		
		_mainPane.getChildren().add(header);
		_mainPane.getChildren().add(body);
		_mainPane.getChildren().add(footer);
		
		return _mainPane;
	}
}
