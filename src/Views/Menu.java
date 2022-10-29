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
	public static TitreButton ArbreBinair = new TitreButton("Arbre Binaire");
	public static TitreButton ArbreRougeNoire = new TitreButton("ARbre rouge et noir");
	public static TitreButton Legende = new TitreButton("Legende");
	public static TitreButton propos = new TitreButton("A propos");

	Menu(String m) {
		unsetfocus();
		Accueil.focus();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(50, 500));
		this.add(Box.createVerticalGlue());
		this.add(Accueil);
		this.add(Box.createVerticalGlue());
		this.add(ArbreBinair);
		this.add(Box.createVerticalGlue());
		this.add(ArbreRougeNoire);
		this.add(Box.createVerticalGlue());
		this.add(Legende);
		this.add(Box.createVerticalGlue());
		this.add(propos);
		this.add(Box.createVerticalGlue());

		ArbreBinair.setEnabled(false);
		ArbreRougeNoire.setEnabled(false);
		Accueil.addActionListener(action);
		ArbreBinair.addActionListener(action);
		ArbreRougeNoire.addActionListener(action);
		Legende.addActionListener(action);
		propos.addActionListener(action);
	}

	public void bon() {
		ArbreBinair.setEnabled(true);
		ArbreRougeNoire.setEnabled(true);
	}

	public static void unsetfocus() {
		Accueil.setBackground(Color.white);
		ArbreBinair.setBackground(Color.white);
		ArbreRougeNoire.setBackground(Color.white);
		Legende.setBackground(Color.white);
		propos.setBackground(Color.white);

		Accueil.setForeground(Color.black);
		ArbreBinair.setForeground(Color.black);
		ArbreRougeNoire.setForeground(Color.black);
		Legende.setForeground(Color.black);
		propos.setForeground(Color.black);

	}

	public static ActionListener action = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			unsetfocus();
			if (e.getSource() == Accueil) {
				Frame.splitPane.setRightComponent(new Verification());
				Accueil.focus();
			} else

			if (e.getSource() == ArbreBinair) {

				Frame.splitPane.setRightComponent(new AbreBinaireView(
						MainView.ArbreCourant));
				ArbreBinair.focus();

			} else

			if (e.getSource() == Legende) {
				Legende.focus();
				Frame.splitPane.setRightComponent(new Legende());
			}
			if (e.getSource() == propos) {
				propos.setBackground(Color.BLACK);
				propos.setForeground(Color.white);
				Frame.splitPane.setRightComponent(new Propos());
			}
		}

	};

}
