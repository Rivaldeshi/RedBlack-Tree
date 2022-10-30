package Arbre;

public class Noeud {

	protected int Cles;
	protected Noeud FilsG;
	protected Noeud FilsD;
	protected Noeud Parent;

	protected int Color;

	public Noeud(int item) {
		Cles = item;
		FilsD = null;
		FilsD = null;
		Parent = null;
		Color = 1;
	}

	public Noeud() {

	}

	public boolean IsFeuille() {
		return FilsD == null && FilsG == null;
	}

	public void Copy(Noeud noeud) {
		this.Cles = noeud.getCles();
		this.FilsD = noeud.getFilsD();
		this.FilsG = noeud.getFilsG();
		this.Parent = noeud.getParent();
	}

	public Noeud getFilsD() {
		return FilsD;
	}

	public void setFilsD(Noeud filsD) {
		FilsD = filsD;
	}

	public int getColor() {
		return Color;
	}

	public void setColor(int color) {
		Color = color;
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

	public Noeud getParent() {
		return Parent;
	}

	public void setParent(Noeud parent) {
		Parent = parent;
	}

	public void printNoeud() {
		System.out.println("  { Moi : " + this + " , filsG : " + this.FilsG + " ,  filsD : " + this.FilsD
				+ "  ,  Pere : " + this.Parent + " }  ");
	}
}
