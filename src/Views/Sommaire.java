package Views;

import java.awt.Color;
import java.util.List;

import SwingComponent.Panel;
import SwingComponent.Titre;

@SuppressWarnings("serial")
public class Sommaire extends Panel {

	public Sommaire() {
		super("Sommaire");

		this.setBackground(Color.WHITE);

		this.add(new Titre("ARBRE BINAIRE DE RECHERCHE"));
		Panel p = DrawTable.Draw(MainView.ArbreRechercheCourant);
		this.add(p);

		this.add(new Titre("ARBRE ROUGE ET NOIRE "));
		Panel p1 = DrawTable.Draw(MainView.ArbreRougeNoirCourant);
		this.add(p1);

	}

}
