package TestDesPlayList;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractAudioElement implements ElementAudio {
	public String title;
	public String fileLocation;
	//public int duration;
	public File file; //attribut ajouter java.io.file

	 // L'annotation @Override indique au compilateur qu'une méthode donnée est la redéfinition d'une méthode de la superclasse.
	
	@Override
	public String getTitle() {	
		return title;
	}
	@Override
	public String getFileLocation() {
		return fileLocation;
	}
	

	public AbstractAudioElement(String title, String fileLocation)  throws FileNotFoundException {
		this.title = title;
		this.fileLocation = fileLocation;
		file=new File(fileLocation); //le fichier est créé ici à la création de l'élément audio abstrait
		//ce fichier peut exister si le nom de fichier correspond effectivement à un fichier ou ne peut pas exister 
		if(!file.exists()) throw new FileNotFoundException(); 
	}	
	
	public File getFile(){
		return file;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
}

