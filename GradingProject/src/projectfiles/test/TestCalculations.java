package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.Assignment;
import projectfiles.Calculations;
import projectfiles.GradingCategory;
import projectfiles.Parser;

class TestCalculations {

	Parser input = new Parser();
	Calculations calc = new Calculations(input);
	GradingCategory catOne = new GradingCategory("one", 50);
	GradingCategory catTwo = new GradingCategory("two", 25);
	GradingCategory catThree = new GradingCategory("three", 25);
	Assignment assOne = new Assignment(10, 20, catOne);
	Assignment assTwo = new Assignment(15, 20, catOne);
	Assignment assThree = new Assignment(20, 20, catOne);
	Assignment assFour = new Assignment(30, 40, catTwo);
	Assignment assFive = new Assignment(50, 50, catTwo);
	Assignment assSix = new Assignment(10, 10, catThree);
	
	
	@Test
	void testFinalCalculationSimple() {
		input.addCategory(catOne);
		input.addCategory(catTwo);
		input.addCategory(catThree);
		input.addAssignment("catOne", assThree);
		input.addAssignment("catTwo", assFive);
		input.addAssignment("catThree", assSix);
		double returnValue = calc.finalCalculation();
		assertEquals(100, returnValue);
	}
	
	@Test
	void testFinalCalculation() {
		input.addCategory(catOne);
		input.addCategory(catTwo);
		input.addCategory(catThree);
		input.addAssignment("catOne", assOne);
		input.addAssignment("catOne", assTwo);
		input.addAssignment("catOne", assThree);
		input.addAssignment("catTwo", assFour);
		input.addAssignment("catTwo", assFive);
		input.addAssignment("catThree", assSix);
		double returnValue = calc.finalCalculation();
		assertEquals((25+(((75+100)/2)*.25)+(((50+75+100)/3)*.5)), returnValue,.01);
	}

}
