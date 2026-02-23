package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.JavaConfigFIle;

public class MainMethod {
	public static void main(String[] madhav) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigFIle.class);
		Student st1 = (Student) context.getBean(Student.class);
		
		System.out.println(st1);
	}
}
