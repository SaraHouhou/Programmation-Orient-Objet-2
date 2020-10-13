package Execice3;

public class TestFileAttenteAvecPriorite {
	public static void main(String[] args) {
		FileAttenteAvecPriorite<Personne> fa = new FileAttenteAvecPriorite<Personne>();
		fa.entre(new Personne("Paul",40));
		fa.entre(new Personne("Chloe",24));

		fa.entre(new Personne("Leo",10));
		fa.sort();
		//fa.sort();
		System.out.println(fa);
	}
}
