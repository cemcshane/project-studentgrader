package projectfiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestParserInput {

	Parser input = new Parser();
	GradingCategory category = new GradingCategory("name", 25);
	
	@Test
	void testChangeName() {
		input.changeName("CSE 237");
		assertEquals (input.className, "CSE 237", "Class name was parsed incorrectly");
	}
	
	@Test
	void testChangeCredits() {
		input.changeCredits(3);
		assertEquals (input.credits, 3, "Class credits were parsed incorrectly");
	}
	
	@Test
	void testAddCatergory() {
		input.addCategory(category);
		assertTrue(input.criteria.contains(category));
	}
	
	@Test
	void testGetCategory() {
		input.addCategory(category);
		assertEquals (input.getCategory(category.name), category, "Categories were not parsed correctly");
	}
	
	@Test
	void testGetCategoryNull() {
		assertNull(input.getCategory(""));
	}
	
	

}
