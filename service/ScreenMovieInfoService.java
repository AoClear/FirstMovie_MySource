package kr.co.fmos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fmos.dto.ScreenMovieInfoResponseDTO;
import kr.co.fmos.entity.ScreenMovieInfo;
import kr.co.fmos.repository.ScreenMovieInfoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScreenMovieInfoService {
	private final ScreenMovieInfoRepository screenMovieInfoRepository;

	public List<ScreenMovieInfoResponseDTO> listAllScreenMovieInfo() {
		List<ScreenMovieInfo> screenMovieInfoList = screenMovieInfoRepository.findAll();
		return ScreenMovieInfoResponseDTO.listOf(screenMovieInfoList);
	}
}
