package Kino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjednaniJidla {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<Jidlo> seznamJidel = new ArrayList<>();
		seznamJidel.add(new Jidlo("Slaný popcorn", 200.50));
		seznamJidel.add(new Jidlo("Nachos", 186.70));
		
		Kasa kasa1 = new Kasa(1, "Jan Příhoda", scanner, seznamJidel);
		Kasa kasa2 = new Kasa(2, "Valentina García Coronado", scanner, seznamJidel);

		kasa1.getObjednavka();
		
		scanner.close();
	}

}
