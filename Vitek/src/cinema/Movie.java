package cinema;
import java.util.UUID;

public class Movie {

private String uuid;

private String title;
private String description;
private Genre genre;
private int durationInMinutes;

public Movie(String title, String decription, Genre genre, int durationInMinutes) {
	this.uuid =  UUID.randomUUID().toString();
	this.title = title;
	this.description = description;
	this.genre = genre;
	this.durationInMinutes = durationInMinutes;
}

public String getTitle() {
	return title;
}

public String getDescription() {
	return description;
}

public Genre getGenre() {
	return genre;
}

public int getDurationInMinutes() {
	return durationInMinutes;
}

public String getUuid(){
	return uuid;
}

}
