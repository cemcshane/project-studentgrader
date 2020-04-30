package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.Assignment;
import projectfiles.GradingCategory;

class TestGradingCategory {

	GradingCategory category = new GradingCategory("name", 50);
	Assignment input = new Assignment(10, 20, category);
	
	@Test
	void testCategoryPoints() {
		assertEquals(25, category.categoryPoints(), "Category points returns the wrong value");
	}

	@Test
	void testAddAssignment() {
		category.addAssignment(input);
		assertTrue(category.assignments.contains(input));
	}
	
	@Test
	void testPointsPossible() {
		assertEquals(20, input.pointsPossible, "Incorrect number of points possible");
	}
	@Test
	void testPointsAwarded() {
		assertEquals(10, input.pointsAwarded, "Incorrect number of points awarded");
	}
}
