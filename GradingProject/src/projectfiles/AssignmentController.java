package projectfiles;

import javax.swing.DefaultListModel;

public class AssignmentController {
	private DefaultListModel<Assignment> assignments;
	
	//constructor
	public AssignmentController() {
		this.assignments = new DefaultListModel<Assignment>();
	}
	
	public void addAssignment(Assignment a) {
		this.assignments.addElement(a);
	}
	
	public void deleteAssignment(Assignment input) {
		this.assignments.removeElement(input);
	}
	
	public void clear() {
		this.assignments.clear();
	}	
	
	public DefaultListModel<Assignment> getAssignments(){
		return this.assignments;
	}
}
