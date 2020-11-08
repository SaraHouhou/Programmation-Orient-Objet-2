package ex6;

import java.util.ArrayList;
import java.util.Iterator;

public class SuiteConstanteRang implements Iterable<Double>{

	private ArrayList<Double> suitEntier = new ArrayList<Double>();
	private double constante;
	
	public SuiteConstanteRang(ArrayList<Double> suitEntier, double constante) {
		super();
		this.suitEntier = suitEntier;
		this.constante = constante;
	}
	
	public ArrayList<Double> getsuitEntier() {
		return suitEntier;
	}

	public void setValeurs(ArrayList<Double> suitEntier) {
		this.suitEntier = suitEntier;
	}

	public int getRang() {
		return this.suitEntier.size();
	}

	public double getConstante() {
		return constante;
	}

	public void setConstante(double constante) {
		this.constante = constante;
	}

	@Override
	public Iterator<Double> iterator() {
		return new IterateurSuiteConstante(this);
	}
	
	public Double valeur(int n)
	{
		if (n < this.getRang()) {
			double v=this.getsuitEntier().get(n); 
			return v;
			}
		else return this.getConstante();
	}
	
	public static void main(String[] argv){
		ArrayList<Double> a = new ArrayList<Double>();
		a.add(3.0);
		a.add(4.0); 
		a.add(5.0); 
		a.add(6.0); 
		a.add(7.0);
 		SuiteConstanteRang suite = new SuiteConstanteRang(a,8);
 		Iterator<Double> it = suite.iterator();
 		
 		for (int i=0; i<14; i++)
 			System.out.println(it.next());
 		
 			System.out.println("-------------------");
 		
 		for (double e : suite)
 		{
 			System.out.println(e);
 		}
	}
}