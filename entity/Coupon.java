package kr.co.fmos.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Table(name = "coupon")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupon_id")
	private Long id;

	@Column(name = "coupon_name", nullable = false)
	private String name;

	@Column(name = "coupon_discount_rate", nullable = false)
	private int discountRate;

	@Column(name = "coupon_expiration_date", nullable = false)
	private int expirationDate;

	@Column(name = "coupon_status", nullable = false)
	private String status;
	
	@OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
	private List<UserHavingCoupon> userHavingCoupons;
}
