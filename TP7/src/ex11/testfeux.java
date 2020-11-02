package ex11;

import java.awt.Color;
import java.util.Iterator;

public class testfeux {

	
	public static void main(String[] arg)
	{
		FeuTricolore f = new FeuTricolore();
		Iterator<Color> ite = f.iterator();
		
		for (int step = 0; step < 12; step++)
			{
				System.out.println(ite.next());
			}
	}
}
