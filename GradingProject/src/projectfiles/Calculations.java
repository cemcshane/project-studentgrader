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



	public double finalCalculation() {
		for (GradingCategory cat : categories) { //cat is each individual category/criteria
			cat.categoryPoints();
			points++; //why is points giving me an error here? isn't it part of the categoryPoints method?

		}
		return points;
	}


	//Make method that returns a letter grade based on the finalCalculaton()
	public String letterGrade() {
		if (points == 100 || points > 97) {
			return "A+";	
		}
		if (points < 97 && points > 93) {
			return "A" ;
		}
		if (points < 93 && points > 90) {
			return "A-";	
		}
		if (points < 90 && points > 87) {
			return "B+";	
		}
		if (points < 87 && points > 83) {
			return "B";	
		}
		if (points < 83 && points > 80) {
			return "B-";	
		}
		if (points < 80 && points > 77) {
			return "C+";	
		}
		if (points < 77 && points > 73) {
			return "C";	
		}
		if (points < 73 && points > 70) {
			return "C-";	
		}
		if (points < 70 && points > 67) {
			return "D+";	
		}
		if (points < 67 && points > 63) {
			return "D";	
		}
		if (points < 63 && points > 60) {
			return "D-";	
		}
		else {
			return "F";
		}

	}
}


