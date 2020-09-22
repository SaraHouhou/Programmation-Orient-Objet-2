package TD2.EXO3;

public class ExpressionComplexe extends Expression{
	private Expression op1;
	private char op;
	private Expression op2;
	
	public ExpressionComplexe(Expression op1, char op, Expression op2) {
		this.op1 = op1;
		this.op = op;
		this.op2 = op2;
	}
	
	public float eval() {
		switch(op) {
		case '+' : return op1.eval() + op2.eval();
		
		case '-' : return op1.eval() - op2.eval();
		
		case '*' : return op1.eval() * op2.eval();
		
		case '/' : return op1.eval() / op2.eval();
		
		default : throw new RuntimeException("Unknown Operator");
		}
	}
}
