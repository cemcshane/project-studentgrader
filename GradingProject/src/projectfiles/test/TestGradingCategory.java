package projectfiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGradingCategory {

	GradingCategory category = new GradingCategory("name", 50);
	Assignment input = new Assignment(10, 20, category);
	
	@Test
	void testCategoryPoints() {
		assertEquals(category.categoryPoints(), 25, "Category points returns the wrong value");
	}

	@Test
	void testAddAssignment() {
		category.addAssignment(input);
		assertTrue(category.assignments.contains(input));
	}
	
	@Test
	void testPointsPossible() {
		assertEquals(input.pointsPossible, 20, "Incorrect number of points possible");
	}
	@Test
	void testPointsAwarded() {
		assertEquals(input.pointsAwarded, 10, "Incorrect number of points awarded");
	}
}
