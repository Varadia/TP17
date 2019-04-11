package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class V_pagePrincipale
{
	private VBox _mainPane;
	
	public V_pagePrincipale()
	{
		_mainPane = new VBox();
		HBox header = new HBox();
		VBox body = new VBox();
		VBox footer = new VBox();
		
		body.setPadding(new Insets(20));
		
		TabPane tabPane = new TabPane();
		tabPane.setPrefHeight(800);
		tabPane.setStyle("-fx-background-color: #ccc;");
		
		String[] tabList = {"végétariennes","à la viande","de la mer","froides","chaudes"};
		int[][] tapasList = {{1,2,3},{4,5,6},{1,3,5},{2,4,6},{1,3,6}};
		for (int i=0 ; i<5 ; i++)
		{
			Tab tab = new Tab();
			tab.setText("Tapas "+tabList[i]);
			tab.setClosable(false);
			
			VBox content = new VBox();
			content.setPadding(new Insets(20));
			for (int j=0 ; j<tapasList[i].length ; j++)
			{
				Text tapas = new Text("Tapas n°"+tapasList[i][j]);
				content.getChildren().add(tapas);
			}
			
			tab.setContent(content);
			
			tabPane.getTabs().add(tab);
		}
		
		HBox footer_right = new HBox();
		Button b_retour = new Button("Retour");
		b_retour.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	View.changeView(new V_connexion().get_mainPane());
		    }
		});
		Text tapas_total = new Text("0/20");
		Button b_commander = new Button("Commander");
		
		body.getChildren().add(tabPane);
		
		footer_right.setAlignment(Pos.CENTER_RIGHT);
		footer_right.getChildren().add(tapas_total);
		footer_right.getChildren().add(b_commander);
		
		footer.getChildren().add(b_retour);
		footer.getChildren().add(footer_right);
		
		_mainPane.getChildren().add(header);
		_mainPane.getChildren().add(body);
		_mainPane.getChildren().add(footer);
	}
	
	public Node get_mainPane()
	{
		return _mainPane;
	}
}
