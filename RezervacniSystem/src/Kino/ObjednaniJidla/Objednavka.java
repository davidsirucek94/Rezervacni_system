package Kino.ObjednaniJidla;

import java.time.LocalDateTime;

import Kino.Storage.IStorable;

public class Objednavka implements IStorable{

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

	@Override
	public String toString() {
		return numberOfOrder + ";" + dateTime + ";" + cashier.getEmployeeName() + ";" + finalPrice;
	}
	
	@Override
	public String toCsv() {
		return numberOfOrder + ";" + dateTime + ";" + cashier.getEmployeeName() + ";" + finalPrice;
	}
}
