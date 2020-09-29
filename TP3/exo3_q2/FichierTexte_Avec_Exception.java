package exo3_q2;

import java.io.*;
import java.util.Scanner;

public class FichierTexte_Avec_Exception {

	File fichier;
	
	String contenu;

	private static Scanner s;
	
	public FichierTexte_Avec_Exception(File unFichier) throws FileNotFoundException {
		if(!unFichier.exists()) throw new FileNotFoundException(); 
		fichier = unFichier;
	}
	
	public FichierTexte_Avec_Exception(String cheminFichier) throws FileNotFoundException {
		fichier = new File(cheminFichier);
		if(!fichier.exists()) throw new FileNotFoundException(); 
	}
	
	public boolean existe() {
		return fichier.exists();
	}
	
	
	
	public int nbreLignes() throws FileNotFoundException, IOException {
		int nb = 0;
		BufferedReader lectureFichier = new BufferedReader( new FileReader (fichier.getAbsolutePath()));
		String s = lectureFichier.readLine(); 		 
		while (s!= null) { 
			nb++;
			s = lectureFichier.readLine(); 
		} 
		lectureFichier.close();		
		return nb;
	}
	
	public int nbreCaracteres() throws FileNotFoundException, IOException {
		int nb = 0;
		BufferedReader lectureFichier = new BufferedReader( new FileReader (fichier.getAbsolutePath()));
		String s = lectureFichier.readLine(); 		 
		while (s!= null) {
			String[] strs = s.split(" ");
			for(String str : strs) {
				nb += str.length();
			}			
			s = lectureFichier.readLine(); 
		} 
		lectureFichier.close();	
		return nb;
	}
	
	public void afficher() throws FileNotFoundException, IOException {
		BufferedReader lectureFichier = new BufferedReader( new FileReader (fichier.getAbsolutePath()));
		contenu = "";
		String s = lectureFichier.readLine(); 		 
		while (s!= null) { 			
			contenu += s+"\n";
			s = lectureFichier.readLine(); 
		} 
		lectureFichier.close();
		System.out.println(contenu);
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException{		
		s = new Scanner(System.in);
		System.out.print("Entrer le fichier à analyser : ");
		String cheminFichier = s.next();
				
		boolean ok = false;
		while(!ok) {
			if(cheminFichier.equals("EXIT")) {
				System.out.println("Arret de l'application");
				break;
			}
			try {
				FichierTexte_Avec_Exception ft = new FichierTexte_Avec_Exception(cheminFichier);
				ok = true;
				System.out.println("Nombre de lignes : "+ft.nbreLignes());
				System.out.println("Nombre de caracteres (sans espaces) : "+ft.nbreCaracteres());
				System.out.println("Contenu du fichier : ");
				ft.afficher();
			}
			catch(FileNotFoundException fnfe) {
				System.out.print("Fichier introuvable. Veuillez entrer un autre fichier :");
				cheminFichier = s.next();
			}
		}				
	}
}

///Users/shouhou/WorkspaceMaven/TD3/src/exo3_q2/essai

