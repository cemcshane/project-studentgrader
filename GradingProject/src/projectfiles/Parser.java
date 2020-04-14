package projectfiles;

import java.util.LinkedList;

public class Parser {
	public String className;
	public double credits;
	public LinkedList<GradingCategory> criteria;
	
	public Parser() {
		this.className = "";
		this.credits = 0;
		this.criteria = new LinkedList<GradingCategory>();
	}
	
	public void changeName(String name) {
		this.className = name;
	}
	
	public void changeCredits(double credits) {
		this.credits = credits;
	}
	
	public void addCategory(GradingCategory category) {
		this.criteria.add(category);
	}
	
	public void addAssignment(String category, Assignment a) {
		for(GradingCategory g : this.criteria) {
			if(g.name==category) {
				g.addAssignment(a);
				break;
			}
		}
	}
	
	public GradingCategory getCategory(String name) {
		for(GradingCategory g : this.criteria) {
			if(g.name.equals(name)) {
				return g;
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException { //might need to change to try/catch 								  //around the scanner declaration

	}

	@Override
	public String toString() {
		return "Class: " + className + "\nCredits: " + credits + "\nGrading Criteria: " + criteria +"\nAssignments:\n" + criteria.getFirst().assignments.toString() + "\n" + criteria.getLast().assignments.toString();
	}
	
	

}
