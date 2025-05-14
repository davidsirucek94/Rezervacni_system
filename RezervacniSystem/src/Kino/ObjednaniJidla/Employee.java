package Kino.ObjednaniJidla;

public class Employee {
	private String name;
	private PracovniPozice position;

	public Employee(String name, PracovniPozice position) {
		this.name = name;
		this.position = position;
		this.uuid = UUID.randomUUID();
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

	@Override
	public String toString() {
		return String.format("Employee`s name: %s, Employee`s position: %s", name, position);
	}
}
