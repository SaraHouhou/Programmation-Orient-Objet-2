package Interfaces;



public class AnnotationExample {
	
	String name;


	public AnnotationExample(String name) {
		this.name=name;
	}
	
	@ToDo(
			task=ToDo.Task.improve_complexity, 
			version=2,
			duration= 4
			)
	public String getName() {
		return name;
	}
}
