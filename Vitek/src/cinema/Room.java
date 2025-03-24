package cinema;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private int roomNumber;
	private boolean isImax;
	private boolean isVip;
	private List<List<Seat>> rows;
	

	public Room(int roomNumber, int numberOfRows, int numberOfSeatsInRow, boolean isImax, boolean isVip) {
		this.roomNumber = roomNumber;
		this.isImax = isImax;
		this.isVip = isVip;
		rows = new ArrayList<>();

		if(numberOfRows == 0 || numberOfSeatsInRow) {
			throw new RuntimeException("Cannot create empty room.");
		}

		for (int i = 0; i < numberOfRows; i++) {
			rows.add(new ArrayList<>());
			for (int j = 0; j < numberOfSeats; j++) {
				rows.get(i).add(new Seat(j));
			}
		}
	}


	public void takeSeat(int row, int number) {
		Seat seat = room.getSeat(row, number);

		if(seat.getIsTaken()){
			return false;
		}

		seat.setTaken();
		return true;
	}

	public boolean getSeat(int row, int number) {
		return rows.get(row).get(number);
	}
	
	public int getCountOfFreeSeats() {
		int count = 0;
		for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
			for(int seatIndex = 0; seatIndex < rows.get(rowIndex).size(); seatIndex++) {
				if(!rows.get(rowIndex).get(seatIndex).getIsTaken()) {
					count++;
				}
			}
		}
		return count;
	}

	public boolean isFull() {
		for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
			for(int seatIndex = 0; seatIndex < rows.get(rowIndex).size(); seatIndex++) {
				if(!rows.get(rowIndex).get(seatIndex).getIsTaken()) {
					return false;
				}
			}
		}
		
		return true;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int rowIndex = 0;
		
		result.append(String.format("%s%sRoom %s", isVip ? "⭐ " : "", isImax ? "👓 " : "", String.valueOf(roomNumber)));
		for (List<Seat> row : rows) {
			result.append(String.format("Row %d: ", rowIndex + 1));
			for (Seat seat : row) {
				result.append(seat.toString()).append(" ");
			}

			rowIndex++;
			result.append("\n");
		}
		
		return result.toString();
	}
}
