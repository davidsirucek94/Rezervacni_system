package Kino.ObjednaniJidla;

import java.time.LocalDateTime;
import java.util.UUID;

import Kino.Storage.IStorable;

public class Objednavka implements IStorable{

	final int numberOfOrder;
	final LocalDateTime dateTime;
	final Employee cashier;
	final double finalPrice;
	private UUID id;

	// final dovolí něco nastavit v konstruktoru, ale nedovolí to změnit zvenčí

	public Objednavka(int numberOfOrder, Employee cashier, double finalPrice) {
		this.numberOfOrder = numberOfOrder;
		this.dateTime = LocalDateTime.now();
		this.cashier = cashier;
		this.finalPrice = finalPrice;
		id = UUID.randomUUID();
	}

	public static Objednavka fromCsv(String[] row) {
		return new Objednavka(Integer.parseInt(row[0]), new Employee(row[2], PracovniPozice.CASHIER),
				Double.parseDouble(row[3]));
	}
	
	@Override
	public String toString() {
		return numberOfOrder + ";" + dateTime + ";" + cashier.getEmployeeName() + ";" + finalPrice;
	}
	
	@Override
	public String toCsv() {
		return id + ";" + numberOfOrder + ";" + dateTime + ";" + cashier.getEmployeeName() + ";" + finalPrice;
	}

	@Override
	public UUID getId() {
		return id;
	}
}
