package projectfiles;

import javax.swing.DefaultListModel;

public class GradeController {
	private DefaultListModel<String> gradeStrings;
	
	//constructor
	public GradeController() {
		this.gradeStrings = new DefaultListModel<String>();
	}
	
	public void addGrade(String s) {
		this.gradeStrings.addElement(s);
	}
	
	public DefaultListModel<String> getGrades(){
		return this.gradeStrings;
	}
}
