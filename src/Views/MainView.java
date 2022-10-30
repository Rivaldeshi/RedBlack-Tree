package Views;

import Arbre.ArbreBinaire;
import Arbre.ArbreBinaireDeRecheche;
import Arbre.ArbreRougeEtNoir;
import Arbre.Noeud;
import SwingComponent.Frame;

@SuppressWarnings("serial")
public class MainView extends Frame {

	//public static ArbreBinaireDeRecheche ArbreCourant = new ArbreBinaireDeRecheche();;
	public static ArbreRougeEtNoir ArbreCourant = new ArbreRougeEtNoir();
	public static Menu menu = new Menu("hello");
	// public static Verification verif = new Verification();

	static {
		// int[] elems = { 6, 8, 2, 0, 5, 7, 4, 9 };
	//	int[] elems = { 10, 7, 42, 5, 31, 64, 50, 83, 29, 23 };
    //	int[] elems = { 10, 5,12,2,8,6,9 };
    
		int[] elems = { 1, 2,3};
      
		for (int i = 0; i < elems.length; i++) {

			ArbreCourant.InserNoeud(elems[i]);
		}
		
		ArbreCourant.actualiserListeDesNoeuds();

		

		ArbreCourant.printArbre();
		//ArbreCourant.RoationDroitDansArbre(31);
	   // ArbreCourant.RoationDroitDansArbre(31);
	  //	ArbreCourant.RoationGaucheDansArbre(29);
		
		ArbreCourant.printArbre();

		ArbreCourant.actualiserListeDesNoeuds();
		ArbreCourant.printArbre();
	}

	public static AbreBinaireView arbreview = new AbreBinaireView(ArbreCourant);

	public MainView() {

		super(arbreview, menu);

	}
}
