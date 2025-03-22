package cinema;
import java.time.LocalDateTime;
import java.util.Collections.Set;
import java.util.Collections.HashSet;

public class Show {

	private Movie movie;
	private Room room;
	private LocalDateTime showTime;
	
	public Show(Movie movie, Room room, LocalDateTime showTime) {
		this.movie = movie;
		this.room = room;
		this.showTime = showTime;
	}

	public getRoom() {
		return room;
	}

	public String getMovieTitle() {
		return movie.getTitle();
	}

	public boolean canBeReserved() {
		return !room.isFull() && Duration.between(LocalDateTime.now(), showTime).toMinutes() > Constants.MINUTES_TO_CLOSE_RESERVATIONS;
	}



	public String getFormattedShowTime() {
        return showTime.format(Constants.HOURS_MINUTES_FORMATTER);
	}
}
