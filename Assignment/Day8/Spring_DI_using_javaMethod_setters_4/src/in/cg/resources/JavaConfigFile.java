package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

@Configuration
public class JavaConfigFile {
	
	@Bean("stu1")
	public Student stuObj() {
		Student s1 = new Student();
		s1.setId(12);
		s1.setName("Kolasani");
		s1.setEmail("Kola@gmail.com");
		s1.setAddress(addObj());
		return s1;
	}
	
	
	@Bean("add1")
	public Address addObj() {
		Address ad = new Address();
		ad.sethNo(12434);
		ad.setCity("Ganapavaram");
		ad.setPincode(522617);
		return ad;
	}
	
}
