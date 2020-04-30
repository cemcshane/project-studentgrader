package projectfiles;

import java.util.LinkedList;

public class Calculations {
	//instance variables
	public LinkedList<GradingCategory> categories;
	public String name;
	public double credits;
	public double gpaPoints;

	//constructor
	public Calculations(Parser classInfo) {
		this.categories = classInfo.criteria;
		this.name = classInfo.className;
		this.credits = classInfo.credits;
		this.gpaPoints = 0.0;
	}
	
		

	public double finalCalculation() {
		double sum = 0;
		for (GradingCategory cat : categories) { //cat is each individual category/criteria
			sum += cat.categoryPoints();
		}
		return sum;
	}


	//Make method that returns a letter grade based on the finalCalculaton()
	public String letterGrade() {
		double sum = finalCalculation();
		if (sum >= 97) {
			this.gpaPoints = 4.0;
			return "A+";	
		}
		if (sum < 97 && sum >= 93) {
			this.gpaPoints = 4.0;
			return "A" ;
		}
		if (sum < 93 && sum >= 90) {
			this.gpaPoints = 3.7;
			return "A-";	
		}
		if (sum < 90 && sum >= 87) {
			this.gpaPoints = 3.3;
			return "B+";	
		}
		if (sum < 87 && sum >= 83) {
			this.gpaPoints = 3.0;
			return "B";	
		}
		if (sum < 83 && sum >= 80) {
			this.gpaPoints = 2.7;
			return "B-";	
		}
		if (sum < 80 && sum >= 77) {
			this.gpaPoints = 2.3;
			return "C+";	
		}
		if (sum < 77 && sum >= 73) {
			this.gpaPoints = 2.0;
			return "C";	
		}
		if (sum < 73 && sum >= 70) {
			this.gpaPoints = 1.7;
			return "C-";	
		}
		if (sum < 70 && sum >= 67) {
			this.gpaPoints = 1.3;
			return "D+";	
		}
		if (sum < 67 && sum >= 63) {
			this.gpaPoints = 1.0;
			return "D";	
		}
		if (sum < 63 && sum >= 60) {
			this.gpaPoints = 0.0;
			return "D-";	
		}
		else {
			this.gpaPoints = 0.0;
			return "F";
		}

	}
}


