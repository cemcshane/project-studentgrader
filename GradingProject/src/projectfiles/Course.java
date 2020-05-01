package projectfiles;

public class Course {
	//instance variables
	public String name;
	private double credits;
	private double grade;
	private double gpaPoints;
	
	//constructor
	public Course(Calculations courseCalc) {
		this.name = courseCalc.name;
		this.credits = courseCalc.credits;
		this.grade = courseCalc.finalCalculation();
		courseCalc.letterGrade();
		this.gpaPoints = courseCalc.gpaPoints;
	}
	
	//methods
	public double getCredits() {
		return this.credits;
	}
	
	public double getGPAPoints() {
		return this.gpaPoints;
	}
}
