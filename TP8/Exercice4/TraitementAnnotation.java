package Exercice4;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class TraitementAnnotation {
	
	/*
	 * de lister toutes les annotations Todo,
• de récupérer toutes les annotations correspondant à un certain type de tâche passé en paramètre
• de retourner la durée cumulée des tâches à réaliser lors d’une certaine version.
Exercic
	 */
	
	public  static void afficherTodos(Class[] classes) {
		for(Class c : classes) {
			Method[] methodes = c.getMethods();
			for(Method m : methodes) {
				if(m.isAnnotationPresent(Todo.class)) {
					System.out.println("- Méthode : "+m.getName()+"() de la classe : "
				+c.getName());
					Todo a = m.getAnnotation(Todo.class);
					System.out.println("\t- Todo : "+a.kind()+", version="+a.version()
					+", duration="+a.duration());
				}
			}
		}
	}
	
	

	// Question b.	
	private static void afficherTodosParTache(Class[] classes, Todo.TaskKind taskKind) {
		for(Class c : classes) {
			Method[] methodes = c.getMethods();
			for(Method m : methodes) {
				if(m.isAnnotationPresent(Todo.class)) {
					Todo a = m.getAnnotation(Todo.class);
					if(a.kind().equals(taskKind)) {
						System.out.println("- Méthode : "+m.getName()+"() de la classe : "+c.getName());					
						System.out.println("\t- Todo : "+a.kind()+", version="+a.version()+", duration="+a.duration());
					}
				}
			}
		}
	}
	
	//Question c.
	private static double dureeTotaleParVersion(Class[] classes, String version) {
		double duree = 0;
		for(Class c : classes) {
			Method[] methodes = c.getMethods();
			for(Method m : methodes) {
				if(m.isAnnotationPresent(Todo.class)) {
					Todo a = m.getAnnotation(Todo.class);
					if(a.version().equals(version)) {
						duree += a.duration();
					}
				}
			}
		}
		return duree;
	}
	
	public static void main(String[] args) {
		Class[] pokemons = {PersonnageInvisible.class,PersonnageBonus.class};
		// Question a.
		System.out.println("Question a : ");
		afficherTodos(pokemons);
		// Question b.
		System.out.println("Question b :");		
		afficherTodosParTache(pokemons,Todo.TaskKind.REFACTOR);		
		//Question c.
		System.out.println("Question c :");
		System.out.println("Durée totale : "+dureeTotaleParVersion(pokemons,"1.0.0"));
	}
}