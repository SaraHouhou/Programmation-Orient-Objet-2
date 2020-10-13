package Execice3;

import java.util.*;

public class FileAttente<A> { //prends type A generique
	protected ArrayList<A> contenu; 
	public FileAttente(){
		contenu=new ArrayList<A>();
	}
	
	public void entre(A a) {
		contenu.add(a);
	}
	
	public A sort() { 
		A a=null; 
		if (!contenu.isEmpty()) {
			a=contenu.get(contenu.size()-1);      
	        contenu.remove(contenu.size()-1);
	    } 
		return a; 
	} 
	
	public boolean estVide(){
		return contenu.isEmpty();
	} 
	public String toString(){
		return ""+contenu;
	}
}
