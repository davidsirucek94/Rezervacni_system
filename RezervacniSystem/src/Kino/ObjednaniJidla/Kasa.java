package Kino.ObjednaniJidla;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kino.Konstanty;

public class Kasa {

	private int numberOfKasa;
	private Employee cashier;
	private Scanner scanner;
	private List<Jidlo> seznamJidel;
	private List<MenuJidlo> jidlaMenu;
	private int numberOfLastOrder = 0;
	private List<Objednavka> seznamObjednavek = new ArrayList<>();

	public Kasa(int numberOfKasa, Scanner scanner, List<Jidlo> seznamJidel, List<MenuJidlo> jidlaMenu) {
		this.numberOfKasa = numberOfKasa;
		this.scanner = scanner;
		this.seznamJidel = seznamJidel;
		this.jidlaMenu = jidlaMenu;
	}

	public void assignEmployee(Employee employee) {
		if (employee.canEmployeeRunKasa() == true) {
			cashier = employee;
		} else {
			System.out.printf("Employee %s cannot run the check-out! Get your dirty hands off my money %s!",
					employee.getEmployeeName(), employee.getEmployeePosition());
		}
	}

	public void getObjednavka() {
		if (cashier == null) {
			System.out.println("We are closed! Too bad :(");
			return; // early return
		}

		boolean wantMenu = false;
		boolean moreSnacks = false;
		List<Jidlo> chosenMeal = new ArrayList<>();
		List<MenuJidlo> chosenMenu = new ArrayList<>();
		
		System.out.println("Hello! Would you like to buy menu? Type yes/no: ");
		String menuChosen = scanner.nextLine().toLowerCase().trim();
		wantMenu = menuChosen.equals("yes");
		
		while (wantMenu == true) {

			for (int i = 0; i < jidlaMenu.size(); i++) {
				System.out.printf("Choice %d: %s, %.2f Kč \n", i + 1, jidlaMenu.get(i).getNazev(),
						jidlaMenu.get(i).getCena());
			}
			
			int selectedMenuIndex = Integer.parseInt(scanner.nextLine()) - 1;
			chosenMenu.add(jidlaMenu.get(selectedMenuIndex));
			
			System.out.println("Would you like to buy another Menu? Type: Yes/No:");
			String buyMoreMenu = scanner.nextLine().toLowerCase().trim();
			wantMenu = buyMoreMenu.equals("yes");
			
		}

		System.out.println("Would you like to buy some snack? Type yes/no: ");
		String snackChosen = scanner.nextLine().toLowerCase().trim();
		moreSnacks = snackChosen.equals("yes");
		
		while (moreSnacks == true) {

			for (int i = 0; i < seznamJidel.size(); i++) {
				System.out.printf("Choice %d: %s, %.2f Kč \n", i + 1, seznamJidel.get(i).getNazev(),
						seznamJidel.get(i).getCena());
			}

			int selectedMealIndex = Integer.parseInt(scanner.nextLine()) - 1;
			chosenMeal.add(seznamJidel.get(selectedMealIndex));
			// System.out.println(jidlo.get(chosenMeal).getNazev());

			System.out.println("Would you like to buy any other snack? Type: Yes/No:");
			String buyMoreSnacks = scanner.nextLine().toLowerCase().trim();
			moreSnacks = buyMoreSnacks.equals("yes");

		}

		double finalPrice = 0;

		System.out.println("Summary of your order:");
		System.out.printf("Number of Check-out: %d, ", numberOfKasa);
		System.out.printf("Cashier`s name: %s, \n", cashier.getEmployeeName());
		for (int i = 0; i < chosenMenu.size(); i++) {
			System.out.printf("%s \n", chosenMenu.get(i)); // využívá metodu toString
			finalPrice = finalPrice + chosenMenu.get(i).getCena();
		}
		for (int i = 0; i < chosenMeal.size(); i++) {
			System.out.printf("%s \n", chosenMeal.get(i)); // využívá metodu toString
			finalPrice = finalPrice + chosenMeal.get(i).getCena();
		}
		System.out.printf("----------------------------------\nYour final price is: %.2f Kč. ", finalPrice);
		System.out.println("Would you like to place the order? Type: Yes/No:");
		String placeOrder = scanner.nextLine().toLowerCase().trim();
		if (placeOrder.equals("yes")) {
			seznamObjednavek.add(new Objednavka(++numberOfLastOrder, cashier, finalPrice));
		}
	}

	public void printListOfOrders() {
		System.out.printf("List of Orders (%d): \n", seznamObjednavek.size());
		System.out.println("----------------------------------");
		for (int i = 0; i < seznamObjednavek.size(); i++) {
			Objednavka objednavka = seznamObjednavek.get(i);
			System.out.printf("Number of Order: %d, Date and Time: %s, Cashier`s name: %s, Final price: %.2f \n",
					objednavka.numberOfOrder, objednavka.dateTime.format(Konstanty.FORMATTER),
					objednavka.cashier.getEmployeeName(), objednavka.finalPrice);
		}
	}

}
