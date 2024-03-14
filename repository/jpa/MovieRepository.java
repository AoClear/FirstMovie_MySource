package kr.co.fmos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.fmos.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
