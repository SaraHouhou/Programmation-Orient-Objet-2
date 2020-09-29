package exo1q3;

class Exc3 extends Exception { } 
class Exc31 extends Exc3 { } 
class Exc311 extends Exc31 { } 
class Exc32 extends Exc3 { } 
class Exc321 extends Exc32 { }

public class TestException { 
	public void f3() throws Exc3 { 
		System.out.println("debut f3"); 
		try { 
			f4(); 
		} 
		catch(Exc3 e) {System.out.println("je suis catch de f3 methode:"+e.getClass().getName());}
		finally {System.out.println("finally f3");} 
		System.out.println("suite f3"); 
	} 
	
	public void f4() throws Exc3 {
		System.out.println("debut f4");
		
		try {
			f5();
		}
		catch(Exc32 e){System.out.println("je suis catch de f4 methode avec exo32 exception pour f5: "+e.getClass().getName());} 
		//catch(Exc321 e){System.out.println("je suis catch de f4 methode avec 321 exception:  "+e.getClass().getName());} 		
		finally {System.out.println("finally f4");} 
		System.out.println("suite f4"); 
	} 
	
	public void f5() throws Exc3 {
		System.out.println("debut f5");
		Exc3 e = new Exc3() ; 
		throw e; 
	}
	public static void main(String[] args) throws Exc3 { 
	     TestException t = new TestException(); 
	    
			t.f3();
		
	      //Cas 1 : throw new Exc3();
	     // debut f3
	     // debut f4
	     // debut f5
	     // finally f4
		//je suis catch de f3 methode:exo1q3.Exc3

	     // finally f3
	     // traitement par défaut de l'exception par la JVM : 
	     // Exception in thread "main" Exc3 puis affichage de la pile des appels
	     
	     // Cas 2 : throw new Exc31();
	     // debut f3 -> debut f4 -> debut f5
	     // finally f4
	     // Exc31 (println du catch dans f3, suivi d'une exécution normale)
	     // finally f3
	     // suite f3
	     
	     // Cas 3 : throw new Exc311();
	     // debut f3 -> debut f4 -> debut f5
	     // finally f4
	     // Exc311 (println du catch dans f3 je suis catch de f3 methode:exo1q3.Exc311) 
		//-> (recherche à chaque fois d'un catch qui capture  l'exception même, sinon un de ses syper-types)
	     // finally f3
	     // suite f3
	     
	     // Cas 4 : throw new Exc32();
	     //debut f3
			//debut f4
			//debut f5
			//je suis catch de f4 methode avec exo32 exception pour f5: exo1q3.Exc32
			//finally f4
			//suite f4
			//finally f3
			//suite f3
	     
	     // Cas 5 : throw new Exc321();
	     // debut f3 -> debut f4 -> debut f5
	     // Exc321 (println du catch Exc321 dans f4) //je suis catch de f4 methode avec 321 exception:  exo1q3.Exc321
	     // -> C'est dans l'ordre que les catch sont interprétés (le premier correspondant à l'exception est exécuté)
	     // -> De plus, on ne peut pas inverser l'écriture des catch dans f4 (le catch du type d'exception le plus spécifique d'abord)
	     // -> Ce qui fait que la JVM choisit toujours le catch de type d'exception le plus spécifique
	     // finally f4
	     // suite f4
	     // finally f3
	     // suite f3
	} 
} 
