package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.Assignment;
import projectfiles.GradingCategory;
import projectfiles.Parser;

class TestParserInput {

	Parser input = new Parser();
	GradingCategory category = new GradingCategory("name", 50);
	Assignment ass = new Assignment(5,10,category);
	
	@Test
	void testChangeName() {
		input.changeName("CSE 237");
		assertEquals ("CSE 237", input.className, "Class name was parsed incorrectly");
	}
	
	@Test
	void testChangeCredits() {
		input.changeCredits(3);
		assertEquals (3, input.credits, "Class credits were parsed incorrectly");
	}
	
	@Test
	void testAddCatergory() {
		input.addCategory(category);
		assertTrue(input.criteria.contains(category));
	}
	
	@Test
	void testGetCategory() {
		input.addCategory(category);
		assertEquals (category, input.getCategory(category.name), "Categories were not parsed correctly");
	}
	
	@Test
	void testGetCategoryNull() {
		assertNull(input.getCategory(""));
	}
	
	@Test
	void testDeleteCategory() {
		input.deleteCategory(category);
		assertEquals(input.getCategory(category.name), null, "Category was not deleted successfully");
	}
	
	@Test
	void testDeleteAssignment() {
		input.deleteAssignment(ass);
		assertFalse(category.assignments.contains(ass), "Assignment was not deleted successfully");
	}
	
	@Test
	void testClear() {
		input.clear();
		assertTrue(input.criteria.isEmpty(), "Criteria were not cleared correctly");
	}
	
}
