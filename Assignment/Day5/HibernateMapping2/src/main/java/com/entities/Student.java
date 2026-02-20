package com.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();

	public void addCourse(Course course) {
		courses.add(course);
		course.setStudent(this);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
		course.setStudent(null);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}
}
