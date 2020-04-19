package projectfiles;

import java.util.LinkedList;

public class Calculations {
	//instance variables
	public LinkedList<GradingCategory> categories;
	public String name;
	public double credits;

	//constructor
	public Calculations(Parser classInfo) {
		this.categories = classInfo.criteria;
		this.name = classInfo.className;
		this.credits = classInfo.credits;
	}
	
		

	double sum = 0;
	public double finalCalculation() {
		for (GradingCategory cat : categories) { //cat is each individual category/criteria
			sum += cat.categoryPoints();
			 

		}
		return sum;
	}


	//Make method that returns a letter grade based on the finalCalculaton()
	public String letterGrade() {
		if (sum == 100 || sum > 97) {
			return "A+";	
		}
		if (sum < 97 && sum > 93) {
			return "A" ;
		}
		if (sum < 93 && sum > 90) {
			return "A-";	
		}
		if (sum < 90 && sum > 87) {
			return "B+";	
		}
		if (sum < 87 && sum > 83) {
			return "B";	
		}
		if (sum < 83 && sum > 80) {
			return "B-";	
		}
		if (sum < 80 && sum > 77) {
			return "C+";	
		}
		if (sum < 77 && sum > 73) {
			return "C";	
		}
		if (sum < 73 && sum > 70) {
			return "C-";	
		}
		if (sum < 70 && sum > 67) {
			return "D+";	
		}
		if (sum < 67 && sum > 63) {
			return "D";	
		}
		if (sum < 63 && sum > 60) {
			return "D-";	
		}
		else {
			return "F";
		}

	}
}


