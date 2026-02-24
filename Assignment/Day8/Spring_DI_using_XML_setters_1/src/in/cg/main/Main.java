package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class Main {
	public static void main(String[] mad) {
		String config_loc="in/cg/resources/application-context.xml";
		ApplicationContext context =new ClassPathXmlApplicationContext(config_loc);
		
		Student stu = (Student) context.getBean("stu1");
		System.out.println(stu);
	}
}
