package Arbre;

public class ArbreBinaireDeRecheche extends ArbreBinaire {

    public ArbreBinaireDeRecheche() {
        super();
    }

    public ArbreBinaireDeRecheche(int cles) {
        super(cles);
    }

    public void InserNoeud(Noeud noeud) {
        this.setRacine(InsertionRecursive(this.getRacine(), noeud));
        this.getNoeuds().add(noeud);
    }

    public void InserNoeud(int cles) {
        this.InserNoeud(new Noeud(cles));
    }

    public static Noeud InsertionRecursive(Noeud racine, Noeud noeud) {
        if (racine == null) {
            racine = noeud;
            return racine;
        }

        if (noeud.getCles() < racine.getCles())
            racine.setFilsG(InsertionRecursive(racine.getFilsG(), noeud));

        else if (noeud.getCles() >= racine.getCles())
            racine.setFilsD(InsertionRecursive(racine.getFilsD(), noeud));

        return racine;
    }

    public void SupressionNoeud(int cles) {
        Racine = SuppressionRecursive(Racine, cles);
        for (Noeud noeud : Noeuds) {
            if (noeud.getCles() == cles) {
                Noeuds.remove(noeud);
                break;
            }
        }
    }

    Noeud SuppressionRecursive(Noeud racine, int cles) {

        if (racine == null)
            return racine;

        if (cles < racine.getCles())
            racine.setFilsG(SuppressionRecursive(racine.getFilsG(), cles));
        else if (cles > racine.getCles())
            racine.setFilsD(SuppressionRecursive(racine.getFilsD(), cles));
        else {

            if (racine.getFilsG() == null)
                return racine.getFilsD();
            else if (racine.getFilsD() == null)
                return racine.getFilsD();

            racine.setCles(ValeurMin(racine.getFilsD()));
            racine.setFilsD(SuppressionRecursive(racine.getFilsD(), racine.getCles()));
        }
        return racine;
    }

    int ValeurMin(Noeud racine) {
        int minval = racine.getCles();

        while (racine.getFilsG() != null) {
            minval = racine.getFilsG().getCles();
            racine = racine.getFilsG();
        }
        return minval;
    }

}
