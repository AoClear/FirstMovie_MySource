package kr.co.fmos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fmos.dto.TheaterBranchResponseDTO;
import kr.co.fmos.entity.TheaterBranch;
import kr.co.fmos.repository.TheaterBranchRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheaterBranchService {
	private final TheaterBranchRepository theaterBranchRepository;

	public List<TheaterBranchResponseDTO> listAllTheaterBranch() {
		List<TheaterBranch> theaterBranchList = theaterBranchRepository.findAll();
		return TheaterBranchResponseDTO.listOf(theaterBranchList);
	}
}
