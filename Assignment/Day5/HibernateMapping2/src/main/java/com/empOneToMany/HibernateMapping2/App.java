package com.empOneToMany.HibernateMapping2;

import com.entities.Course;
import com.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        
        

        Student student = new Student();
        student.setName("Madhav");

        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Hibernate");

        student.addCourse(c1);
        student.addCourse(c2);

        session.persist(student);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}