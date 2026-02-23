package in.cg.spring.spring_mvn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Employee;
import in.cg.config.JavaConfigFile;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigFile.class);
 
    	Employee e1= (Employee) context.getBean("Emp1");
    	System.out.print(e1);
    }
}
