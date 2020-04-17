package projectfiles;

import java.util.LinkedList;

public class Calculations {

	double pointsAwarded;
	double pointsPossible;
	GradingCategory category;
	String name;
	int percentage;
	LinkedList<Assignment> assignments;


	//import classes from Parser, Assignment, and GradingCategory
	Parser finalGrade = new Parser();
	Assignment newAssign = new Assignment(pointsAwarded, pointsAwarded, category);
	GradingCategory newCat = new GradingCategory(name, percentage);
	
	//
	

	


}



