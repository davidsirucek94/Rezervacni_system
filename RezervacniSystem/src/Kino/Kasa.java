package Kino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kasa {

	private int numberOfKasa;
	private String cashiersName;
	private Scanner scanner;
	private List<Jidlo> seznamJidel;
	private int numberOfLastOrder = 0;
	private List<Objednavka> seznamObjednavek;

	public Kasa(int numberOfKasa, String cashiersName, Scanner scanner, List<Jidlo> seznamJidel) {
		this.numberOfKasa = numberOfKasa;
		this.cashiersName = cashiersName;
		this.scanner = scanner;
		this.seznamJidel = seznamJidel;
	}

	public void getObjednavka() {
		boolean moreSnacks = false;
		List<Jidlo> chosenMeal = new ArrayList<>();

		do {
			System.out.println("Hello! Choose some snack. Type in the number of the selected snack: ");

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

		} while (moreSnacks == true);

		// System.out.println(chosenMeal);

		double finalPrice = 0;

		System.out.println("Summary of your order:");
		System.out.printf("Number of Check-out: %d", numberOfKasa);
		System.out.printf("Cashier`s name: %s", cashiersName);
		for (int i = 0; i < chosenMeal.size(); i++) {
			System.out.printf("%s \n", chosenMeal.get(i)); // využívá metodu toString
			finalPrice = finalPrice + chosenMeal.get(i).getCena();
		}
		System.out.printf("----------------------------------\nYour final price is: %.2f Kč", finalPrice);
		System.out.println("Would you like to buy place the order? Type: Yes/No:");
		String placeOrder = scanner.nextLine().toLowerCase().trim();
		if (placeOrder.equals("yes")) {
			seznamObjednavek.add(new Objednavka(++numberOfLastOrder, cashiersName, finalPrice));
		}
	}

}
