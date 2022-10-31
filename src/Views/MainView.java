package Views;

import java.util.ArrayList;
import java.util.List;

//import Arbre.ArbreBinaire;
import Arbre.ArbreBinaireDeRecheche;
import Arbre.ArbreRougeEtNoir;
import SwingComponent.Frame;

@SuppressWarnings("serial")
public class MainView extends Frame {

	public static ArbreBinaireDeRecheche ArbreRechercheCourant;
	public static ArbreRougeEtNoir ArbreRougeNoirCourant;
	final public static List<Integer> TableauxCourant = new ArrayList<>();
	public static Menu menu = new Menu("hello");
	public static Accueil accueil = new Accueil();

	public MainView() {
		super(accueil, menu);
	}
}
