package Arbre;

public class Noeud {

	private int Cles;
	private Noeud FilsG;

	private Noeud FilsD;

	public Noeud(int item) {
		Cles = item;
		FilsD = null;
		FilsD = null;
	}

	public boolean IsFeuille() {
		return FilsD == null && FilsG == null;
	}

	public Noeud getFilsD() {
		return FilsD;
	}

	public void setFilsD(Noeud filsD) {
		FilsD = filsD;
	}

	public Noeud getFilsG() {
		return FilsG;
	}

	public void setFilsG(Noeud filsG) {
		FilsG = filsG;
	}

	public int getCles() {
		return Cles;
	}

	public void setCles(int cles) {
		Cles = cles;
	}

	public String toString() {
		return " " + Cles;
	}

}
