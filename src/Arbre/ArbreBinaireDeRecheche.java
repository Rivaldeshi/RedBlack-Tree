package Arbre;

import java.util.List;

public class ArbreBinaireDeRecheche extends ArbreBinaire {

    public ArbreBinaireDeRecheche() {
        super();
    }

    public ArbreBinaireDeRecheche(int cles) {
        super(cles);
    }

    public ArbreBinaireDeRecheche(Noeud noeud) {
        Racine = noeud;
        actualiserListeDesNoeuds();
    }

    public ArbreBinaireDeRecheche(List<Integer> Cles) {
        super();
        Racine = null;
        for (Integer cle : Cles) {
            this.InserNoeud(cle);
        }
        actualiserListeDesNoeuds();
    }

    public void InserNoeud(Noeud noeud) {
        this.setRacine(InsertionRecursive(this.getRacine(), noeud));

        if (this.Racine.getFilsD() != null)
            this.Racine.getFilsD().setParent(Racine);
        if (this.Racine.getFilsG() != null)
            this.Racine.getFilsG().setParent(Racine);
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

        if (noeud.getCles() < racine.getCles()) {
            if (racine.getFilsG() != null) {
                noeud.setParent(racine.getFilsG());
            }
            racine.setFilsG(InsertionRecursive(racine.getFilsG(), noeud));
        } else if (noeud.getCles() >= racine.getCles()) {
            if (racine.getFilsD() != null) {
                noeud.setParent(racine.getFilsD());
            }

            racine.setFilsD(InsertionRecursive(racine.getFilsD(), noeud));
        }

        return racine;
    }

    public void SupressionNoeud(int cle) {
        List<Integer> cles = GetListeCleParcourLargeur();
        cles.remove(Integer.valueOf(cle));
        Racine = null;
        for (Integer cl : cles) {
            this.InserNoeud(cl);
        }
        actualiserListeDesNoeuds();
    }
    // public void SupressionNoeud(int cles) {
    // Racine = SuppressionRecursive(Racine, cles);
    // for (Noeud noeud : Noeuds) {
    // if (noeud.getCles() == cles) {
    // Noeuds.remove(noeud);
    // break;
    // }
    // }
    // }

    public static Noeud SuppressionRecursive(Noeud racine, int cles) {

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

    public static int ValeurMin(Noeud racine) {
        int minval = racine.getCles();

        while (racine.getFilsG() != null) {
            minval = racine.getFilsG().getCles();
            racine = racine.getFilsG();
        }
        return minval;
    }

    public void RoationGaucheDansArbre(int cles) {
        Noeud noeud = this.GetNoeud(cles);
        if (noeud == null) {
            return;
        }
        RoationGaucheDansArbre(noeud);
    }

    public void RoationGaucheDansArbre(Noeud x) {
        Noeud y = x.FilsD;

        if (y == null)
            return;

        x.FilsD = y.FilsG;
        if (y.FilsG != null) {
            y.FilsG.Parent = x;
        }
        y.Parent = x.Parent;
        if (x.Parent == null) {
            this.Racine = y;
        } else if (x == x.Parent.FilsG) {
            x.Parent.FilsG = y;
        } else {
            x.Parent.FilsD = y;
        }
        y.FilsG = x;
        x.Parent = y;
    }

    public void RoationDroitDansArbre(Noeud x) {
        Noeud y = x.FilsG;

        if (y == null)
            return;
        x.FilsG = y.FilsD;

        if (y.FilsD != null) {
            y.FilsD.Parent = x;
        }
        y.Parent = x.Parent;
        if (x.Parent == null) {
            this.Racine = y;
        } else if (x == x.Parent.FilsD) {
            x.Parent.FilsD = y;
        } else {
            x.Parent.FilsG = y;
        }
        y.FilsD = x;
        x.Parent = y;
    }

    public void RoationDroitDansArbre(int cles) {
        Noeud noeud = this.GetNoeud(cles);
        if (noeud == null) {
            return;
        }
        RoationDroitDansArbre(noeud);
    }

}
