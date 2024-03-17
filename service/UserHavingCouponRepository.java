package kr.co.fmos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.fmos.entity.UserHavingCoupon;

public interface UserHavingCouponRepository  extends JpaRepository<UserHavingCoupon, Long>{
	List<UserHavingCoupon> findByMemberId(String MemberId);
}
