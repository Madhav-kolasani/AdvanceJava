package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Student;

@Configuration
public class SpringJavaConfiguration {
	
	@Bean
	public Student Stu1() {
		Student s1 = new Student();
		s1.setEmail("Mad@gmail.com");
		s1.setName("madhav");
		s1.setId(1122);
		return s1;
	}
	
	@Bean
	public Student Stu2() {
		Student s2 = new Student();
		s2.setId(123);
		s2.setName("Yagna");
		s2.setEmail("yagna@gmail.com");
		return s2;
	}
	
	@Bean("Stu3")
	public Student creatingStuObj() {
		Student s3 = new Student();
		s3.setName("Kolasani");
		s3.setId(1991);
		s3.setEmail("Kolasani@gmail.com");
		return s3;
	}
}
