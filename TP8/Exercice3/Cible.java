package Exercice3;

public class Cible {

	private String nom;
	private int nbPoints;
	private int nbVies;
	private int other;

	
	public Cible() {
	
	}

	public Cible(String nom, int nbPoints, int nbVies, int other) {
		this.nom = nom;
		this.nbPoints = nbPoints;
		this.nbVies = nbVies;
		this.other=other;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getNbVies() {
		return nbVies;
	}

	public void setNbVies(int nbVies) {
		this.nbVies = nbVies;
	}
	
	public int getother() {
		return other;
	}

	public void setother(int other) {
		this.other = other;
	}
	
}
