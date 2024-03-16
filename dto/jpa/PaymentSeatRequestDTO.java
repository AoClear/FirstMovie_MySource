package kr.co.fmos.dto;

import kr.co.fmos.entity.Payment;
import kr.co.fmos.entity.PaymentSeat;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentSeatRequestDTO {
	private Payment payment;
	private int seatX;
	private char seatY;
	
	public PaymentSeat toEntity() {
	        return PaymentSeat.builder()
	                .payment(payment)
	                .seatX(seatX)
	                .seatY(seatY)
	                .build();
	    }
}
