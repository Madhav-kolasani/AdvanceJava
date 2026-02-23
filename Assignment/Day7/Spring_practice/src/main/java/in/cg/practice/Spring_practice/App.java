package in.cg.practice.Spring_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Person;
import in.cg.resources.JavaConfigFile;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigFile.class);
        Person p1 = (Person) context.getBean("p1");
        Person p2 = (Person) context.getBean("p2");
        System.out.println(p1);
        System.out.println(p2);
    }
}
