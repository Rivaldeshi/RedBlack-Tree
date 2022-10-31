package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Arbre.*;
import DrawArbre.Draw;
import SwingComponent.Header;
import SwingComponent.Panel;
import SwingComponent.Text;
import SwingComponent.TitreButton;

@SuppressWarnings("serial")
public class AbreBinaireView extends Panel {

	final public TitreButton INSERTION = new TitreButton("INSERTION");
	final public TitreButton SUPPRESSION = new TitreButton("SUPPRESSION");
	final public TitreButton ROTATIONG = new TitreButton("ROTATION GAUCHE");
	final public TitreButton ROTATIOND = new TitreButton("ROTATION DROITE");
	final public Text Element = new Text(0);

	final Panel footer = new Panel();

	AbreBinaireView(final ArbreBinaire arbreBinaire, final Boolean isRougeEtNoir) {

		super();
		try {
			footer.add(Draw.drawArbre(arbreBinaire, "ARBRE BINAIRE DE RECHERCHE (Vue )", isRougeEtNoir));
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

		List<TitreButton> heads = new ArrayList<TitreButton>();

		heads.add(INSERTION);
		heads.add(SUPPRESSION);
		heads.add(ROTATIOND);
		heads.add(ROTATIONG);

		Header header = new Header(Element, heads);
		this.add(footer);
		this.add(header);

		ActionListener acc = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					footer.removeAll();
					if (e.getSource() == ROTATIOND) {

						int Nombre = Integer.parseInt(Element.getText());
						if (isRougeEtNoir) {
							ArbreRougeEtNoir abrn = MainView.ArbreRougeNoirCourant;
							abrn.RoationDroitDansArbre(Nombre);
							footer.add(Draw.drawArbre(abrn, "ARBRE ROUGE ET NOIR : ROTATION DROITE  " + Nombre,
									isRougeEtNoir));
						} else {
							ArbreBinaireDeRecheche abrn = MainView.ArbreRechercheCourant;
							abrn.RoationDroitDansArbre(Nombre);
							footer.add(Draw.drawArbre(abrn, "ARBRE BINAIRE DE RECHERCHE : ROTATION DROITE  " + Nombre,
									isRougeEtNoir));
						}

					} else if (e.getSource() == INSERTION) {

						try {
							int Nombre = Integer.parseInt(Element.getText());

							if (isRougeEtNoir) {
								MainView.ArbreRougeNoirCourant.InserNoeud(Nombre);
								footer.add(Draw.drawArbre(MainView.ArbreRougeNoirCourant,
										"ARBRE ROUGE ET NOIR : INSERTION  " + Nombre,
										isRougeEtNoir));
							} else {
								MainView.ArbreRechercheCourant.InserNoeud(Nombre);
								footer.add(
										Draw.drawArbre(MainView.ArbreRechercheCourant,
												"ARBRE BINAIRE DE RECHERCHE : INSERTION " + Nombre,
												isRougeEtNoir));
							}

						} catch (Exception excep) {
							// TODO: handle exception
						}

					} else if (e.getSource() == ROTATIONG) {

						int Nombre = Integer.parseInt(Element.getText());
						if (isRougeEtNoir) {
							ArbreRougeEtNoir abrn = MainView.ArbreRougeNoirCourant;
							abrn.RoationGaucheDansArbre(Nombre);
							footer.add(Draw.drawArbre(abrn, "ARBRE ROUGE ET NOIR : ROTATION GAUCHE  " + Nombre,
									isRougeEtNoir));
						} else {
							ArbreBinaireDeRecheche abrn = MainView.ArbreRechercheCourant;
							abrn.RoationGaucheDansArbre(Nombre);
							footer.add(Draw.drawArbre(abrn, "ARBRE BINAIRE DE RECHERCHE : ROTATION GAUCHE  " + Nombre,
									isRougeEtNoir));
						}

					} else if (e.getSource() == SUPPRESSION) {
						try {
							int Nombre = Integer.parseInt(Element.getText());

							if (isRougeEtNoir) {
								MainView.ArbreRougeNoirCourant.SupressionNoeud(Nombre);
								footer.add(Draw.drawArbre(MainView.ArbreRougeNoirCourant,
										"ARBRE ROUGE ET NOIR : SUPPRESSION  " + Nombre,
										isRougeEtNoir));
							} else {
								MainView.ArbreRechercheCourant.SupressionNoeud(Nombre);
								footer.add(
										Draw.drawArbre(MainView.ArbreRechercheCourant,
												"ARBRE BINAIRE DE RECHERCHE : SUPPRESSION  " + Nombre,
												isRougeEtNoir));
							}
						} catch (Exception excep) {
							excep.printStackTrace();
							// TODO: handle exception
						}
					}

					footer.repaint();
					footer.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		};

		for (TitreButton btn : heads) {
			btn.addActionListener(acc);
		}

	}

}
