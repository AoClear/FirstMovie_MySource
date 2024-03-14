package kr.co.fmos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.fmos.entity.ScreenMovieInfo;

@Repository
public interface ScreenMovieInfoRepository extends JpaRepository<ScreenMovieInfo, Long> {
	List<ScreenMovieInfo> findById(int screenMovieInfoId);
}
