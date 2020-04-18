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
		//All you should need to do is iterate through all the categories
		//in the categories LinkedList (line 7) and call .categoryPoints()
		//(I made this method a while back in the GradingCategory file) on 
		//each of them, then add all of those points together and return it
		//in this method. That should give you the final percentage value.
		return 0;
	}
	
	//Make method that returns a letter grade based on the finalCalculaton()
	public String letterGrade() {
		return "";
	}

}



