package kr.co.fmos.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Table(name = "point")
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "point_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "payment_id", nullable = false)
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@Column(name = "point_history", nullable = false)
	private int history;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "point_date", nullable = false)
	private Date date;
}
