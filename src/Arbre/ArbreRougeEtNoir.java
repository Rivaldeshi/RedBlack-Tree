package Arbre;

import java.util.List;

public class ArbreRougeEtNoir extends ArbreBinaireDeRecheche {

    public ArbreRougeEtNoir() {
        super();
    }

    public ArbreRougeEtNoir(int cles) {
        super(cles);
    }

    public ArbreRougeEtNoir(List<Integer> Cles) {
        super();
        Racine = null;
        for (Integer cle : Cles) {
            this.InserNoeud(cle);
        }
        actualiserListeDesNoeuds();
    }

    public void InserNoeud(int cles) {
        Noeud noeud = new Noeud(cles);
        this.InserNoeud(noeud);

        if (noeud.Parent == null) {
            noeud.Color = 0;
            return;
        }
        if (noeud.Parent.Parent == null) {
            return;
        }
        Reorganiser(noeud);
    }

    private void Reorganiser(Noeud noeud) {
        Noeud u;
        while (noeud.Parent != null && noeud.Parent.Color == 1) {

            if (noeud.Parent == noeud.Parent.Parent.FilsD) {
                u = noeud.Parent.Parent.FilsG;
                if (u != null && u.Color == 1) {
                    u.Color = 0;
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    noeud = noeud.Parent.Parent;
                } else {

                    if (noeud == noeud.Parent.FilsG) {
                        noeud = noeud.Parent;
                        RoationDroitDansArbre(noeud);
                    }
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    RoationGaucheDansArbre(noeud.Parent.Parent);
                }

            } else {
                u = noeud.Parent.Parent.FilsD;
                if (u != null && u.Color == 1) {
                    u.Color = 0;
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    noeud = noeud.Parent.Parent;
                } else {
                    if (noeud == noeud.Parent.FilsD) {
                        noeud = noeud.Parent;
                        RoationGaucheDansArbre(noeud);
                    }
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    RoationDroitDansArbre(noeud.Parent.Parent);
                }

            }
            if (noeud == Racine) {
                break;
            }
        }
        Racine.Color = 0;
    }

    public int HauteurNoirRecusive(Noeud noeud) {

        if (noeud == null) {
            return 1;
        }

        if (noeud.Color == 1) {
            return 0 + HauteurNoirRecusive(noeud.FilsD);

        } else {
            return 1 + HauteurNoirRecusive(noeud.FilsD);
        }

    }

    public int HauteurNoir() {
        return HauteurNoirRecusive(Racine);
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

}
