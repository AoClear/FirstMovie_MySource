package kr.co.fmos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fmos.dto.MovieResponseDTO;
import kr.co.fmos.entity.Movie;
import kr.co.fmos.repository.MovieRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final MovieRepository movieRepository;
	
	public List<MovieResponseDTO> listAllMovie() {
		List<Movie> movieList = movieRepository.findAll();
		return MovieResponseDTO.listOf(movieList);
	}
}
