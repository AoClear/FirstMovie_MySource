package kr.co.fmos.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import kr.co.fmos.entity.Movie;
import kr.co.fmos.entity.MovieGenre;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieResponseDTO {
	private Long id;
	private MovieGenre genre;
	private Integer runningTime;
	private LocalDate productionYear;
	private String audienceRating;
	private String image;
	private String directorName;
	private String actorName;

	public static MovieResponseDTO of(Movie movie) {
		return MovieResponseDTO.builder().id(movie.getId()).genre(movie.getGenre()).runningTime(movie.getRunningTime())
				.productionYear(movie.getProductionYear()).audienceRating(movie.getAudienceRating())
				.image(movie.getImage()).directorName(movie.getDirectorName()).actorName(movie.getActorName()).build();
	}
	
	public static List<MovieResponseDTO> listOf(List<Movie> movieList)
	{
		return movieList.stream().map(MovieResponseDTO::of).collect(Collectors.toList());
	}
}
