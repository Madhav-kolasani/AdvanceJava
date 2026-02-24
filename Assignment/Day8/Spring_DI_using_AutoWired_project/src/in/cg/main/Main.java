package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.JavaConfigFile;

public class Main {
	public static void main(String[] mad) {
		ApplicationContext context =new AnnotationConfigApplicationContext(JavaConfigFile.class);
		
		Student stu = (Student) context.getBean("stu1");
		System.out.println(stu);
	}
}
