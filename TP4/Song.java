package Interfaces;


import java.io.FileNotFoundException;
import java.util.StringTokenizer;


public class Song extends AbstractAudioElement {
	private String singer; 
	private int duration;
	
	public Song(String title, String fileLocation, int duration, String singer) 
			throws IncorrectFileNameException, FileNotFoundException {
		super(title, fileLocation);
		this.duration=duration;
		this.singer = singer; 
		//si le nom de fichier ne correspond pas à un fichier existant, on jettera une exiception de type incorrect file name
		if (!getFile().exists()){
			throw new IncorrectFileNameException(fileLocation);
		}
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		String result="S|";
		result+=duration+"|"+getTitle()+"|"+getFileLocation()+"|"+singer;	
		return result;
	}
	
	// la taille d'une chanson est définie comme la taille de fichier contenant
	@Override
	public long getSize() throws SecurityException{
		return getFile().length();
	}

	public static Song fromString(String s) throws IncorrectFileNameException, FileNotFoundException{
		StringTokenizer st=new StringTokenizer(s, "|");
		st.nextToken(); //pas besoin du S, il faudrait vérifier cohérence 
		String title=st.nextToken();
		String file=st.nextToken();
		int duration=Integer.valueOf(st.nextToken());

		String singer=st.nextToken();
		return new Song( title, file, duration, singer);
	}
	
	//@Override
	public String getFileLocation(boolean b){
		return null;
	}
	
	@Override
	public boolean isSong(){ return true;} 
	@Override
	public  boolean isPlayList(){ return false;} 
}
