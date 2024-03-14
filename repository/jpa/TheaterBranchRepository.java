package kr.co.fmos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.fmos.entity.TheaterBranch;

@Repository
public interface TheaterBranchRepository extends JpaRepository<TheaterBranch, Long>{

}