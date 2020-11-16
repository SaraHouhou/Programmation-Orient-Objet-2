package Exercice1;


import java.util.*;
import java.io.File;
import java.lang.reflect.*;

import javax.swing.*;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class ArrayListMystere {

	 ArrayList list;
	
	public ArrayListMystere(){
		list = new ArrayList();
		list.add(new Integer(10));
		list.add(new Double(19.5));
	}
// question 1: une methode retournant pour un indice i les methodes dont vous disposez sur l'objet de rang i.
	private  List<Method> getMethods(int i) {
		Object o = list.get(i);
		List<Method> listemethodes;
		Method[] methodes = o.getClass().getMethods();
		listemethodes=Arrays.asList(methodes);
		System.out.println("Class Name : "+o.getClass().getName());
		System.out.println("Methods : ");
		for(Method m : methodes) {
			String m_name = m.getName(); 
			Class m_returnType = m.getReturnType();  
			System.out.print(" return type of the method is: "+m_returnType.getName()+", the name of the method is "+m_name ); 
			Class[] m_paramTypes = m.getParameterTypes();			
			for (int j=0; j<m_paramTypes.length; j++) 
				System.out.print(" ,has as arguments: "+ "("+ m_paramTypes[j].getName());
			System.out.print(")");
			System.out.println(", defined in : "+m.getDeclaringClass().getName());
		}				
		return listemethodes;
	}
	
	
	// question 2: une methode retournant la classe la plus specifique que dont tous les objets de l'ArrayList soninstances.

	

	
	
	// solution 2
	public static ArrayList<Class> getAllSupertypes(Class c){
		ArrayList<Class> result=new ArrayList<Class>();
		Class superclass=c.getSuperclass();
		result.add(superclass);

		if (!superclass.getName().equals("java.lang.Object")){
			getAllSupertypes(superclass);
		}
		return result;
	}
	
	private  Class getSpecificCommonClass() {
		ArrayList<ArrayList<Class>> AllSupertypes = getAllSuperClassesForAllObjects();
		Class cl=AllSupertypes.get(0).get(0); // on initialise la class de retour 
		ArrayList<Class> first = AllSupertypes.get(0); // nou prenons la premier liste
		for(int i = 0 ; i < first.size() ; i++) { // on parcours ces elem
		String className = first.get(i).getName(); // nous recupére les noms des class dedant

		for(int j = 1 ; j < AllSupertypes.size(); j++) { // on parcours les autres objets 
			ArrayList<Class> other = AllSupertypes.get(j);
			boolean trouve = false; // c'est un boulean pour le test
			for(int k = 0 ; (k < other.size()) && !trouve; k++) {
				Class classtrouver = other.get(k);
				if(classtrouver.getName().equals(className)) {
						cl=classtrouver; 
						trouve = true;	}
		}
		}
		}
		
		return cl;
	}
	private  ArrayList<ArrayList<Class>> getAllSuperClassesForAllObjects() {
		ArrayList<ArrayList<Class>> result=new ArrayList<ArrayList<Class>>();
		for(Object o : list) { 
			Class c = o.getClass();
			ArrayList<Class> content= getAllSupertypes(c);
			result.add(content);
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ArrayListMystere exo1=new ArrayListMystere();
		//exo1.getMethods(1);
		System.out.println("La classe commune la plus specifique:"+ exo1.getSpecificCommonClass());
		
	}
}
