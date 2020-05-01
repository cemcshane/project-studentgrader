package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.Assignment;
import projectfiles.GradingCategory;

class TestGradingCategory {

	GradingCategory category = new GradingCategory("name", 50.0);
	Assignment input = new Assignment(10.0, 20.0, category);
	
	@Test
	void testCategoryPoints() {
		assertEquals((10.0/20.0*50.0), category.categoryPoints(), "Category points returns the wrong value");
	}

	@Test
	void testPointsPossible() {
		assertEquals(20.0, input.pointsPossible, "Incorrect number of points possible");
	}
	@Test
	void testPointsAwarded() {
		assertEquals(10.0, input.pointsAwarded, "Incorrect number of points awarded");
	}
	
	GradingCategory categoryTwo = new GradingCategory("name", 30.0);
	Assignment inputTwo = new Assignment(3.0, 9.0, categoryTwo);
	
	
	
	@Test
	void testCategoryPointsTwo() {
		assertEquals((3.0/9.0*30.0), categoryTwo.categoryPoints(), "Category points returns the wrong value");
	}

	
	@Test
	void testPointsPossibleTwo() {
		assertEquals(9.0, inputTwo.pointsPossible, "Incorrect number of points possible");
	}
	@Test
	void testPointsAwardedTwo() {
		assertEquals(3.0, inputTwo.pointsAwarded, "Incorrect number of points awarded");
	}
}
