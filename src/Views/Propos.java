package Views;

import java.awt.Color;
import SwingComponent.Label;
import SwingComponent.Panel;
import SwingComponent.Titre;
import Utils.Constans;

@SuppressWarnings("serial")
public class Propos extends Panel {
	public static int i = 0;

	Propos() {
		super("A propos");

		Label l = new Label(
				"<html>   <br>  <u><center>    Bienvenue Sur  " + Constans.title + " </center></u> </html> ",
				27);
		l.setForeground(Color.BLUE);

		this.add(l);

		Label lab = new Label(
				"<html> <center>Cette application est surnomer AbreBinaireDeRecherhe base a pour but... "
						+ "aplication tres facile a utiliser <br> propoer par des etudiant d'informatique 4 UDS <br>"
						+ "<br> contacter nous par Nous@gmail.com"
						+ " </center> </html>");

		
		lab.setForeground(Color.BLACK);

		this.add(lab);
		this.add(new Titre("RIVALDES"));
		this.add(new Titre("MANICK"));
		this.add(new Titre("DALISHA"));
		this.add(new Titre("RONALDO"));
	}

}
