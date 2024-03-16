package kr.co.fmos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fmos.entity.Point;
import kr.co.fmos.repository.PointRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointService {
	private final PointRepository pointRepository;

	public int getTotalPointByMemberId(String memberId) {
		List<Point> pointList = pointRepository.findByMemberId(memberId);
		return pointList.isEmpty() ? 0 : pointList.stream()
                .mapToInt(Point::getHistory)
                .sum();
	}
}
