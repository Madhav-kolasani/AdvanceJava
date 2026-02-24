package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

@Configuration
public class JavaConfigFile {
	
	@Bean("stu1")
	public Student stuObj() {
		Student s1 = new Student(123,"Yagna ", "Yagna@gmail.com", addObj());
		return s1;
	}
	
	
	@Bean("add1")
	public Address addObj() {
		Address ad = new Address(1883,"CPT",622616);
		return ad;
	}
	
}
