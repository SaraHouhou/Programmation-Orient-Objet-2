package cercleSportif;

import java.util.ArrayList;

public enum Lieu {
	stade1("stade de foot"),
	piscine2("piscine du centre");

	private String nom;
	private ArrayList<Creneau> creneauxDisponibles=new ArrayList<Creneau>();

	private Lieu(String nom){
		this.nom=nom;
	}

	public void ajoutCrenau(Creneau c){
		creneauxDisponibles.add(c);
	}
	
	public boolean estDisponiblePendant(Creneau c){
		boolean result=false;
		for (Creneau cr:creneauxDisponibles){
			if (c.estInclusDans(cr)) return true;
		}
		return result;
	}
	public String toString(){
		return nom;
	}
}
