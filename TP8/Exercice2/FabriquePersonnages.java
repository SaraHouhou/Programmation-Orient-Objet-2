package Exercice2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FabriquePersonnages {


public FabriquePersonnages(){
	
}



// question 1

public Personnage newEmptyInstance( String classname) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
@SuppressWarnings("rawtypes")
Class newclass = Class.forName(classname);		// tu cree une class avec le nom donnée 		

	@SuppressWarnings({ "unchecked", "rawtypes" })
	Constructor constructeur = newclass.getConstructor(); // il va me permettre de recuperer une representation de constructeur

	Personnage newpersonnage = (Personnage) constructeur.newInstance();
//------------ 2 eme façons qu'On peut faire aussi
	//Class<Personnage> c = (Class<Personnage>) Class.forName(classname);		
	//Personnage np =  c.newInstance();
	
	return newpersonnage;
	
}

// question 2

//Class public Field getFields() retourne tous les attributs publics de la Class appelante. 
//Dans la classe Field les methodes  public String getName() et public void set(Object objet, Object valeur) 
//permettent respectivement d’obtenir le nom de l’attribut et d’en changer la valeur pour un objet donnée.)

public static Field[] getAllFields(Class c){
Field[] declaredFields=c.getDeclaredFields();
//----> les attribut de l'insncance
ArrayList<Field> inheritedFields =new ArrayList<Field>();
for (Class superc:getAllSupertypes(c)){

	for (Field f :superc.getDeclaredFields()){
		inheritedFields.add(f); // tout les attributs de l'héritage
	}
}
Field[] result=new Field[declaredFields.length+inheritedFields.size()];
int i=0;
for (Field f:declaredFields){result[i]=f;i++;}
for (Field f:inheritedFields){result[i]=f;i++;}
return result;
}

public static ArrayList<Class> getAllSupertypes(Class c){
ArrayList<Class> result=new ArrayList<Class>();
Class superclass=c.getSuperclass();

if (!superclass.getName().equals("java.lang.Object")){
	result.add(superclass);
	result.addAll(getAllSupertypes(superclass));
}
return result;
}

public Personnage fabriquerValeur(Personnage newpersonnage) throws Exception {	
Field[] fields = getAllFields(newpersonnage.getClass());
//Field[] declaredFields=c.getDeclaredFields();

for(Field attribut : fields) {
	System.out.print("Entrer la valeur de l'attribut "+attribut.getName()
	+" (un "+attribut.getType().getName()+") : ");
	Scanner input = new Scanner(System.in);
	String val = input.nextLine();
	
	attribut.setAccessible(true); // autorise l'accibilité à l'attribut

	if(attribut.getType().getName().equals("int")){
		int Val_attr_convertit = Integer.parseInt(val);
		attribut.set(newpersonnage,Val_attr_convertit); // set prend object et valeur
	}
	else {
		if(attribut.getType().getName().equals("double")){
			double Val_attr_convertit = Double.parseDouble(val);
			attribut.set(newpersonnage,Val_attr_convertit);
		}
		else {
			assert attribut.getType().getName().endsWith("String") : "Type incorrect pour l'attribut : "+attribut.getName();
			attribut.set(newpersonnage,val);
		}
	}
}				
return (Personnage)newpersonnage;
}	

public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	//Scanner saisie = new Scanner(System.in);

	//System.out.print("Entrer le nom de la classe de Personnage : ");
	//String className = saisie.next();
	
	FabriquePersonnages fp= new FabriquePersonnages();

	//	Personnage newpersonnage;
		try {
		Personnage	newpersonnage = fp.newEmptyInstance("Exercice2.PersonnageBonus");
	System.out.println(newpersonnage.toString());
	System.out.println("Name of Class  = " + newpersonnage.getClass().getName());  //get the name of class  
    System.out.println("Package Name  = " + newpersonnage.getClass().getPackage());//get the name of class 
    Field[] existingFlds = newpersonnage.getClass().getDeclaredFields();
    Field[] AllDeclaredFlds= fp.getAllFields(newpersonnage.getClass());
    List listfilds= Arrays.asList(existingFlds);
    System.out.println("fil Taille de declared filds  = " + listfilds.size()); 
    System.out.println("fil Taille de all declared filds with super class = " + AllDeclaredFlds.length); 

//	-------------------------------------
    	
    fp.fabriquerValeur(newpersonnage) ;//.getClass().getDeclaredFields();
    	System.out.println("Merci pour l'initialisation des attributs");

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error "+e.getMessage());

	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error2 "+e.getMessage());

		}
		

				
	
}
}
