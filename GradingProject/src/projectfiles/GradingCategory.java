package projectfiles;

import java.awt.Component;
import java.util.LinkedList;

public class GradingCategory {
	//instance variables
	public String name;
	public int percentage;
	public LinkedList<Assignment> assignments;
	
	//constructor
	public GradingCategory(String name, int percentage) {
		this.name = name;
		this.percentage = percentage;
		this.assignments = new LinkedList<Assignment>();
	}
	
	//how many points given for that category (up to 100)
	public double categoryPoints() {
		double points = (pointsAwarded()/pointsPossible())*percentage;
		return points;
	}
	
	public void addAssignment(Assignment a) {
		this.assignments.add(a);
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
	
	@Override
	public String toString() {
		return name + ", " + percentage + "%";
	}
}
