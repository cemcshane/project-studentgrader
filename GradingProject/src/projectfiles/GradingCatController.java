package projectfiles;

import javax.swing.DefaultListModel;

public class GradingCatController {
	private DefaultListModel<GradingCategory> criteria;
	
	//constructor
	public GradingCatController() {
		this.criteria = new DefaultListModel<GradingCategory>();
	}
	
	public void addCriterion(GradingCategory g) {
		this.criteria.addElement(g);
	}
	
	public DefaultListModel<GradingCategory> getCriteria(){
		return this.criteria;
	}
}
