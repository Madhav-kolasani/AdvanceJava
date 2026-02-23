package in.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Employee;

@Configuration
public class JavaConfigFile {

	@Bean("Emp1")
	public Employee empObj1() {
		Employee e1 = new Employee();
		e1.setEId(1);
		e1.setEName("Madhav");
		e1.setSalary(30000);
		return e1;
	}
}
