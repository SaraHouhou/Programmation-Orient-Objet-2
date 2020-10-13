package Execice3;

import java.util.*;

public class FileAttenteAvecPriorite<A extends ElementAvecPriorite> extends FileAttente<A> {

	public FileAttenteAvecPriorite(){
		contenu=new ArrayList<A>();
	}
	
	public A sort() { 
		A a=null; 
		if (!contenu.isEmpty()) {
			a=lePlusPrioritaire();
	        contenu.remove(a);
	    } 
		return a; 
	} 
	
	private A lePlusPrioritaire() {
		A a = null;
		int priorite = Integer.MAX_VALUE;
		for(A e : contenu) {
			if(e.priorite() < priorite) {
				priorite = e.priorite();
				a = e;
				System.out.print(a.toString()+"\n");
			}
		}
		return a;
	}
	
}
