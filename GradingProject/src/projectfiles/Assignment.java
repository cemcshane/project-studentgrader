package projectfiles;

public class Assignment {
	//instance variables
	public double pointsAwarded;
	public double pointsPossible;
	public GradingCategory category;
	
	//constructor
	public Assignment(double awarded, double possible, GradingCategory category) {
		this.pointsAwarded = awarded;
		this.pointsPossible = possible;
		this.category = category;
		this.category.assignments.push(this);
	}
	
	public double gradeAssignment() {
		return pointsAwarded/pointsPossible;
	}

	@Override
	public String toString() {
		return category.name + " assignment: " + pointsAwarded + "/" + pointsPossible;
	}
	
}
