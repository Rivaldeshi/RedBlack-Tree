package DrawAutomate;

import SwingComponent.Panel;
import Utils.ValidationException;
import Views.MainView;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxPerimeter;
import com.mxgraph.view.mxStylesheet;

import Arbre.ArbreBinaire;
import Arbre.Noeud;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.util.mxConstants;

public class Draw {

	public static final mxStylesheet STYLE = new mxStylesheet();

	static {
		HashMap<String, Object> style = new HashMap<String, Object>();
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_FONTCOLOR, "#000000");
		style.put(mxConstants.STYLE_PERIMETER, mxPerimeter.EllipsePerimeter);
		style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
		style.put(mxConstants.STYLE_FILLCOLOR, "#FFFFFF");
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		STYLE.putCellStyle("RIEN", style);

		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_FONTCOLOR, "#FFFFFF");
		style.put(mxConstants.STYLE_PERIMETER, mxPerimeter.EllipsePerimeter);
		style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
		style.put(mxConstants.STYLE_FILLCOLOR, "#f70b0b");
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		STYLE.putCellStyle("ROUGE", style);

		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_FONTCOLOR, "#FFFFFF");
		style.put(mxConstants.STYLE_PERIMETER, mxPerimeter.EllipsePerimeter);
		style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
		style.put(mxConstants.STYLE_FILLCOLOR, "#000000");
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		STYLE.putCellStyle("NOIR", style);

		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
		style.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
		style.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_LEFT);
		style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
		style.put(mxConstants.STYLE_STROKECOLOR, "black");
		style.put(mxConstants.STYLE_OPACITY, 80);
		STYLE.setDefaultEdgeStyle(style);

	}

	public static Panel drawArbre(ArbreBinaire abreBinaire, String nom, Boolean isRougeNoire)
			throws ValidationException {

		// Creates graph with model
		mxGraph graph = new mxGraph();

		graph.setStylesheet(STYLE);
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try {

			ArrayList<Object> vertexs = new ArrayList<Object>();

			for (Noeud noeud : abreBinaire.getNoeuds()) {
				Object v1;
				if (isRougeNoire) {
					if (noeud.getColor() == 1) {
						v1 = graph.insertVertex(parent, null, noeud, 0, 0, 60, 60, "ROUGE");
					} else {
						v1 = graph.insertVertex(parent, null, noeud, 0, 0, 60, 60, "NOIR");
					}
				} else {
					v1 = graph.insertVertex(parent, null, noeud, 0, 0, 60, 60, "RIEN");
				}
				vertexs.add(v1);
			}

			for (Noeud noeud : abreBinaire.getNoeuds()) {

				if (noeud.getFilsG() != null) {
					graph.insertEdge(parent, null, "", vertexs.get(abreBinaire.getNoeuds().indexOf(noeud)),
							vertexs.get(abreBinaire.getNoeuds().indexOf(noeud.getFilsG())));
				} else {
					if (!noeud.IsFeuille()) {
						Object v1;
						v1 = graph.insertVertex(parent, null, "null", 0, 0, 60, 60, "RIEN");
						graph.insertEdge(parent, null, "", vertexs.get(abreBinaire.getNoeuds().indexOf(noeud)),
								v1);
					}
				}

				if (noeud.getFilsD() != null) {
					graph.insertEdge(parent, null, "", vertexs.get(abreBinaire.getNoeuds().indexOf(noeud)),
							vertexs.get(abreBinaire.getNoeuds().indexOf(noeud.getFilsD())));
				} else {
					if (!noeud.IsFeuille()) {
						Object v1;
						v1 = graph.insertVertex(parent, null, "null", 0, 0, 60, 60, "RIEN");
						graph.insertEdge(parent, null, "", vertexs.get(abreBinaire.getNoeuds().indexOf(noeud)),
								v1);
					}
				}

			}

		} finally {
			graph.getModel().endUpdate();
		}

		Panel pan = nom.equals("") ? new Panel() : new Panel(nom);

		// mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
		mxCompactTreeLayout layout = new mxCompactTreeLayout(graph, false);

		layout.setUseBoundingBox(false);
		layout.setEdgeRouting(false);
		layout.setLevelDistance(30);
		layout.setNodeDistance(10);
		layout.execute(parent);

		mxGraphComponent graphComponent = new mxGraphComponent(graph);

		graphComponent.getViewport().setOpaque(true);

		graphComponent.getViewport().setBackground(Color.WHITE);
		graphComponent.setBorder(BorderFactory.createEmptyBorder());
		graphComponent.setEnabled(false);

		Panel graphPan = new Panel();
		if (MainView.TableauxCourant.size() < 6) {
			graphPan.setLayout(new GridBagLayout());
		}
		graphPan.add(graphComponent, new GridBagConstraints());
		pan.setBackground(Color.white);
		graphPan.setBackground(Color.white);
		pan.add(graphPan);

		return pan;
	}
}