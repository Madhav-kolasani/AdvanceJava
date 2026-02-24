package in.cg.resources;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;
import in.cg.beans.Subject;

@Configuration
public class JavaConfigFile {
	
	@Bean("stu1")
	public Student stuObj() {
		Student s1 = new Student();
		s1.setId(12);
		s1.setName("Kolasani");
		s1.setEmail("Kola@gmail.com");
		return s1;
	}
	
	
	@Bean("add1")
	public Address addObj1() {
		Address ad = new Address();
		ad.sethNo(12434);
		ad.setCity("Ganapavaram");
		ad.setPincode(522617);
		return ad;
	}
	
	@Bean("add2")
	public Address addObj2() {
		Address ad = new Address();
		ad.sethNo(1275);
		ad.setCity("CPT");
		ad.setPincode(522186);
		return ad;
	}
	
	@Bean("sub1")
	public Subject addSubjects() {
		Subject subs = new Subject();
		subs.setSubjects(Arrays.asList("Telugu", "Hindi", "English", "Maths", "Sci","Soc"));
		return subs;
		
	}
	
}
