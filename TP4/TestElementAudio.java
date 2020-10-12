package Interfaces;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TestElementAudio {

	@Test
	public void testElementAudioFichierExistant() throws IncorrectFileNameException, FileNotFoundException {
		AbstractAudioElement unepiste=new Song("The St Louis Blues", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/(01) [Hugh Laurie] The St. Louis blues.mp3",63, "Hugh Laurie");
	}

	@Test(expected=IncorrectFileNameException.class)
	public void testElementAudioFichierNonExistant() throws IncorrectFileNameException, FileNotFoundException {
		AbstractAudioElement unepiste=new Song("Didn't it rain", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/The St Louis Blue",63, "Hugh Laurie");
	}
	
    @Test
    public void testSimplePlayList() throws IOException, IncorrectFileNameException{
    	SimplePlayList spl=new SimplePlayList("new play list", "/home/nebut/Téléchargements/newList.txt");
    	spl.addSong(new Song("The St Louis Blues", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/(01) [Hugh Laurie] The St. Louis blues.mp3", 63,"Hugh Laurie"));
    	Assert.assertEquals(1, spl.getNbElements());
    }
    
    @Test
    public void testSimpleExistingPlayList() throws IOException, IncorrectFileNameException{
    	SimplePlayList spl=new SimplePlayList("new play list", "/home/nebut/Téléchargements/existingList.txt");
    	spl.addSong(new Song( "The St Louis Blues", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/(01) [Hugh Laurie] The St. Louis blues.mp3",63, "Hugh Laurie"));
    	SimplePlayList spl2=new SimplePlayList("new play list", "/home/nebut/Téléchargements/existingList.txt");
    	spl2.addSong(new Song( "The St Louis Blues", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/(01) [Hugh Laurie] The St. Louis blues.mp3", 63, "Hugh Laurie"));
    	Assert.assertEquals(2, spl2.getNbElements());
    	File f=new File("/home/nebut/Téléchargements/existingList.txt");
    	f.delete();
    	f.createNewFile();
    }
    
    @After
    public void tearDown(){
    	File f=new File("/home/nebut/Téléchargements/newList.txt");
    	f.delete();
    	f=new File("/home/nebut/Téléchargements/newCompositeList.txt");
    	f.delete();
    }
    
    @Test
    public void testComposite() throws FileNotFoundException, IOException, IncorrectFileNameException{
    	CompositePlayList list1=new CompositePlayList("liste", "/home/nebut/Téléchargements/newCompositeList.txt");
    	list1.addElement(new Song("The St Louis Blues", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/(01) [Hugh Laurie] The St. Louis blues.mp3", 63, "Hugh Laurie"));
    	CompositePlayList list2=new CompositePlayList("liste", "/home/nebut/Téléchargements/newCompositeList.txt");
    	list2.addElement(new Song("pouet", "/home/nebut/Musique/Hugh Laurie-Didn't it rain (2013)/(01) [Hugh Laurie] The St. Louis blues.mp3", 63, "Hugh Laurie"));
    	list1.addElement(list2);
    }
}
