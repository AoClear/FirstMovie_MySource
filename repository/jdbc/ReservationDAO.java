package kr.co.fmos.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.fmos.payment.PaymentDAO;
import kr.co.fmos.payment.PaymentDTO;
import kr.co.fmos.paymentSeat.PaymentSeatDAO;
import kr.co.fmos.paymentSeat.PaymentSeatDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional
public class ReservationDAO {
	private final PaymentDAO paymentDao;
	private final PaymentSeatDAO paymentSeatDao;
	private static final Logger logger = LoggerFactory.getLogger(ReservationDAO.class);

	public void insertPaymentSeat(PaymentSeatDTO paymentSeatDto) {
		try {
			paymentSeatDao.insert(paymentSeatDto);
		} catch (Exception e) {
			logger.error("결제 좌석 정보를 삽입하는 도중 오류가 발생했습니다.", e);
			throw new RuntimeException("결제 좌석 정보를 삽입하는 도중 오류가 발생했습니다.", e);
		}
	}

	public PaymentDTO insertPaymentAndReturnWithId(PaymentDTO paymentDto) {
		try {
			PaymentDTO result = paymentDao.insertAndReturnWithId(paymentDto);
			if (result == null) {
				throw new IllegalStateException("결제 정보가 삽입되지 않았습니다.");
			}
			return result;
		} catch (Exception e) {
			logger.error("결제 정보를 삽입하는 도중 오류가 발생했습니다.", e);
			throw new RuntimeException("결제 정보를 삽입하는 도중 오류가 발생했습니다.", e);
		}
	}
}
