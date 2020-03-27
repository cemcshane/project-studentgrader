package projectfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

	public static void main(String[] args) throws FileNotFoundException { //might need to change to try/catch 
		// TODO Auto-generated method stub								  //around the scanner declaration
		File file = new File(args[0]);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		sc.useDelimiter("/^Class name:$/");
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}

}
