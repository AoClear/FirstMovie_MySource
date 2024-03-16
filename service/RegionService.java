package kr.co.fmos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fmos.dto.RegionResponseDTO;
import kr.co.fmos.entity.Region;
import kr.co.fmos.repository.RegionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionService {
	private final RegionRepository regionRepository;
	
	public List<RegionResponseDTO> listAllRegion() {
		List<Region> regionList = regionRepository.findAll();
		return RegionResponseDTO.listOf(regionList);
	}
}
