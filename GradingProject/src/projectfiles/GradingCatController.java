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
	
	public boolean check100() {
		int sumPercentages = 0;
		for(int i=0; i<criteria.getSize(); ++i) {
			sumPercentages += criteria.get(i).percentage;
		}
		if(sumPercentages!=100) {
			return false;
		}
		return true;
	}
	
	public void deleteCategory(GradingCategory input) {
		this.criteria.removeElement(input);
	}
	
	public void clear() {
		this.criteria.clear();
	}
}
