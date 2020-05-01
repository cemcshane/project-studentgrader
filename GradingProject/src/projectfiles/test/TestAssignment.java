package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.Assignment;
import projectfiles.GradingCategory;

class TestAssignment {
	
	GradingCategory category = new GradingCategory("name", 5);
	Assignment input = new Assignment(10.0, 20.0, category);
	
	
	@Test
	void testGradeAssignment() {
		assertEquals(.5, input.gradeAssignment(), "Assignment was not graded correctly");
	}
	
	GradingCategory categoryTwo = new GradingCategory("name", 2);
	Assignment inputTwo = new Assignment(98.0, 100.0, category);
	
	
	@Test
	void testGradeAssignmentTwo() {
		assertEquals((98.0/100.0), inputTwo.gradeAssignment(), "Assignment was not graded correctly");
	}

}
