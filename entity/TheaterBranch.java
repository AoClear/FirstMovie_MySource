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
@Table(name = "theater_branch")
public class TheaterBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;

	@Column(name = "branch_name", nullable = false)
	private String name;

	@Column(name = "branch_address", nullable = false)
	private String address;

	@Column(name = "branch_number", nullable = false)
	private Integer number;

	@Column(name = "branch_img")
	private String image;

	@OneToMany(mappedBy = "theaterBranch", cascade = CascadeType.ALL)
	private List<ScreenMovieInfo> screenMovieInfos;

	@OneToMany(mappedBy = "theaterBranch", cascade = CascadeType.ALL)
	private List<Screen> screens;
}
