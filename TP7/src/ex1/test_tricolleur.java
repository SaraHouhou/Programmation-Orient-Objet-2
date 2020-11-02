package ex1;
import java.awt.Color;

public class test_tricolleur {
	
	public static void main(String []args) {
	feuxtricolores feuxcolor = new feuxtricolores();
	feuxcolor.add(Color.red);
	feuxcolor.add(Color.green);
	feuxcolor.add(Color.orange);
	//feuxcolor.ToSring();
	iterateurTriColeur iterateurTriColeur = new iterateurTriColeur(feuxcolor);
	while(iterateurTriColeur.hasNext()) {
		System.out.println(iterateurTriColeur.next());
	}
	
	iterateurTriColeur.remove();
 
	}
}
