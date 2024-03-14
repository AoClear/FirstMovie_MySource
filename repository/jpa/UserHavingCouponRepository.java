package kr.co.fmos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.fmos.entity.UserHavingCoupon;

public interface UserHavingCouponRepository  extends JpaRepository<UserHavingCoupon, Long>{

}
