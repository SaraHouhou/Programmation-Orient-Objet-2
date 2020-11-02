package Exercice4;

import java.util.ArrayList;

public class Pochette <T extends Document> {
	
private ArrayList<T> contenu =new ArrayList<T>();
protected static String theme;

public void ajout(T t) throws DocumentNonAutorise{
	contenu.add(t);
}

public Pochette(String t){
	theme=t;
}

public String toString(){
	return "Pochette "+theme+" de taille "+contenu.size();
}

public int taille(){
	return contenu.size();
}
public void transfereVers(Pochette<? super T> cible) 
		throws DocumentNonAutorise{
	for (T c:contenu){
		cible.ajout(c);
	}
}


}