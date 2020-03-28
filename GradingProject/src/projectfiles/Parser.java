package projectfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
//	Replace the bracketed statements with your class syllabus details.    
	
//	Class name:
//	[name]    
	
//  Credits:                                                                                                                
//	[number of credits the class is] 
	
//	Grade Breakdown: (add as many categories as needed on separate lines)                                                   
//		example: Quizzes, 10%                                                                                                   
//	[grading category], [percent weight]%   
	
//	Assignments: (add as many assignments as needed on separate lines)
//	[grading category], [points awarded], [total points possible]       
	
//	Current GPA:                                                                                                            
//	[GPA]/[highest possible GPA] 
	public static void main(String[] args) throws FileNotFoundException { //might need to change to try/catch 
		// TODO Auto-generated method stub								  //around the scanner declaration
		File file = new File(args[0]);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		sc.skip(Pattern.compile("Replace the bracketed statements with your class syllabus details."));
//		sc.skip(Pattern.compile("Class name:"));
//		sc.skip(Pattern.compile("Grade Breakdown: (add as many categories as needed on separate lines)"));
//		sc.skip(Pattern.compile("	example: Quizzes, 10%"));
		boolean isGradeBreakdown = false;
		boolean isAssignment = false;
		boolean isGPA = false;
		boolean alreadyParsed = false;
		int linesParsed = 0;
		String className = "";
		double credits = 0.0;
		String [] gradeBreakdown = new String[3];
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		double gpa = 0.0;
		double possibleGPA = 0.0;
		while(sc.hasNextLine()) {
			alreadyParsed = false;
			String line = sc.nextLine();
			if(line.matches("[A-Za-z0-9_]+")) {
				if(linesParsed==0) {
					className = line;
					++linesParsed;
					alreadyParsed = true;
				}
				if(linesParsed==1) {
					credits = Double.parseDouble(line);
					++linesParsed;
					isGradeBreakdown = true;
					alreadyParsed = true;
				}
				if(isGradeBreakdown && !alreadyParsed) {
					if(line.matches("^Assignments: (add as many assignments as needed on separate lines)$")) {
						isGradeBreakdown = false;
						isAssignment = true;
						alreadyParsed = true;
					}
					else {
						gradeBreakdown = line.split(", ");
						percentages.put(gradeBreakdown[0], Double.parseDouble(gradeBreakdown[1]));
						++linesParsed;
						alreadyParsed = true;
					}
				}
				if(isAssignment && !alreadyParsed) {
					if(line.matches("^Current GPA:$")) {
						isAssignment = false;
						isGPA = true;
						alreadyParsed = true;
					}
					else {
						//need to figure out how to store this
						++linesParsed;
						alreadyParsed = true;
					}
				}
				if(isGPA && !alreadyParsed) {
					String [] splitGPA = line.split("/");
					gpa = Double.parseDouble(splitGPA[0]);
					possibleGPA = Double.parseDouble(splitGPA[1]);
					++linesParsed;
				}
			}
		}
		sc.close();
		System.out.println("Class name: " + className);
		System.out.println("Credit value: " + credits);
		System.out.println("Grading Breakdown:");
		for(HashMap.Entry<String, Double> entry : percentages.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
		}
		System.out.println();
		System.out.println("Current GPA: " + gpa + "/" + possibleGPA);
	}

}
