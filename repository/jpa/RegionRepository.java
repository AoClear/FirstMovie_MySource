package kr.co.fmos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.fmos.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
