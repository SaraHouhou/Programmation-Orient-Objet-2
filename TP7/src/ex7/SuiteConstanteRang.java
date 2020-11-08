package ex7;

import java.util.ArrayList;
import java.util.Iterator;

public class SuiteConstanteRang implements Iterable<Double>{

	private ArrayList<Double> valeurs = new ArrayList<Double>();
	private double constante;
	
	public SuiteConstanteRang(ArrayList<Double> valeurs, double constante) {
		super();
		this.valeurs = valeurs;
		this.constante = constante;
	}
	
	public ArrayList<Double> getValeurs() {
		return valeurs;
	}

	public void setValeurs(ArrayList<Double> valeurs) {
		this.valeurs = valeurs;
	}

	public int getRang() {
		return this.valeurs.size();
	}

	public double getConstante() {
		return constante;
	}

	public void setConstante(double constante) {
		this.constante = constante;
	}

	@Override
	public Iterator<Double> iterator() {
		return new IterateurSuiteConstantePairs(this);
	}
	

	
	public Iterator<Double> iteratorImpairs() {
		return new IterateurSuiteConstanteImpairs(this);
	}
	
	public Double valeur(int n)
	{
		if (n < this.getRang())
		 	{double v=this.getValeurs().get(n); return v;}
		else return this.getConstante();
	}
	
	public static void main(String[] argv){
		ArrayList<Double> a = new ArrayList<Double>();
		a.add(1.0); 
		a.add(2.0); 
		a.add(3.0); 
		a.add(4.0); 
		a.add(5.0);
 		SuiteConstanteRang suite = new SuiteConstanteRang(a,8);
 		
 		System.out.println("------Iterator Pair------");
 		Iterator<Double> iteratorPaire = suite.iterator();

 		for (int i=0; i<14; i++)
			System.out.print("valeur:"+iteratorPaire.next()+"\n");
 		
 		
 		
 
 		System.out.println("-----iterator impair (indice + valeur)--------");
 		Iterator<Double> iteratorimPaire=suite.iteratorImpairs();
 		for (int i=0; i<14; i++)
 			System.out.print("Valeur:"+iteratorimPaire.next()+"\n");
 		
	}
	

}
