package Views;

import java.util.List;

import Arbre.ArbreBinaire;
import SwingComponent.Frame;

@SuppressWarnings("serial")
public class MainView extends Frame {

	public static ArbreBinaire AbreCourant;
	public static List<Integer> TableauxCourant;
	public static Menu menu = new Menu("hello");
	public static Accueil accueil = new Accueil();

	public MainView() {

		super(accueil, menu);

	}
}
