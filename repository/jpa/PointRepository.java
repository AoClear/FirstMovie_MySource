package kr.co.fmos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.fmos.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
	List<Point> findByMemberId(String memberId);
}
