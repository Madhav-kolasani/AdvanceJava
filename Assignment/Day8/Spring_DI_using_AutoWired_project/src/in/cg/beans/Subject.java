package in.cg.beans;

import java.util.List;

public class Subject {
	private List<String> subjects;


	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}


	@Override
	public String toString() {
		return "\nSubjects=" + subjects;
	}
	
	
}
