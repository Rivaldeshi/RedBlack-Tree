package Arbre;

public class ArbreRougeEtNoir extends ArbreBinaireDeRecheche {

    public ArbreRougeEtNoir() {
        super();
    }

    public ArbreRougeEtNoir(int cles) {
        super(cles);
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
        int i = 0;
        while (noeud.Parent != null && noeud.Parent.Color == 1) {
            i++;
            if (noeud.Parent == noeud.Parent.Parent.FilsD) {
                u = noeud.Parent.Parent.FilsG;
                if (u.Color == 1) {
                    u.Color = 0;
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    noeud = noeud.Parent.Parent;
                } else {
                    
                    if (noeud == noeud.Parent.FilsG) {
                        noeud = noeud.Parent;
                        RoationDroit(noeud);
                    }
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    RoationGauche(noeud.Parent.Parent);
                }

            } else {
                u = noeud.Parent.Parent.FilsD;
                if (u.Color == 1) {
                    u.Color = 0;
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    noeud = noeud.Parent.Parent;
                } else {
                    if (noeud == noeud.Parent.FilsD) {
                        noeud = noeud.Parent;
                        RoationGauche(noeud);
                    }
                    noeud.Parent.Color = 0;
                    noeud.Parent.Parent.Color = 1;
                    RoationDroit(noeud.Parent.Parent);
                }

            }
            if (noeud == Racine) {
                break;
            }
            System.out.println(i);
        }
        Racine.Color = 0;
    }
}
