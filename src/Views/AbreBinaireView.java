package Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Arbre.*;
import DrawAutomate.Draw;
import SwingComponent.Header;
import SwingComponent.Panel;
import SwingComponent.TitreButton;

@SuppressWarnings("serial")
public class AbreBinaireView extends Panel {

	public static Panel menu = new Panel();

	public static TitreButton VUE = new TitreButton("Vue");
	public static TitreButton INSERTION = new TitreButton("INSERTION");
	public static TitreButton SUPPRESSION = new TitreButton("SUPPRESSION");
	public static TitreButton ROTATION = new TitreButton("ROTATION");

	Panel footer = new Panel();

	AbreBinaireView(final ArbreBinaire arbreBinaire) {

		super();
		unsetfocus();
		VUE.focus();
		try {
			footer.add(Draw.drawArbre(arbreBinaire, "Vue"));

		} catch (Exception e) {
			// TODO: handle exception
		}

		List<TitreButton> heads = new ArrayList<TitreButton>();
		heads.add(VUE);
		heads.add(INSERTION);
		heads.add(SUPPRESSION);
		heads.add(ROTATION);

		Header header = new Header(heads);
		this.add(header);
		this.add(footer);

		ActionListener acc = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unsetfocus();

				try {

					footer.removeAll();
					if (e.getSource() == VUE) {

						VUE.focus();
						footer.add(Draw.drawArbreRougeNoir(arbreBinaire, "Arbre"));

					} else if (e.getSource() == INSERTION) {
						INSERTION.focus();
						footer.add(new Panel("Insertion"));

					} else if (e.getSource() == ROTATION) {
						ROTATION.focus();
						footer.add(new Panel("Rotation"));
					} else if (e.getSource() == SUPPRESSION) {
						footer.add(new Panel("Supression"));
						SUPPRESSION.focus();
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

	public static void unsetfocus() {
		VUE.setBackground(Color.white);
		INSERTION.setBackground(Color.white);
		ROTATION.setBackground(Color.white);
		SUPPRESSION.setBackground(Color.white);

		VUE.setForeground(Color.black);
		INSERTION.setForeground(Color.black);
		ROTATION.setForeground(Color.black);
		SUPPRESSION.setForeground(Color.black);

	}

}
