package ex1;

import java.awt.Color;
import java.util.ArrayList;


public class feuxtricolores {
	
ArrayList<Color> couleurList;	
	
public feuxtricolores() {
	couleurList= new ArrayList<Color>();
}

public void add (Color c) {
	if (couleurList.size()<3) {
		couleurList.add(c);

	}else {
		System.out.println("vous avez déja remplit 3 couleures"); 
	}
}

public void  ToSring() {
	for (int i=0; i<couleurList.size(); i++) {
	System.out.println(couleurList.get(i).toString());
	}
}
}
