package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import SwingComponent.Panel;
import SwingComponent.Text;
import Utils.Constans;
import java.awt.FlowLayout;

public class DrawTable extends Panel {

    public static ArrayList<Text> mts = new ArrayList<>();
    Text[] tab;
    public int a;

    //int[] els1 = { 1, 9, 5, 8, 3, 2, 7, 11 };
   // int[] els1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int[] els1 = { 10, 7, 42, 5, 31, 64, 50, 83, 29, 23 };

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
}