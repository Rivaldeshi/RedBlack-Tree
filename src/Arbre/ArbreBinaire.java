package Arbre;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ArbreBinaire extends Noeud {

    protected Noeud Racine;
    protected List<Noeud> Noeuds = new ArrayList<>();

    public ArbreBinaire(int cles) {
        super(cles);
        Racine = this;
        Noeuds.add(this);
    }

    public ArbreBinaire() {
        super();
        Racine = null;
    }

    public Noeud GetNoeud(int cles) {

        for (Noeud noeud : Noeuds) {
            if (noeud.getCles() == cles)
                return noeud;
        }
        return null;
    }

    public Noeud getRacine() {
        return Racine;
    }

    public void setRacine(Noeud racine) {
        Racine = racine;
    }

    public List<Noeud> getNoeuds() {
        return Noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> noueds) {
        Noeuds = noueds;
    }

    public boolean IsFeuille() {
        return this.Racine.IsFeuille();
    }

    public void ParcourInfixe(Noeud node, ArrayList<Noeud> noeuds) {
        if (node != null) {
            ParcourInfixe(node.getFilsG(), noeuds);
            noeuds.add(node);
            ParcourInfixe(node.getFilsD(), noeuds);
        }
    }

    public void ParcourPrefix(Noeud node, ArrayList<Noeud> noeuds) {
        if (node != null) {
            noeuds.add(node);
            ParcourPrefix(node.getFilsG(), noeuds);

            ParcourPrefix(node.getFilsD(), noeuds);
        }
    }

    public List<Noeud> ParcourLargeur() {
        List<Noeud> noeuds = new ArrayList<>();

        Queue<Noeud> file = new ArrayDeque<Noeud>();
        file.add(this.Racine);
        while (!file.isEmpty()) {
            Noeud noeud = file.remove();
            noeuds.add(noeud);
            if (noeud.getFilsG() != null)
                file.add(noeud.getFilsG());
            if (noeud.getFilsD() != null)
                file.add(noeud.getFilsD());
        }
        return noeuds;
    }

    public List<Integer> GetListeCleParcourLargeur() {
        List<Integer> cles = new ArrayList<>();
        List<Noeud> noeuds = ParcourLargeur();
        for (Noeud noeud : noeuds) {
            cles.add(noeud.Cles);
        }
        return cles;
    }

    public void actualiserListeDesNoeuds() {
        Noeuds = ParcourLargeur();
    }

    public void printArbre() {

        Racine.printNoeud();
        for (Noeud noeud : this.getNoeuds()) {
            noeud.printNoeud();
        }
        System.out.println("\n\n\n");
    }

}