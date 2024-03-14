package kr.co.fmos.entity;

import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "screen_movie_information")
public class ScreenMovieInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_information_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

	@ManyToOne
	@JoinColumn(name = "screen_id", nullable = false)
	private Screen screen;

	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private TheaterBranch theaterBranch;

	@Column(name = "movie_showing_date", nullable = false)
	private LocalDate movieShowingDate;

	@Column(name = "movie_showing_time", nullable = false)
	private LocalTime movieShowingTime;
	
	@OneToMany(mappedBy = "screenMovieInfo", cascade = CascadeType.ALL)
	private List<ScreenMovieInfo> screenMovieInfos;
}
