package Utils;

public class Broillon {
    
    //  public static ArbreBinaireDeRecheche ArbreCourant = new
	//  ArbreBinaireDeRecheche();;
	// public static ArbreRougeEtNoir ArbreCourant = new ArbreRougeEtNoir();


	// public static Menu menu = new Menu("hello");
    // public static Accueil accueil = new Accueil();

	// static {
	// 	// int[] elems = { 6, 8, 2, 0, 5, 7, 4, 9 };
	// 	//int[] elems = { 10, 7, 42, 5, 31, 64, 50, 83, 29, 23 };
	// 	// int[] elems = { 10, 5,12,2,8,6,9 };
	// 	int[] elems = { 4, 1, 4, 5, 8 };
	// 	//int[] elems = {10,9,8,7,6,5,4, 3,2, 1 };
	// 	for (int i = 0; i < elems.length; i++) {

	// 		ArbreCourant.InserNoeud(elems[i]);
	// 	}
	// 	// ArbreCourant.RoationGaucheDansArbre(3);
	// 	ArbreCourant.actualiserListeDesNoeuds();
	// 	ArbreCourant.printArbre();
	// }
    

	// public static AbreBinaireView arbreview = new AbreBinaireView(ArbreCourant);


    
    // Noeud RoationDroit(Noeud noeud) {

    //     if (noeud == null)
    //         return null;

    //     Noeud filsgauche = noeud.getFilsG();// 29
    //     if (filsgauche == null)
    //         return noeud;
    //     Noeud filsdroitDufilsgauche = filsgauche.getFilsD();
    //     filsgauche.setFilsD(noeud);
    //     noeud.setFilsG(filsdroitDufilsgauche);
    //     if (noeud.getParent() != null) {
    //         noeud.getParent().setFilsG(filsgauche);
    //         filsgauche.setParent(noeud.getParent());
    //     }
    //     noeud.setParent(filsgauche);
    //     return filsgauche;
    // }

    // public void RoationDroitDansArbre(int cles) {
    //     Noeud noeud = this.GetNoeud(cles);
    //     if (noeud == null) {
    //         return;
    //     }
        
    //     Noeud noeud1 = RoationDroit(noeud);
    //     if (noeud == Racine) {
    //         noeud1.setParent(null);
    //         noeud.setParent(Racine);
    //         Racine = noeud1;
    //     }
    // }

    // // public void RoationDroitDansArbre(Noeud noeud) {
    // // Noeud noeud1 = RoationDroit(noeud);
    // // if (noeud == Racine) {
    // // noeud1.setParent(null);
    // // noeud.setParent(Racine);
    // // Racine = noeud1;
    // // }
    // // }

    // Noeud RoationGauche(Noeud noeud) {

    //     if (noeud == null)
    //         return null;

    //     Noeud filsdroit = noeud.getFilsD();// 29
    //     if (filsdroit == null)
    //         return noeud;
    //     Noeud filsgaucheDufilsdroit = filsdroit.getFilsG();

    //     filsdroit.setFilsG(noeud);
    //     noeud.setFilsD(filsgaucheDufilsdroit);
    //     if (noeud.getParent() != null) {
    //         noeud.getParent().setFilsD(filsdroit);
    //         filsdroit.setParent(noeud.getParent());
    //     }
    //     noeud.setParent(filsdroit);
    //     return filsdroit;
    // }

    // public void RoationGaucheDansArbre(int cles) {
    //     Noeud noeud = this.GetNoeud(cles);
    //     if (noeud == null) {
    //         return;
    //     }
    //     Noeud noeud1 = RoationGauche(noeud);
    //     if (noeud == Racine) {
    //         noeud1.setParent(null);
    //         noeud.setParent(Racine);
    //         Racine = noeud1;
    //     }
    // }

}
