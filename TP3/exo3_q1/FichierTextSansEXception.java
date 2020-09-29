package exo3_q1;

import java.io.*;
import java.util.Scanner;

public class FichierTextSansEXception {

	File fichier;
	
	String contenu;
	
	//constructeur avec le fichier qui est supposer existé
	public FichierTextSansEXception(File unFichier) {
		if(!unFichier.exists()); 
		fichier = unFichier;
	}
	
	public FichierTextSansEXception(String cheminFichier){
		fichier = new File(cheminFichier);
		if(!fichier.exists()); 
	}
	
	//supposer fichier existe
	public boolean existe() {
		return fichier.exists();
	}
	
	
	//afficher le nombre de ligne
	public int nbreLignes()  throws IOException{
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
	//afficher le nombre de caractére
	
	public int nbreCaracteres() throws IOException {
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
	
	public void afficher() throws IOException {
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
	
	
	public static void main(String[] args) throws IOException{	
		
		System.out.println("------------Question 5_1 Application@--------");
		Scanner s = new Scanner(System.in);
		System.out.print("Entrer le fichier à analyser : ");
		String cheminFichier = s.next();
		
		FichierTextSansEXception ft = new FichierTextSansEXception(cheminFichier);		
		System.out.println("Nombre de lignes : "+ft.nbreLignes());
		System.out.println("Nombre de caractères (sans espaces) : "+ft.nbreCaracteres());
		System.out.println("Contenu du fichier : ");
		ft.afficher();
	}
}

// /Users/shouhou/WorkspaceMaven/TD3/src/exo3_q1/essai
