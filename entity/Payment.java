package kr.co.fmos.entity;

import java.util.Date;
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
@Table(name = "payment")
public class Payment {
	@Id
	@Column(name = "payment_id")
	private String paymentId;

	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "movie_information_id", nullable = false)
	private ScreenMovieInfo screenMovieInfo;

	@Column(name = "adult", nullable = false)
	private int adult;

	@Column(name = "student", nullable = false)
	private int student;

	@Column(name = "silver", nullable = false)
	private int silver;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "pay_discount", nullable = false)
	private int discount;

	@Column(name = "refund", nullable = false)
	private boolean refund;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_datetime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date datetime;

	@OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
	private List<Point> points;
}
