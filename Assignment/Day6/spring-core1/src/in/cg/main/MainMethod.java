package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class MainMethod {
	public static void main(String[] madhav) {
		String config_loc="/in/cg/resources/application-context.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);
		Student st1 = (Student) context.getBean("student");
		
		System.out.println(st1);
	}
}
