package TD2.EXO1;

public class Document {
private String titre; 
public String getNom( ) {
return titre;
}
public Document ( String titre ) {
super ( ) ;
this.titre = titre ;
}
@Override
public String toString ( ) {
return "Document [ t i t r e=" + titre + " ] " ;
}


}