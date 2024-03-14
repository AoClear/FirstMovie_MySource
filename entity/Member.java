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
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private int gender;

	@Column(name = "birthdate")
	private String birthdate;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email_check")
	private int emailCheck;

	@Column(name = "sns_check")
	private int snsCheck;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Point> points;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<UserHavingCoupon> userHavingCoupons;
}
