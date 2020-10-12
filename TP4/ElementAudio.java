
package Interfaces; 

import java.io.IOException;

public  interface ElementAudio {
	public int getDuration(); // la durée en secondes
	public String getTitle(); // le titre de l'élément
	public String getFileLocation(); // emplacement où est stocké l'élément; chemin absolu du fichier
	public long getSize() throws IOException; // in bytes
	
	// pour les composites
	public boolean isSong();
	public boolean isPlayList();
}