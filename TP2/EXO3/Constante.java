package TD2.EXO3;
public class Constante extends Expression {
	private float number;
	
	public Constante(float number) {
		this.number = number;
	}
	
	public float eval() {
		return number;
	}
}
