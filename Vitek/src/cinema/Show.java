package cinema;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Collections.Set;
import java.util.Collections.HashSet;

public class Show {

	private String uuid;
	private Movie movie;
	private String roomUuid;
	
	public Show(Movie movie, String roomUuid) {
		this.movie = movie;
		this.roomUuid = roomUuid;
	}

	public void takeSeat(int row, int seatIndex) {

	}

    public String getUuid(){
		return uuid;
 	}
}
