package projectfiles;

import java.util.LinkedList;

public class GradingCategory {
	//instance variables
	public String name;
	public double percentage;
	public LinkedList<Assignment> assignments;
	
	//constructor
	public GradingCategory(String name, double percentage) {
		this.name = name;
		this.percentage = percentage;
		this.assignments = new LinkedList<Assignment>();
	}
	
	//how many points given for that category (up to 100)
	public double categoryPoints() {
		if(pointsPossible()==0) {
			return percentage;
		}
		double points = (pointsAwarded()/pointsPossible())*percentage;
		return points;
	}
	
	
	private double pointsPossible() {
		double possiblePoints = 0;
		for(Assignment a : assignments) {
			possiblePoints += a.pointsPossible;
		}
		return possiblePoints;
	}
	
	private double pointsAwarded() {
		double awardedPoints = 0;
		for(Assignment a : assignments) {
			awardedPoints += a.pointsAwarded;
		}
		return awardedPoints;
	}
	
	public LinkedList<Assignment> getAssignments(){
		return this.assignments;
	}
	
	@Override
	public String toString() {
		return name + ", " + percentage + "%";
	}
}
