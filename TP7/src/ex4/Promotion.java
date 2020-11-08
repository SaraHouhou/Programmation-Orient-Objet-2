package ex4;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Promotion {

	private ArrayList<Etudiant> etudiants=new ArrayList<Etudiant>();
	
	
	//question 1 (Version 1): une méthode qui retourne l’âge minimum des étudiants de la promotion recrutés via eCandida
	
	public int ageMineCandidats(){
		return etudiants.stream()
				.filter(e->e.getCandidature()==ModaliteCandidature.eCandidat)
				.mapToInt(e->e.getAge()) // return a new stream but integer
				.min().getAsInt();
	}	
		
	//question 1 (Version 2): une méthode qui retourne l’âge minimum des étudiants de la promotion recrutés via eCandida

	public int ageMineCandidatsBis(){
		return etudiants.stream()
			   .filter(e->e.getCandidature()==ModaliteCandidature.eCandidat)
			   .min((e1, e2)->e1.getAge()-e2.getAge()) // étudiant d'âge minimum sous forme d'un Optional<Etudiant>, min prend en argument un comparator et elle rend stream avec type optionnel etudiant  
			   .get() // l'étudiant d'âge minimum ou levée d'exception
			   .getAge(); // l'âge de l'étudiant d'âge minimum
	}
	
	// question 2: nombre d'étudiants recrutés via la modalité m
			public int nbEtudiantsRecrutesVia(ModaliteCandidature m){
				return (int)etudiants.stream()
									 .filter(e->e.getCandidature()==m)
									 .count();
			}
			
			// implem avec un boucle for
						public int nbrEtudiantsRecrutesVia(ModaliteCandidature m){
							int x=0;
							for (Etudiant e:etudiants){
								if (e.getCandidature()==m){  
									x++;
								}	
							}
							return x;
								}
			
			
		
		
	// question 3: une méthode qui retourne la liste des étudiants d’age maximal.
			
			
			// implem avec un boucle for
			public List<Etudiant> etudiantsLesPlusAgesBis(){
				ArrayList<Etudiant> etudiantsTmp=new ArrayList<>();
				int max=0;
				for (Etudiant e:etudiants){
					if (e.getAge()>max){
						etudiantsTmp.clear();
						etudiantsTmp.add(e);
						max=e.getAge();
					} else if (e.getAge()==max)
					{
						etudiantsTmp.add(e);
					}
				}
				return etudiantsTmp;
			} 
			
			// implem avec un lamda structure
		public List<Etudiant> etudiantsAgeMax(){
			int ageMax=etudiants.stream()
								.mapToInt(e->e.getAge())
								.max()
								.getAsInt();
			return etudiants.stream()
							.filter(e->e.getAge()==ageMax)
							.collect(Collectors.toList()); // accumuler l'age max dans une list
		}
		
		
		
		
		
		
		// liste des étudiants dont le nom commence par une chaîne donnée, triée par ordre alphatique sur le nom
		public List<Etudiant> etudiantsDontLeNomCommencePar(String prefixe){
			return etudiants.stream()
							.filter(e->e.getNom().startsWith(prefixe))
							.sorted((e1, e2)->e1.getNom().compareTo(e2.getNom()))
							.collect(Collectors.toList());
	
		}
}

