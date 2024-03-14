package kr.co.fmos.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import kr.co.fmos.entity.Movie;
import kr.co.fmos.entity.Screen;
import kr.co.fmos.entity.ScreenMovieInfo;
import kr.co.fmos.entity.TheaterBranch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScreenMovieInfoResponseDTO {
	private Long id;
	private Movie movie;
	private Screen screen;
	private TheaterBranch theaterBranch;
	private LocalDate movieShowingDate;
	private LocalTime movieShowingTime;

	public static ScreenMovieInfoResponseDTO of(ScreenMovieInfo screenMovieInfo) {
		return ScreenMovieInfoResponseDTO.builder().id(screenMovieInfo.getId()).movie(screenMovieInfo.getMovie())
				.screen(screenMovieInfo.getScreen()).theaterBranch(screenMovieInfo.getTheaterBranch())
				.movieShowingDate(screenMovieInfo.getMovieShowingDate())
				.movieShowingTime(screenMovieInfo.getMovieShowingTime()).build();
	}

	public static List<ScreenMovieInfoResponseDTO> listOf(List<ScreenMovieInfo> screenMovieInfoList) {
		return screenMovieInfoList.stream().map(ScreenMovieInfoResponseDTO::of).collect(Collectors.toList());
	}
}