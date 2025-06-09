package Kino.ObjednaniJidla;

import java.util.UUID;

import Kino.Storage.IStorable;

public class Employee implements IStorable{
	private String name;
	private PracovniPozice position;
	private UUID id;

	public Employee(String name, PracovniPozice position) {
		this.name = name;
		this.position = position;
		id = UUID.randomUUID();
	}

	public String getEmployeeName() {
		return name;
	}

	public PracovniPozice getEmployeePosition() {
		return position;
	}

	public boolean canEmployeeRunKasa() {
		if (position == PracovniPozice.CLEANINGLADY) {
			return false;
		}
		return true;

		// return position != PracovniPozice.CLEANINGLADY;
	}
	
	public static Employee fromCsv(String[] row) {
		return new Employee(row[0], PracovniPozice.valueOf(row[1]));
	}

	@Override
	public String toString() {
		return String.format("Employee`s name: %s, Employee`s position: %s", name, position);
	}
	
	@Override
	public String toCsv() {
		return id + ";" + name + ";" + position;
	}

	@Override
	public UUID getId() {
		return id;
	}
}
