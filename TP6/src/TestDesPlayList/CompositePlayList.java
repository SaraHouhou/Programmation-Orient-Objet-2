package TestDesPlayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CompositePlayList extends AbstractAudioElement implements PlayList{

	private ArrayList<ElementAudio> list=new ArrayList<ElementAudio>();
	
	public static CompositePlayList fromString(String s) throws FileNotFoundException, IOException{
		
		StringTokenizer st=new StringTokenizer(s, "|");
		st.nextToken(); //pas besoin du L, il faudrait vérifier cohérence
		String title=st.nextToken();
		String file=st.nextToken();
		return new CompositePlayList(title, file);
	}

	@Override
	public String toString(){
		String result="L|"+getTitle()+"|"+getFileLocation()+"\n";
		for (ElementAudio e:list){
			result+=e.toString()+"\n";
		}
		result+="F";// caractère de fin de liste
		return result;
	}
	public CompositePlayList(String title, String fileLocation) throws FileNotFoundException, IOException {
		super(title, fileLocation);
		if (getFile().exists()){
			// charger les chansons
			BufferedReader buffer =new BufferedReader(new FileReader(getFile()));
			String line=buffer.readLine();
			// traitement de la première ligne : déclaration de la liste
			StringTokenizer st=new StringTokenizer(line, "|");
			st.nextToken(); //pas besoin du L, il faudrait vérifier cohérence
			this.setTitle(st.nextToken());
			this.setFileLocation(st.nextToken());
			// traitement des autres lignes
			line=buffer.readLine();
			Stack<CompositePlayList> currentlists=new Stack<CompositePlayList>();
			currentlists.push(this); // la liste en cours est la liste qu'on est en train de créer
			Song currents=null;
			while (line!=null){
				if (line.charAt(0)=='S'){// line contient la description d'une chanson
					try {
						currents=Song.fromString(line); 
					} catch (IncorrectFileNameException e) {
						System.out.println("incorrect file name, song not read "+e.getFileName());
					}
					if (currentlists.isEmpty()){ // on n'est pas en train de charger une liste, on ajoute simplement la chanson
						list.add(currents);
					} else { // on ajoute à la liste en cours
						currentlists.peek().loadElement(currents);
					}
				} else if (line.charAt(0)=='L'){//début de liste, on crée la liste et on l'empile
					currentlists.push(CompositePlayList.fromString(line));
					
				}else if (line.charAt(0)=='F'){// fin de liste, on dépile
					currentlists.pop();
				} else{
					System.out.println("problème !!");
				}
				line=buffer.readLine(); // on a fini de traiter la ligne en cours, on en relit une
				}
				buffer.close();
			} else{
				// création d'une nouvelle playlist
			getFile().createNewFile();
			BufferedWriter buffer =new BufferedWriter(new FileWriter(getFile(), true));
			buffer.write(toString()+"\n");
			buffer.close();
		}
	}

		private void loadElement(ElementAudio e){
			list.add(e);
		}
		
		public void addElement(ElementAudio e) throws IOException{
			list.add(e);
			
			//BufferedWriter buffer =new BufferedWriter(new FileWriter(getFile(), true));
			 BufferedReader file = new BufferedReader(new FileReader(getFile()));
		        String line;
		        String input = "";
		        // on met dans input tout le texte du fichier, beeeerk
		        while((line = file.readLine()) != null)
		        {
		            input += line + '\n';
		        }
		        // on enlève le dernier F
		        input = input.substring(0, input.length()-2);
		        input =input.concat(e.toString()+"\nF");
		        
		        FileOutputStream out = new FileOutputStream(getFile());
		        out.write(input.getBytes());
		        out.close();
		        
			//buffer.write(e.toString()+"\n"); // Noooon ! il faut écrire avant le dernier F
			//buffer.close();
		}
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSize() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbElements() {
		// TODO Auto-generated method stub
		return 0;
	}



}