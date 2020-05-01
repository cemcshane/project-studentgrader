package projectfiles.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projectfiles.Assignment;
import projectfiles.Calculations;
import projectfiles.GradingCategory;
import projectfiles.Parser;

class TestCalculations {


	@Test
	void testFinalCalculationSimple() {
		Parser input = new Parser();
		GradingCategory catFive = new GradingCategory("five", 100);
		input.addCategory(catFive);
		Assignment assSeven = new Assignment(100, 100, catFive);
		Assignment assEight = new Assignment(100, 100, catFive);
		Calculations calc = new Calculations(input);
		double returnValue = calc.finalCalculation();
		assertEquals(100, returnValue);
	}
	
	@Test
	void testFinalCalculationSortaSimple() {
		Parser input = new Parser();
		GradingCategory catFour = new GradingCategory("four", 72);
		GradingCategory catFive = new GradingCategory("five", 28);
		input.addCategory(catFour);
		input.addCategory(catFive);
		Assignment assOne = new Assignment(76.0, 77.0, catFour);
		Assignment assTwo = new Assignment(23.3, 33.0, catFour);
		Assignment assThree = new Assignment(13.0, 15.0, catFive);
		Assignment assFour = new Assignment(30.5, 35.0, catFive);
		Calculations calc = new Calculations(input);
		double returnValue = calc.finalCalculation();
		assertEquals((((99.3/110)*72)+((13+30.5)/50)*28), returnValue);
	}
	
	@Test
	void testFinalCalculationSameName() {
		Parser input = new Parser();
		GradingCategory catFour = new GradingCategory("four", 72);
		GradingCategory catFive = new GradingCategory("four", 28);
		input.addCategory(catFour);
		input.addCategory(catFive);
		Assignment assOne = new Assignment(76.0, 77.0, catFour);
		Assignment assTwo= new Assignment(23.3, 33.0, catFour);
		Assignment assThree = new Assignment(13.0, 15.0, catFive);
		Assignment assFour = new Assignment(30.5, 35.0, catFive);
		Calculations calc = new Calculations(input);
		double returnValue = calc.finalCalculation();
		assertEquals((((99.3/110)*72)+((13+30.5)/50)*28), returnValue);
	}
	
	@Test
	void testFinalCalculation() {
		Parser input = new Parser();
		GradingCategory catOne = new GradingCategory("one", 50);
		GradingCategory catTwo = new GradingCategory("two", 25);
		GradingCategory catThree = new GradingCategory("three", 25);
		input.addCategory(catOne);
		input.addCategory(catTwo);
		input.addCategory(catThree);
		Assignment assOne = new Assignment(10.0, 20.0, catOne);
		Assignment assTwo = new Assignment(15.0, 20.0, catOne);
		Assignment assThree = new Assignment(20.0, 20.0, catOne);
		Assignment assFour = new Assignment(30.0, 40.0, catTwo);
		Assignment assFive = new Assignment(50.0, 50.0, catTwo);
		Assignment assSix = new Assignment(10.0, 10.0, catThree);
		Calculations calc = new Calculations(input);
		double returnValue = calc.finalCalculation();
		assertEquals((25+(((80.0)/90.0)*25)+(((45.0)/60.0)*50)), returnValue,.01);
	}

}
