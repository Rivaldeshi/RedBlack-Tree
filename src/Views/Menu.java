package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import SwingComponent.Frame;
import SwingComponent.Panel;
import SwingComponent.TitreButton;

@SuppressWarnings("serial")
public class Menu extends Panel {

	public static TitreButton Accueil = new TitreButton("Accueil");
	public static TitreButton ArbreBinairRecherche = new TitreButton("Arbre Binaire");
	public static TitreButton ArbreRougeNoire = new TitreButton("ARbre rouge et noir");
	public static TitreButton Sommaire = new TitreButton("Sommaire");
	public static TitreButton propos = new TitreButton("A propos");

	Menu(String m) {
		unsetfocus();
		Accueil.focus();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(50, 500));
		this.add(Box.createVerticalGlue());
		this.add(Accueil);
		this.add(Box.createVerticalGlue());
		this.add(ArbreBinairRecherche);
		this.add(Box.createVerticalGlue());
		this.add(ArbreRougeNoire);
		this.add(Box.createVerticalGlue());
		this.add(Sommaire);
		this.add(Box.createVerticalGlue());
		this.add(propos);
		this.add(Box.createVerticalGlue());

		ArbreBinairRecherche.setEnabled(false);
		ArbreRougeNoire.setEnabled(false);
		Sommaire.setEnabled(false);
		Accueil.addActionListener(action);
		ArbreBinairRecherche.addActionListener(action);
		ArbreRougeNoire.addActionListener(action);
		Sommaire.addActionListener(action);
		propos.addActionListener(action);
	}

	public void bon() {
		ArbreBinairRecherche.setEnabled(true);
		ArbreRougeNoire.setEnabled(true);
		Sommaire.setEnabled(true);
	}

	public static void unsetfocus() {
		Accueil.setBackground(Color.white);
		ArbreBinairRecherche.setBackground(Color.white);
		ArbreRougeNoire.setBackground(Color.white);
		Sommaire.setBackground(Color.white);
		propos.setBackground(Color.white);
		Accueil.setForeground(Color.black);
		ArbreBinairRecherche.setForeground(Color.black);
		ArbreRougeNoire.setForeground(Color.black);
		Sommaire.setForeground(Color.black);
		propos.setForeground(Color.black);

	}

	public static ActionListener action = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			unsetfocus();
			if (e.getSource() == Accueil) {
				Frame.splitPane.setRightComponent(new Accueil());
				Accueil.focus();
			} else

			if (e.getSource() == ArbreBinairRecherche) {
				Frame.splitPane
						.setRightComponent(
								new AbreBinaireView(MainView.ArbreRechercheCourant, false));
				ArbreBinairRecherche.focus();

			} else if (e.getSource() == ArbreRougeNoire) {
				Frame.splitPane
						.setRightComponent(new AbreBinaireView(MainView.ArbreRougeNoirCourant, true));
				ArbreRougeNoire.focus();
			} else

			if (e.getSource() == Sommaire) {
				Sommaire.focus();
				Frame.splitPane.setRightComponent(new Sommaire());
			}
			if (e.getSource() == propos) {
				propos.setBackground(Color.BLACK);
				propos.setForeground(Color.white);
				Frame.splitPane.setRightComponent(new Propos());
			}
		}

	};

}
