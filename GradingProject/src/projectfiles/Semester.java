package projectfiles;

import java.util.LinkedList;

public class Semester {
	public LinkedList<Course> courses;
	
	public Semester() {
		this.courses = new LinkedList<Course>();
	}
	
	//methods
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
	public double getGPA() {
		double weightedGpaPoints = 0;
		double possibleCredits = 0;
		for(Course c : courses) {
			weightedGpaPoints += c.getGPAPoints()*c.getCredits();
			possibleCredits += c.getCredits();
		}
		return (weightedGpaPoints/possibleCredits);
	}
}
