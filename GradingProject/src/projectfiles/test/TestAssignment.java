package projectfiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAssignment {
	
	GradingCategory category = new GradingCategory("name", 5);
	Assignment input = new Assignment(10, 20, category);
	
	
	@Test
	void testGradeAssignment() {
		assertEquals(input.gradeAssignment(), .5, "Assignment was not graded correctly");
	}

}
