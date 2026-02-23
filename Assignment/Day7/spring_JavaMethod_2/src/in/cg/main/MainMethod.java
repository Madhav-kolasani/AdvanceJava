package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfiguration;

public class MainMethod {
	public static void main(String[] madhav) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class); // method 1
		Student st1 = (Student) context.getBean("Stu1",Student.class);
		Student st2 = (Student) context.getBean("Stu2",Student.class);
		Student st3 = (Student) context.getBean("Stu3");
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		
	}
}
