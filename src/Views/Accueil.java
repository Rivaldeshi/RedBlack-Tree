package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Arbre.ArbreBinaireDeRecheche;
import SwingComponent.Button;
import SwingComponent.Label;
import SwingComponent.Panel;
import SwingComponent.Text;
import Utils.Constans;

@SuppressWarnings("serial")
public class Accueil extends Panel {

	DrawTable Table;

	Accueil() {
		super("Bienvenue sur les arbres binaire de recherche");
		this.setBackground(Color.WHITE);
		// Panel de taille du tableaux
		Panel ptailleTableau = new Panel();

		Label lnbelm = new Label("Nombre element du tableau");

		final Label erreur = new Label("");

		erreur.setForeground(Color.red);
		// les bouton
		Button valider = new Button("Valider");

		final Button valider1 = new Button("Valider les elements");

		final Text nbelem = new Text(0);

		ptailleTableau.add(lnbelm);
		ptailleTableau.add(nbelem);
		ptailleTableau.add(valider);
		ptailleTableau.add(erreur);
		ptailleTableau.setBackground(Color.white);
		ptailleTableau.setLayout(new FlowLayout());
		ptailleTableau.setPreferredSize(new Dimension(Constans.framewidh, 50));

		final Panel p1 = new Panel();

		p1.add(ptailleTableau);
		p1.setBackground(Color.white);

		// le tableau a entrer les elements
		final Panel pEntrer = new Panel();

		p1.add(pEntrer);

		this.add(p1);

		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int a = Integer.parseInt(nbelem.getText());

					Table = new DrawTable(a);
					pEntrer.removeAll();
					pEntrer.add(Table);
					pEntrer.repaint();
					pEntrer.revalidate();
					p1.add(valider1);
					p1.repaint();
					p1.revalidate();
					erreur.setText("");
				} catch (Exception e1) {
					erreur.setText("Erreur de saisie");
				}
			}
		});

		valider1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					List<Integer> elmes = Table.getElem();
					MainView.AbreCourant = new ArbreBinaireDeRecheche(elmes);
					MainView.TableauxCourant = elmes;
					MainView.menu.bon();
				} catch (Exception e1) {
					erreur.setText("Erreur de saisie");
				}
			}
		});

		Table = new DrawTable(7);
		pEntrer.removeAll();
		pEntrer.add(Table);
		pEntrer.repaint();
		pEntrer.revalidate();
		p1.add(valider1);
		p1.repaint();
		p1.revalidate();

	}

}
