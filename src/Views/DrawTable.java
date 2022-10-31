package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Arbre.ArbreBinaire;
import SwingComponent.Panel;
import SwingComponent.Text;
import Utils.Constans;
import java.awt.FlowLayout;

public class DrawTable extends Panel {

    public static ArrayList<Text> mts = new ArrayList<>();
    Text[] tab;
    public int a;

    // int[] els1 = { 1, 9, 5, 8, 3, 2, 7, 11 };
    // int[] els1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int[] els1 = { 0, 7, 2, 5, 31, 64, 50, 83, 29, 23 };

    DrawTable(int a) {
        tab = new Text[a];
        this.a = a;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(Constans.framewidh, 50));
        Text l1 = new Text(0);
        
        l1.setText("Elems");

        l1.setFont(new Font("serif", Font.ITALIC, 20));
        l1.setForeground(Color.black);
        l1.setEditable(false);
        this.add(l1);
        for (int j = 0; j < a; j++) {
            Text cellule = new Text(0);
            if (j < els1.length)
                cellule.setText("" + els1[j]);
            this.add(cellule);
            tab[j] = cellule;
        }
    }

    DrawTable(List<Integer> elements, String name) {

        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(Constans.framewidh, 50));
        Text l1 = new Text(0);

        l1.setText(name);
        l1.setFont(new Font("serif", Font.ITALIC, 20));
        l1.setForeground(Color.white);
        l1.setBackground(Color.BLACK);
        l1.setEditable(false);
        l1.setPreferredSize(new Dimension(100, 40));

        this.add(l1);

        for (Integer elem : elements) {
            Text cell = new Text(0);
            cell.setEditable(false);
            cell.setText("" + elem);
            this.add(cell);
        }
    }

    public List<Integer> getElem() throws Exception {
        List<Integer> elems = new ArrayList<>();
        try {
            for (int i = 0; i < tab.length; i++) {
                elems.add(Integer.parseInt(tab[i].getText()));
            }
        } catch (Exception e) {
            throw e;
        }
        return elems;
    }

    public static Panel Draw(ArbreBinaire arbreBinaire) {

        Panel pan = new Panel();
        Object[][] data = Tableaux(arbreBinaire);

        String[] columnNames = new String[arbreBinaire.GetListeCleParcourLargeur().size() + 1];

        for (int i = 0; i < arbreBinaire.GetListeCleParcourLargeur().size() + 1; i++) {
            columnNames[i] = "";
        }

        JTable table = new JTable(data, columnNames);

        table.setTableHeader(null);

        table.setRowHeight(40);
        table.setSelectionBackground(Color.white);
        table.setSelectionForeground(Color.black);
        table.setEnabled(false);
        table.setFont(new Font("serif", Font.ITALIC, 20));

        table.setOpaque(false);
        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setBorder(null);
        sp.getViewport().setBackground(Color.white);
        pan.add(sp);
        pan.setBackground(Color.white);
        pan.setPreferredSize(new Dimension(Constans.framewidh, 200));

        return pan;
    }

    public static Object[][] Tableaux(ArbreBinaire arbreBinaire) {

        Object[][] data = new Object[4][arbreBinaire.GetListeCleParcourLargeur().size()+1];

        data[0][0] = "PREFIXE";
        data[1][0] = "INFIXE";
        data[2][0] = "POSTFIXE";
        data[3][0] = "LARGEUR";

        for (int i = 0; i < arbreBinaire.GetListeCleParcourLargeur().size(); i++) {
            data[0][i + 1] = arbreBinaire.GetParcourPrefix().get(i);
            data[1][i + 1] = arbreBinaire.GetParcourInfixe().get(i);
            data[2][i + 1] = arbreBinaire.GetParcourPostfix().get(i);
            data[3][i + 1] = arbreBinaire.GetListeCleParcourLargeur().get(i);
        }
        return data;
    }
}