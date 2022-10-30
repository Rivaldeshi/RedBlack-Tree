package Arbre;

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

    public void SupressionNoeud(int cles) {
        Racine = SuppressionRecursive(Racine, cles);
        for (Noeud noeud : Noeuds) {
            if (noeud.getCles() == cles) {
                Noeuds.remove(noeud);
                break;
            }
        }
    }

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

    Noeud RoationDroit(Noeud noeud) {

        if (noeud == null)
            return null;

        Noeud filsgauche = noeud.getFilsG();// 29
        if (filsgauche == null)
            return noeud;
        Noeud filsdroitDufilsgauche = filsgauche.getFilsD();
        filsgauche.setFilsD(noeud);
        noeud.setFilsG(filsdroitDufilsgauche);
        if (noeud.getParent() != null) {
            noeud.getParent().setFilsG(filsgauche);
            filsgauche.setParent(noeud.getParent());
        }
        noeud.setParent(filsgauche);
        return filsgauche;
    }

    public void RoationDroitDansArbre(int cles) {
        Noeud noeud = this.GetNoeud(cles);
        if (noeud == null) {
            return;
        }
        Noeud noeud1 = RoationDroit(noeud);
        if (noeud == Racine) {
            noeud1.setParent(null);
            noeud.setParent(Racine);
            Racine = noeud1;
        }
    }

    public void RoationDroitDansArbre(Noeud noeud) {
        Noeud noeud1 = RoationDroit(noeud);
        if (noeud == Racine) {
            noeud1.setParent(null);
            noeud.setParent(Racine);
            Racine = noeud1;
        }
    }

    Noeud RoationGauche(Noeud noeud) {

        if (noeud == null)
            return null;

        Noeud filsdroit = noeud.getFilsD();// 29
        if (filsdroit == null)
            return noeud;
        Noeud filsgaucheDufilsdroit = filsdroit.getFilsG();

        filsdroit.setFilsG(noeud);
        noeud.setFilsD(filsgaucheDufilsdroit);
        if (noeud.getParent() != null) {
            noeud.getParent().setFilsG(filsdroit);
            filsdroit.setParent(noeud.getParent());
        }
        noeud.setParent(filsdroit);
        return filsdroit;
    }

    public void RoationGaucheDansArbre(int cles) {
        Noeud noeud = this.GetNoeud(cles);
        if (noeud == null) {
            return;
        }
        Noeud noeud1 = RoationGauche(noeud);
        if (noeud == Racine) {
            noeud1.setParent(null);
            noeud.setParent(Racine);
            Racine = noeud1;
        }
    }

    public void RoationGaucheDansArbre(Noeud noeud) {
        Noeud noeud1 = RoationGauche(noeud);
        if (noeud == Racine) {
            noeud1.setParent(null);
            noeud.setParent(Racine);
            Racine = noeud1;
        }
    }

}
