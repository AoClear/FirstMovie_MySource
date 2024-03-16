package kr.co.fmos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.fmos.dto.PaymentSeatRequestDTO;
import kr.co.fmos.repository.PaymentSeatRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentSeatService {
	private final PaymentSeatRepository paymentSeatRepository;

	@Transactional
	public void insertPaymentSeat(PaymentSeatRequestDTO requestDTO) {
		
	}
}
