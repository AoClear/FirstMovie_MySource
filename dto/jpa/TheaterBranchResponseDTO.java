package kr.co.fmos.dto;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.fmos.entity.Region;
import kr.co.fmos.entity.TheaterBranch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TheaterBranchResponseDTO {
	private Long id;
	private Region region;
	private String name;
	private String address;
	private Integer number;
	private String image;

	public static TheaterBranchResponseDTO of(TheaterBranch theaterBranch) {
		return TheaterBranchResponseDTO.builder().id(theaterBranch.getId()).region(theaterBranch.getRegion())
				.name(theaterBranch.getName()).address(theaterBranch.getAddress()).number(theaterBranch.getNumber())
				.image(theaterBranch.getImage()).build();
	}

	public static List<TheaterBranchResponseDTO> listOf(List<TheaterBranch> theaterBranchList) {
		return theaterBranchList.stream().map(TheaterBranchResponseDTO::of).collect(Collectors.toList());
	}
}
