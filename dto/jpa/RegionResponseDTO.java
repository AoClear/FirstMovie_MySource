package kr.co.fmos.dto;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.fmos.entity.Region;
import kr.co.fmos.entity.TheaterBranch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegionResponseDTO {
	private Long id;
	private String name;
	private List<TheaterBranch> theaterBranchs;

	public static RegionResponseDTO of(Region region) {
		return RegionResponseDTO.builder().id(region.getId()).name(region.getName())
				.theaterBranchs(region.getTheaterBranchs()).build();
	}
	
	public static List<RegionResponseDTO> listOf(List<Region> regionList)
	{
		return regionList.stream().map(RegionResponseDTO::of).collect(Collectors.toList());
	}
}
