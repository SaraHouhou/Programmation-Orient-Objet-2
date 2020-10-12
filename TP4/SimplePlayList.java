package Interfaces;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SimplePlayList extends AbstractAudioElement implements PlayList{

	private ArrayList<Song> songList=new ArrayList<Song>();
	
	public SimplePlayList(String title, String fileLocation) throws IOException {
		super(title, fileLocation); 
		
		// ici le titre n'est pas du tout géré
		if (getFile().exists()){
			
			// charger les chansons
			BufferedReader buffer =new BufferedReader(new FileReader(getFile()));
			String line=buffer.readLine();
			while (line!=null){
				try {
					Song s=Song.fromString(line); 
					songList.add(s);
				} catch (IncorrectFileNameException e) {
					System.out.println("incorrect file name, song not read "+e.getFileName());
				}
				line=buffer.readLine();
			}
			buffer.close();
		} else{
			// création d'une nouvelle playlist
			getFile().createNewFile();
		}
	}
	
	public void addSong(Song s) throws IOException{
		songList.add(s);
		BufferedWriter buffer =new BufferedWriter(new FileWriter(getFile(), true));
		buffer.write(s.toString()+"\n");
		buffer.close();
	}

	@Override
	public int getDuration() {

	}

	@Override
	public long getSize() {

	}

	@Override
	public int getNbElements() {

	}
	
	

}
