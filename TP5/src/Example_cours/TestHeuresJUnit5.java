package Example_cours;

import static org.hamcrest.MatcherAssert.assertThat ;
import static org.junit.jupiter.api.Assertions.*; //junit 5
//import static java.time.Duration.ofMillis ;
import org.junit.jupiter.api.BeforeEach ;

//import org.junit.jupiter.api.Disabled ;
import org.junit.jupiter.api.Test ;
import static org.hamcrest.object.HasToString.*;

class TestHeuresJUnit5 {

Heure h1 ;
 Heure h2 ;
 Heure h3 ;
 Heure h4 ;
 Heure h5 ;
Heure h6 ;
@BeforeEach
public void setUp ( ) throws HoraireIncorrectException {
 h1=new Heure (10,15 ) ;
 h2=new Heure (21,55 ) ;
 h3=new Heure (8,10 ) ;
 h4=new Heure (22,00 ) ;
 h5=new Heure (12,05 ) ;
 h6=new Heure (8,15 ) ;
 }

 @Test
 public void testToStringHeureValide ( ) {
 assertEquals("10 : 15" , h1.toString ( ) ) ;
 assertEquals("21 : 55" , h2.toString( ) ) ;
 assertEquals("08 : 10" , h3.toString( ) ) ;
 assertEquals("22 : 00" , h4.toString( ) ) ;
 assertEquals("12 : 05" , h5.toString( ) ) ;
 assertEquals("08 : 15" , h6.toString( ) ) ;
 assertThat( h6,hasToString("08 : 15") ) ; // avec hamcrest
}
 @Test
public void testCreationHeureInvalideDepasseHeureMax ( ) {
assertThrows( HoraireIncorrectException.class, ( ) -> { new Heure ( 23 , 05 ) ;
}) ;
 }
 
 //@Test(expected=HoraireIncorrectException.class) (in junit4
//public void testCreationHeureInvalideDepasseHeureMax2 ( ) 
//throws HoraireIncorrectException{ new Heure ( 23 , 05 ) ;
// }
 
 @Test //assertThrows: prend en premier paramètre la classe d’exception qui
// est attendue, et en deuxième paramètre le comportement devant lever cette exception, sous forme de lambda
// expression
 public void testCreationHeureInvalideAvantHeureMin ( ) {
assertThrows ( HoraireIncorrectException.class, ( ) -> { new Heure ( 6 , 10 ) ;
 }) ;
 }

@Test
 public void testCreationHeureInvalideGranulariteFausse( ) {
assertThrows ( HoraireIncorrectException.class, ( ) -> { new Heure ( 7 , 12 ) ;
 }) ;
 }

@Test
public void testCreationHeureInvalideMauvaiseGranulariteFausse( ) {
	try {
		new Heure(7,12);
		fail("l'exception aurait du leve"); // positionner un fail("la raison du fail") si l’exception n’est pas attrapée.
}catch(HoraireIncorrectException e){
	assert(true); // attraper l’exception dans une clause catch et y placer un assert(true) (pour que le test réussisse, il faut passer par ce catch)
}
}
 @Test
public void testEstAvant ( ) {
	assertFalse( h1.estStrictementAvant ( h1 ) ) ;
assert (h1.estAvant ( h2 ) ) ;
assert( h1.estAvant ( h4 ) ) ;
assert( h1.estAvant ( h5 ) ) ;
assert( h2.estAvant ( h4 ) ) ;
assert( h3.estAvant ( h6 ) ) ;
}
}