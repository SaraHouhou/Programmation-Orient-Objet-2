package Interfaces; 

public interface PlayList extends ElementAudio {
	public int getNbElements();
	
	@Override
	public default boolean isSong(){ return false;} 
	@Override
	public default boolean isPlayList(){ return true;} 
}