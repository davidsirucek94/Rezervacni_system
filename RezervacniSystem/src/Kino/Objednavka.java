package Kino;

import java.time.LocalDateTime;

public class Objednavka {

	int numberOfOrder;
	LocalDateTime dateTime;
	String cashier;
	double finalPrice;
	
	public Objednavka(int numberOfOrder, String cashier, double finalPrice) {
		this.numberOfOrder = numberOfOrder;
		this.dateTime = LocalDateTime.now();
		this.cashier = cashier;
		this.finalPrice = finalPrice;
	}
	
}
