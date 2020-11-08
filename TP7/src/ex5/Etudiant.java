package ex5;

import ex4.ModaliteCandidature;

public class Etudiant {

	String nom;
	int age;
	ModaliteCandidature candidature;
	
	
	
	public String getNom() {
		return nom;
	}
	
	
	
	public int getAge() {
		return age;
	}
	
	
	
	public ModaliteCandidature getCandidature() {
		return candidature;
	}
	
	
	public Etudiant(String nom, int age) {
		this.nom=nom;
		this.age=age;
	}
	
	

	}
