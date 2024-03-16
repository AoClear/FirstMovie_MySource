package kr.co.fmos.movie;

public class MovieDTO extends MoviegenreDTO {
	private int movie_id; // SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
	private int movie_genre_id; // TINYINT UNSIGNED NOT NULL,
	private String movie_name; // VARCHAR(50) NOT NULL,
	private int movie_running_time; // SMALLINT UNSIGNED NOT NULL,
	private String movie_production_year; // DATETIME NOT NULL,
	private String movie_audience_rating; // VARCHAR(30) NOT NULL,
	private String movie_image; // VARCHAR(255) NOT NULL,
	private String director_name; // VARCHAR(20) NOT NULL,
	private String actor_name; // VARCHAR(20) NOT NULL

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getMovie_genre_id() {
		return movie_genre_id;
	}

	public void setMovie_genre_id(int movie_genre_id) {
		this.movie_genre_id = movie_genre_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public int getMovie_running_time() {
		return movie_running_time;
	}

	public void setMovie_running_time(int movie_running_time) {
		this.movie_running_time = movie_running_time;
	}

	public String getMovie_production_year() {
		return movie_production_year;
	}

	public void setMovie_production_year(String movie_production_year) {
		this.movie_production_year = movie_production_year;
	}

	public String getMovie_audience_rating() {
		return movie_audience_rating;
	}

	public void setMovie_audience_rating(String movie_audience_rating) {
		this.movie_audience_rating = movie_audience_rating;
	}

	public String getMovie_image() {
		return movie_image;
	}

	public void setMovie_image(String movie_image) {
		this.movie_image = movie_image;
	}

	public String getDirector_name() {
		return director_name;
	}

	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}

	public String getActor_name() {
		return actor_name;
	}

	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}

	@Override
	public String toString() {
		return "MovieDTO [movie_id=" + movie_id + ", movie_genre_id=" + movie_genre_id + ", movie_name=" + movie_name
				+ ", movie_running_time=" + movie_running_time + ", movie_production_year=" + movie_production_year
				+ ", movie_audience_rating=" + movie_audience_rating + ", movie_image=" + movie_image
				+ ", director_name=" + director_name + ", actor_name=" + actor_name + "]";
	}

}
