package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import SwingComponent.Label;
import SwingComponent.Panel;
import SwingComponent.Titre;
import Utils.Constans;

@SuppressWarnings("serial")
public class Sommaire extends Panel {

	public Sommaire() {
		super("Sommaire");

		this.setBackground(Color.WHITE);

		this.add(new Titre("ARBRE BINAIRE DE RECHERCHE", Color.DARK_GRAY, Color.white));
		Panel p = DrawTable.Draw(MainView.ArbreRechercheCourant);
		this.add(p);

		this.add(new Titre("ARBRE ROUGE ET NOIRE ", Color.DARK_GRAY, Color.white));
		Panel p1 = DrawTable.Draw(MainView.ArbreRougeNoirCourant);
		this.add(p1);

		this.add(resulta());

	}

	public Panel resulta() {

		Panel pResulta = new Panel("RECAPITULATIF");
		pResulta.setPreferredSize(new Dimension(Constans.framewidh - 100, 250));
		pResulta.setBackground(Color.white);

		Panel ArbreBinaire = new Panel("ARBRE BINAIRE DE RECHERCHE", 0.0);
		Panel arbreRN = new Panel("ABRE ROUGE ET NOIR", 0.0);

		ArbreBinaire.add(new Label("Hauteur  : " + MainView.ArbreRechercheCourant.Hauteur()));
		ArbreBinaire.add(new Label("Complexite Insertion : O(log n) "));
		ArbreBinaire.add(new Label("Complexite supression : O(log n) "));
		ArbreBinaire.add(new Label("Complexite Rotation : O(1) "));
		ArbreBinaire.add(new Label("Complexite Recherche : O(log n) "));

		arbreRN.add(new Label("Hauteur Noir : " + MainView.ArbreRougeNoirCourant.HauteurNoir()));
		arbreRN.add(new Label("Complexite Insertion : O(log n) "));
		arbreRN.add(new Label("Complexite supression : O(log n) "));
		arbreRN.add(new Label("Complexite Rotation : O(1) "));
		arbreRN.add(new Label("Complexite Recherche : O(log n) "));

		Panel res = new Panel();

		res.setLayout(new FlowLayout());
		res.add(ArbreBinaire);
		res.add(arbreRN);

		pResulta.add(res);

		return pResulta;
	}

}
