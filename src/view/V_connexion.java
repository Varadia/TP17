package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import tools.Resize;

public class V_connexion
{
	VBox _mainPane;
	
	public VBox start(Scene scene)
	{
		_mainPane = new VBox();
		
		Text text = new Text("Bienvenue à la borne de commande !");
		
		HBox box_nbrPersonne = new HBox();
		Text txt_nbrPersonne = new Text("Nombres de personnes");
		Spinner<Integer> spin_nbrPersonne = new Spinner<Integer>();
		VBox box_personne = new VBox();
		Button b_valider = new Button("Valider");
		
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
		valueFactory.setValue(1);
		addPersonne(box_personne, valueFactory.getValue());
		
		box_personne.setPrefHeight(Resize.getHeight(scene, 300));
		
		text.setTextAlignment(TextAlignment.CENTER);
		
		txt_nbrPersonne.setTextAlignment(TextAlignment.CENTER);
		spin_nbrPersonne.setValueFactory(valueFactory);
		spin_nbrPersonne.setPrefWidth(Resize.getWidth(scene, 100));
		
		box_nbrPersonne.getChildren().add(txt_nbrPersonne);
		box_nbrPersonne.getChildren().add(spin_nbrPersonne);
		
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
		
		for (int i=0 ; i<value ; i++)
		{
			HBox subpane = new HBox();
			
			Text txt_personne = new Text("Convive n°" + (i+1));
			TextField txtfield_personne = new TextField();
			ColorPicker color_personne = new ColorPicker();
			
			subpane.getChildren().add(txt_personne);
			subpane.getChildren().add(txtfield_personne);
			subpane.getChildren().add(color_personne);
			
			pane.getChildren().add(subpane);
		}
	}
}
