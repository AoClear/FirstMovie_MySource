package kr.co.fmos.entity;

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
@Table(name = "movie_genre")
public class MovieGenre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_genre_id")
	private Long id;

	@Column(name = "movie_genre_name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Movie> movies;
}