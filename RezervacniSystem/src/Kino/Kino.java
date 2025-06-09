package Kino;

import java.util.Scanner;

import Kino.ObjednaniJidla.ObjednaniJidla;

public class Kino {

	public static void main(String[] args) {
		
		String employeeFilePath = "Employees.csv";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to access Administration (type 1), Reservation system (type 2) or Buffet (type 3).");
		int choice = Integer.parseInt(scanner.nextLine());
		switch (choice) {
		case 1:
			Administrace.main(args);
			break;
		case 2:
			break;
		case 3:
			ObjednaniJidla.main();
		}
		
		
		scanner.close();
		/* Ask user what part of the system he wants to use
		   1. Administration
		   2. Reservation system
		   2. Buffet
		   
		   More info in  main file of each option...
		*/
		
		/*
		 * Think about all classes that we would want to be saved, they need some ID field so we can identify records
		 * It is necessary for example when you store an order it has a reference to an employee and it would be overhead storing whole employee directly into order
		 * so we store only it's ID instead
		 * */
	
	/**
	 * TODO: There are missing visibility modifiers inside some of your classes, please fix it
	 * TODO: Try to make your classes savable where it makes sense  - do not implement saving just implement how  they will be saved
	 * TODO: Search what is the UUID and then use class UUID to make your classes identificable by that - only in classes where it make sense
	 * TODO: Think about how we could implement that Jidlo or MenuJidlo is in sale
	 */


	}

}
