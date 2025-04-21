package Kino.ObjednaniJidla;

import java.time.LocalDateTime;

public class Objednavka {

	final int numberOfOrder;
	final LocalDateTime dateTime;
	final Employee cashier;
	final double finalPrice;

	// final dovolí něco nastavit v konstruktoru, ale nedovolí to změnit zvenčí

	public Objednavka(int numberOfOrder, Employee cashier, double finalPrice) {
		this.numberOfOrder = numberOfOrder;
		this.dateTime = LocalDateTime.now();
		this.cashier = cashier;
		this.finalPrice = finalPrice;
	}

}
