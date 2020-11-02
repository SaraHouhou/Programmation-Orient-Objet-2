package Exercice4;

public class LivreJeunesse extends Livre implements DocumentJeunesse{
private int ageMin;


//constructeur
public LivreJeunesse(int i){
	ageMin=i;
}

// implement la method de l'interface
@Override
public int aPartirDe(){return ageMin;} 


}
