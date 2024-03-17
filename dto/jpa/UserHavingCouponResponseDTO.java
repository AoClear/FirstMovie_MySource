package kr.co.fmos.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import kr.co.fmos.entity.Coupon;
import kr.co.fmos.entity.Member;
import kr.co.fmos.entity.UserHavingCoupon;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserHavingCouponResponseDTO {
	private Long id;
	private Member member;
	private Coupon coupon;
	private LocalDateTime createDate;
	private LocalDateTime expirationDate;

	public static UserHavingCouponResponseDTO of(UserHavingCoupon userHavingCoupon) {
		return UserHavingCouponResponseDTO.builder().id(userHavingCoupon.getId()).member(userHavingCoupon.getMember())
				.coupon(userHavingCoupon.getCoupon()).createDate(userHavingCoupon.getCreateDate())
				.expirationDate(userHavingCoupon.getExpirationDate()).build();
	}

	public static List<UserHavingCouponResponseDTO> listOf(List<UserHavingCoupon> userHavingCouponList) {
		return userHavingCouponList.stream().map(UserHavingCouponResponseDTO::of).collect(Collectors.toList());
	}
}
