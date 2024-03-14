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
@Table(name = "region")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private Long id;

	@Column(name = "region_name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<TheaterBranch> theaterBranchs;
}
