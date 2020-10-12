package Interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD) // pour qu'elle soit appliquer que sur les methodes
public @interface ToDo {
	
	enum Task{write, improve_complexity, refactorise,test };
	
	Task task() default Task.test;
	
	int version();
	
	int duration();

}
