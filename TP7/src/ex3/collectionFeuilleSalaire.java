package ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class collectionFeuilleSalaire {
	
private ArrayList<FeuilleSalaire> listeFeuilles=new ArrayList<FeuilleSalaire>();

public void init(){
	FeuilleSalaire f1 = new FeuilleSalaire("IBM","Jean",200,2000.3);
	FeuilleSalaire f2 = new FeuilleSalaire("UM","Jenny",100,1000.3);
	FeuilleSalaire f3 = new FeuilleSalaire("CGI","Jeanne",201,2001.3);
	FeuilleSalaire f4 = new FeuilleSalaire("IoupLA","Jeannette",202,2001.3);
	listeFeuilles.add(f1);
	listeFeuilles.add(f2);
	listeFeuilles.add(f3);
	listeFeuilles.add(f4);
}

//question 1
public void printWithStream(){
	listeFeuilles.stream().forEach(f->System.out.println(f.toString()));

}

// question 2
public void printWithForEach(){
	listeFeuilles.forEach(f->System.out.println(f.toString()));
}



//Sort method: Il est utilisé pour trier les éléments présents dans la liste spécifiée de Collection dans l'ordre croissant.
// sort (list, comparteur) 
//compare les deux valeurs doubles spécifiées. Le signe de la valeur entière renvoyée est le même que celui de l'entier qui serait renvoyé par l'appel de fonction.

//question 3 _1 : trier listeFeuilles par ordre de nombre d’heures payées croissant : sans lambdas ni classes anonymes

public void tri_1(){
Collections.sort(listeFeuilles, new MonComparator());
}

// question 3 _1 : trier listeFeuilles par ordre de nombre d’heures payées croissant : sans lambdas et avec classes anonymes
public void triClasseAnonyme(){
	Collections.sort(listeFeuilles, new Comparator<FeuilleSalaire>(){  //comparator c'est une inerface fonctionel qui contiens une seule methode 
		public int compare(FeuilleSalaire f1, FeuilleSalaire f2){
		return Double.compare(f1.getNombreHeures(), f2.getNombreHeures());
		}	
	
	});
}

// on peut dire que les lamda sont juste un sucre syntaxique de la class anonyme, 


//question 3 _3: trier listeFeuilles par ordre de nombre d’heures payées croissant : avec lambdas et sans classes anonymes

public void tri(){
	Collections.sort(listeFeuilles, (elm1, elm2)  -> Double.compare(elm1.getNombreHeures(), elm2.getNombreHeures()) );
	// la notion lamda s'applique juste sur les interface foctionnel
	
}


// Question 4 : une méthode qui retourne les feuilles de salaire des salariés d’une l’entreprise donnée.
//Pour récupérer une liste à partir d’un stream, on utilisera : stream.collect(Collectors.toList());.

public List<FeuilleSalaire> feuillesByEntreprise(String entreprise){
	return listeFeuilles.stream()
						.filter(f->f.getEmployeur().equals(entreprise))
						.collect(Collectors.toList());
	
}


// Question 5: Ecrivez une méthode qui retourne la liste des entreprises des feuilles de salaire de listeFeuilles dont le nom contient par une chaˆıne de caract`ere donn´ee.

public List<String> entreprisesDeNom(String nom){
	return listeFeuilles.stream()
						.map(f->f.getEmployeur())
						.filter(s-> s.contains(nom))
						.collect(Collectors.toList());
}

public static void main (String[] args){
	collectionFeuilleSalaire t=new collectionFeuilleSalaire();
	t.init();
	System.out.println("--------print---------");

	t.printWithStream();
	System.out.println("------- Tri----------");

	t.tri();
	
	System.out.println("---------prit with for each--------");

	t.printWithForEach();
	
	System.out.println("---------recuperer les feilles de salaire by entreprise IBM--------");
 
	System.out.println(t.feuillesByEntreprise("IBM"));
	
	System.out.println("---------recuperer les feilles de salaire by entreprise chaine de caractere  --------");

	System.out.println(t.entreprisesDeNom("B"));
}

}

