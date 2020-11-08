package ex7;

import java.util.Iterator;

public class IterateurObjet implements Iterator<Object> {

	private Object f;
	private int curseur=0;
	
	IterateurObjet(Object f){this.f=f;}
	
	@Override
	public boolean hasNext() {
		return curseur <  f.getClass().getFields().length;
	}

	@Override
	public Object next() {
		System.out.println(f.getClass().getDeclaredFields().length);
		
		Object valeurAttrCourant = null;
		try {
			f.getClass().getDeclaredFields()[curseur].setAccessible(true);
			System.out.println(f.getClass().getDeclaredFields()[curseur].isAccessible());
			valeurAttrCourant = f.getClass().getDeclaredFields()[curseur].get(f);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		curseur += 1;
		return valeurAttrCourant;
        }

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] argvs)
	{
		/*FeuilleSalaire f1 = new FeuilleSalaire("s1","s2", 1 ,1.0);
		for (Object v : f1)
			System.out.println(v);*/
		
		//BonbonPez bonbon = new BonbonPez();
		//for (Object v : bonbon)
		//{
			//System.out.println(v);
		//}
	}
}