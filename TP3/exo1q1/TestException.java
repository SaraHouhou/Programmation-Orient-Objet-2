package exo1q1;

import java.io.IOException;


class Exc1 extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public Exc1(String string) {
	//	super(string);
		// TODO Auto-generated constructor stub
//	}


}

class Exc2 extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;}


public class TestException {
	
	public void f1(){
		
		try {
		throw new Exc1(); 
		}catch(Exc1 e1) {
			System.out.println("RuntimeException"+":"+e1.getMessage());
		}
		finally {
			System.out.println("f1 fin ");
		}
		} 
	
	public void f2(){		
		try {
			throw new Exc2();
		} catch (Exc2 e2) {
			// TODO Auto-generated catch block
		//	e2.printStackTrace();
			System.out.println("IOException"+":"+e2.getMessage());
		}
		finally {
			System.out.println("f2 fin ");
		}
	
	} 
	public static void main(String[] args){ 
	    TestException t = new TestException(); 
	    t.f1();
	    t.f2();
	    
	}
	
	
}

