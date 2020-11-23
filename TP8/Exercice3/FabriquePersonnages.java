package Exercice3;

import java.lang.reflect.*;
import java.util.*;



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

// Class public Field getFields() retourne tous les attributs publics de la Class appelante. 
// Dans la classe Field les methodes  public String getName() et public void set(Object objet, Object valeur) 
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
//	Field[] declaredFields=c.getDeclaredFields();

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
//----------------------------------------------------- 
// exercice 3 : migrationPersonnage

@SuppressWarnings({ "unchecked", "rawtypes" })
public Cible TransformerLePersonnage( PersonnageInvisible p, Cible  ObjetClassCible) throws Exception  {	
	Field[] fieldPersonnageClass = p.getClass().getFields();
	Class classcible= ObjetClassCible.getClass();
	Field[] fieldCibleClass = classcible.getFields();

for(int i=0; i<fieldPersonnageClass.length; i++) {
	Field attributPersonnageClass = fieldPersonnageClass[i];

		for(int j=0; j<fieldCibleClass.length; j++) {
			
		Field attributCibleClass = fieldCibleClass[j];
			if (attributPersonnageClass.getName()== attributCibleClass.getName()) {
				attributCibleClass.set(ObjetClassCible, attributPersonnageClass.get(p.getClass()));
				System.out.println("fild name"+attributPersonnageClass.getName()+"fildValeur"+attributPersonnageClass.get(p));
			}
			else {
				
				System.out.print("Entrer la valeur de l'attribut "+attributCibleClass.getName() +" (un "+attributCibleClass.getType().getName()+") : ");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				String val = input.nextLine();
				if(attributCibleClass.getType().getName().equals("int")){
					int Val_attr_convertit = Integer.parseInt(val);
					attributCibleClass.set(ObjetClassCible,Val_attr_convertit); // set prend object et valeur
				}
				else {
					if(attributCibleClass.getType().getName().equals("double")){
						double Val_attr_convertit = Double.parseDouble(val);
						attributCibleClass.set(ObjetClassCible,Val_attr_convertit);
					}
					else {
						assert attributCibleClass.getType().getName().endsWith("String") : "Type incorrect pour l'attribut : "+attributCibleClass.getName();
						attributCibleClass.set(ObjetClassCible,val);
					}
				}
				
			}
			
		}

		
	}
		//System.out.print("Entrer la valeur de l'attribut "+attribut.getName() +" (un "+attribut.getType().getName()+") : ");


	return ObjetClassCible;
}



// ou bien nous utilisons une method separrer 
public static Personnage migrate(Personnage p, String toClass) throws Exception {
	Class c = Class.forName(toClass);	// exercice3.personnagebonus	
	Personnage np = (Personnage) c.newInstance();		
	Field[] fields = c.getFields();
	Field[] existingFlds = p.getClass().getFields();
	for(Field f : fields) {
		int pos = fieldPosition(f,existingFlds);
		if(pos != -1) {
			System.out.println("Valeur de l'attribut "+f.getName()+" copiee.");
			f.set(np,existingFlds[pos].get(p));
		}
		else {
			System.out.print("Entrer la valeur de l'attribut "+f.getName()+" (un "+f.getType().getName()+") : ");
			Scanner in = new Scanner(System.in);

			String val = in.nextLine();
			if(f.getType().getName().equals("int")){
				int a = Integer.parseInt(val);
				f.set(np,a);
			}
			else {
				if(f.getType().getName().equals("boolean")){
					boolean x = Boolean.parseBoolean(val);
					f.set(np,x);
				}
				else {
					assert f.getType().getName().endsWith("String") : "Type incorrect pour l'attribut : "+f.getName();
					f.set(np,val);
				}
			}
		}
	}
	return np;		
}
private static int fieldPosition(Field field, Field[] fields) {
	for(int i = 0; i < fields.length ; i++) {
		Field f = fields[i];
		if(f.getName().equals(field.getName())) {
			if(f.getType().getName().equals(field.getType().getName()))
				return i;
		}
	}
	return -1;
}


public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		//Scanner saisie = new Scanner(System.in);

		//System.out.print("Entrer le nom de la classe de Personnage : ");
		//String className = saisie.next();
		
		FabriquePersonnages fp= new FabriquePersonnages();
	
		//	Personnage newpersonnage;
			try {
			Personnage	newpersonnage = fp.newEmptyInstance("Exercice3.PersonnageBonus");
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
