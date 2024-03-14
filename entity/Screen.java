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
@Table(name = "screen")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screen_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private TheaterBranch theaterBranch;

    @Column(name = "screen_location", nullable = false)
    private String location;

    @Column(name = "screen_row")
    private Integer row;

    @Column(name = "screen_line")
    private Integer line;
    
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<ScreenMovieInfo> screenMovieInfos;
}