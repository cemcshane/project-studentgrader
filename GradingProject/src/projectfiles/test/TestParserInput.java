package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.GradingCategory;
import projectfiles.Parser;

class TestParserInput {

	Parser input = new Parser();
	GradingCategory category = new GradingCategory("name", 50);
	
	
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
	
}
