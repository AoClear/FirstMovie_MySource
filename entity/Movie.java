package kr.co.fmos.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "movie_genre_id")
	private MovieGenre genre;

	@Column(name = "movie_name")
	private String name;

	@Column(name = "movie_running_time")
	private Integer runningTime;

	@Column(name = "movie_production_year")
	private LocalDate productionYear;

	@Column(name = "movie_audience_rating")
	private String audienceRating;

	@Column(name = "movie_image")
	private String image;

	@Column(name = "director_name")
	private String directorName;

	@Column(name = "actor_name")
	private String actorName;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ScreenMovieInfo> screenMovieInfos;
}
