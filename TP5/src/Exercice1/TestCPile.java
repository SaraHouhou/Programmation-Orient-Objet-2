package Exercice1;

public class TestCPile {
	public static void main(String[] args) {
		// Pile de Strings :		
		IPile<String> pileS = new CPile<String>(); // IPile<String> est sous-type de CPile<String>
		// Depuis le JDK 7, on peut utiliser la notation du diamant :
		// IPile<String> pileS = new CPile<>();
		// Ci-dessus, le type String est infere de la declaration
		for(int i = 0 ; i < 10 ; i++) {
			pileS.empile(new Integer(i).toString());
		}
		pileS.depile();
		pileS.depile();
		System.out.println("La pile : "+pileS);
		System.out.println("Nombre d'elements dans la pile : "+pileS.nbElements());
		System.out.println("Sommet de pile : "+pileS.sommet());		
		
		System.out.println("--------------------");
		
		// Pile d'Integers :
		CPile<Integer> pileI = new CPile<Integer>();
		for(int i = 0 ; i < 10 ; i++) {
			pileI.empile(i*i); // Merci l'autoboxing : utiliser un int (i*i) a la place d'un objet Integer
		}
		pileI.depile();
		System.out.println("La pile : "+pileI);
		System.out.println("Nombre d'elements dans la pile : "+pileI.nbElements());
		System.out.println("Sommet de pile : "+pileI.sommet());
		
		// Pile de piles :
		IPile<CPile<Integer>> pileDePile = new CPile<CPile<Integer>>(); 
		// Notez ci-dessus : IPile<CPile<...>> au lieu de IPile<IPile<...>>
		// Il faut donc preciser le type exact : CPile<...> comme argument
		// Rappelez-vous : A<S> n'est pas sous type de A<T> meme si S est sous-type de T (les deux types generiques sont dissocies)
		pileDePile.empile(pileI);
		System.out.println("La pile au sommet : "+pileDePile.sommet());
		
	}
}

