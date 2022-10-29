package Views;

import Arbre.ArbreBinaireDeRecheche;
import SwingComponent.Frame;

@SuppressWarnings("serial")
public class MainView extends Frame {

	public static ArbreBinaireDeRecheche ArbreCourant = new ArbreBinaireDeRecheche(3);;
	public static Menu menu = new Menu("hello");
	// public static Verification verif = new Verification();

	static {
		int[] elems = { 6, 8, 2, 0,5,7,4,9};
		
		for (int i = 0; i < elems.length; i++) {
           ArbreCourant.InserNoeud(elems[i]);
		}
	}

	public static AbreBinaireView arbreview = new AbreBinaireView(ArbreCourant);

	public MainView() {

		super(arbreview, menu);

	}
}
