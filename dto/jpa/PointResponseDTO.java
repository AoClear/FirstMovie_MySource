package kr.co.fmos.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import kr.co.fmos.entity.Member;
import kr.co.fmos.entity.Payment;
import kr.co.fmos.entity.Point;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PointResponseDTO {
	private Long id;
	private Payment payment;
	private Member member;
	private int history;
	private Date date;

	public static PointResponseDTO of(Point point) {
		return PointResponseDTO.builder().id(point.getId()).payment(point.getPayment()).member(point.getMember())
				.history(point.getHistory()).date(point.getDate()).build();
	}

	public static List<PointResponseDTO> listOf(List<Point> pointList) {
		return pointList.stream().map(PointResponseDTO::of).collect(Collectors.toList());
	}
}
