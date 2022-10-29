package Arbre;

import java.util.ArrayList;

public class ArbreBinaire {

    protected Noeud Racine;
    protected ArrayList<Noeud> Noeuds = new ArrayList<>();

    public ArbreBinaire(int cles) {
        Noeud noeud = new Noeud(cles);
        Racine = noeud;
        Noeuds.add(noeud);
    }

    public ArbreBinaire() {
        Racine = null;
    }

    public Noeud getRacine() {
        return Racine;
    }

    public void setRacine(Noeud racine) {
        Racine = racine;
    }

    public ArrayList<Noeud> getNoeuds() {
        return Noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> noueds) {
        Noeuds = noueds;
    }

    public boolean IsFeuille() {
        return this.Racine.IsFeuille();
    }

}