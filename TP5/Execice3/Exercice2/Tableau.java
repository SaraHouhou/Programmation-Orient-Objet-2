package Exercice2;

public class Tableau {

	private int T []; 
	
	public Tableau (int T []) {
		this.T = T;
	}
	
	public void triBulles () { 
		int i = T.length -2; 
		boolean ech = true; 
		while (i >= 0 && ech) { 
			ech = false; 
			for (int j = 0; j <= i; j ++) 
				if (T[j] > T[j+1]) { 
					int aux = T[j]; 
					T[j] = T[j+1]; 
					T[j+1] = aux; 
					ech = true;  
				} 
			i--; 
		} 
	} 
	
	public static <A extends Comparable<A>> void triBulles(A[] tab) {
		int i = tab.length -2; 
		boolean ech = true; 
		while (i >= 0 && ech) { 
			ech = false; 
			for (int j = 0; j <= i; j ++) 
				if (tab[j].compareTo(tab[j+1]) > 0) { 
					A aux = tab[j]; 
					tab[j] = tab[j+1]; 
					tab[j+1] = aux; 
					ech = true;  
				} 
			i--; 
		}
	}
	
	public void affiche () {
		for(int i = 0; i < T.length; i++) 
			System.out.print(T[i]+" "); 
		System.out.println(); 
	}
	
	public static void main(String[] args) { 
		System.out.println("-----------------");
		System.out.println("Tri d'un tableau d'int avec la methode normale :");
		int T[] = {10,2,6,11, 7, 2, -1, 0, 9}; 
		Tableau obj = new Tableau(T); 
		obj.triBulles(); 		
		obj.affiche();	
		
		
		System.out.println("-----------------");
		System.out.println("Tri d'un tableau de String avec la methode generique :");
		String T1[] = {"kiki","dodo","ami"};//,"z", "s", "l", "o", "s", "n"}; 
		Tableau.triBulles(T1);		
		for(String i : T1) {
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("Tri d'un tableau d'Integer avec la methode generique :");
		Integer T2[] = {10,2,6,11, 7, 2, -1, 0, 9};
		Tableau.triBulles(T2);
		for(Integer i : T2) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}	
}

