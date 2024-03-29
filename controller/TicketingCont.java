package kr.co.fmos.ticketing;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import kr.co.fmos.coupon.UserHavingCouponDAO;
import kr.co.fmos.dto.PointResponseDTO;
import kr.co.fmos.dto.UserHavingCouponResponseDTO;
import kr.co.fmos.member.MemberDAO;
import kr.co.fmos.member.MemberDTO;
import kr.co.fmos.movie.MovieDAO;
import kr.co.fmos.movie.MovieDTO;
import kr.co.fmos.payment.PaymentDAO;
import kr.co.fmos.payment.PaymentDTO;
import kr.co.fmos.paymentSeat.PaymentSeatDAO;
import kr.co.fmos.paymentSeat.PaymentSeatDTO;
import kr.co.fmos.point.PointDAO;
import kr.co.fmos.region.RegionDAO;
import kr.co.fmos.reservation.ReservationDAO;
import kr.co.fmos.screen.ScreenDAO;
import kr.co.fmos.screen.ScreenDTO;
import kr.co.fmos.screenMovieInfo.ScreenMovieInfoDAO;
import kr.co.fmos.screenMovieInfo.ScreenMovieInfoDTO;
import kr.co.fmos.service.MovieService;
import kr.co.fmos.service.PointService;
import kr.co.fmos.service.RegionService;
import kr.co.fmos.service.ScreenMovieInfoService;
import kr.co.fmos.service.TheaterBranchService;
import kr.co.fmos.service.UserHavingCouponService;
import kr.co.fmos.theaterBranch.TheaterBranchDAO;
import kr.co.fmos.theaterBranch.TheaterBranchDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ticketing")
public class TicketingCont {

	private final HttpSession session;
	private final RegionService regionService;
	private final TheaterBranchService theaterBranchService;
	private final TheaterBranchDAO theaterBranchDao;
	private final MovieService movieService;
	private final MovieDAO movieDao;
	private final ScreenMovieInfoDAO screenMovieInfoDao;
	private final ScreenMovieInfoService screenMovieInfoService;
	private final UserHavingCouponDAO userHavingCouponDao;
	private final UserHavingCouponService userHavingCouponService;
	private final PaymentDAO paymentDao;
	private final ScreenDAO screenDao;
	private final MemberDAO memberDao;
	private final PaymentSeatDAO paymentSeatDao;
	private final PointService pointService;
	private final ReservationDAO reservationDao;

	@GetMapping("/schedule")
	public ModelAndView schedule() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ticketing/schedule");
		mav.addObject("regionList", regionService.listAllRegion());
		mav.addObject("theaterBranchList", theaterBranchService.listAllTheaterBranch());
		mav.addObject("movieList", movieService.listAllMovie());
		mav.addObject("screenMovieInfoList", screenMovieInfoService.listAllScreenMovieInfo());
		mav.addObject("now", new Date());
		return mav;
	}

	@GetMapping("/personseat")
	public ModelAndView personseat(@RequestParam String screenMovieInfoID, int remainSeatCount) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("screenMovieInfo", screenMovieInfoDao.detail(screenMovieInfoID));
		mav.addObject("remainSeatCount", remainSeatCount);
		mav.setViewName("ticketing/personseat");
		return mav;
	}

	@GetMapping("/orderSettlement")
	public ModelAndView orderSettlement(@RequestParam String screenMovieInfoID, @RequestParam int price,
			@RequestParam String selectedSeats, @RequestParam int adult, @RequestParam int student,
			@RequestParam int silver) {
		ModelAndView mav = new ModelAndView();
		
		// 현재 로그인된 세션ID
		String sessionID = (String) session.getAttribute("s_id").toString();

		// 예매 정보
		Map<String, Object> ticketingInfo = screenMovieInfoDao.getTicketingInfo(screenMovieInfoID);

		// 선택 좌석 JSON 문자열 파싱 및 정렬
		String decodedSeats = null;
		try {
			decodedSeats = URLDecoder.decode(selectedSeats, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String[] selectedSeatsArray = decodedSeats.replaceAll("[\\[\\]\"]", "").split(",");
		Arrays.sort(selectedSeatsArray, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				char alphaA = a.charAt(0);
				char alphaB = b.charAt(0);
				int numA = Integer.parseInt(a.substring(1));
				int numB = Integer.parseInt(b.substring(1));

				if (alphaA == alphaB) {
					return Integer.compare(numA, numB);
				} else {
					return Character.compare(alphaA, alphaB);
				}
			}
		});

		mav.setViewName("ticketing/orderSettlement");
		mav.addObject("ticketingInfo", ticketingInfo);
		mav.addObject("selectedSeats", selectedSeatsArray);
		mav.addObject("adult", adult);
		mav.addObject("student", student);
		mav.addObject("silver", silver);
		mav.addObject("userHavingCouponList", userHavingCouponService.getUserHavingCouponByMemberId(sessionID));
		mav.addObject("point", pointService.getTotalPointByMemberId(sessionID));
		mav.addObject("price", price);
		return mav;
	}

	@PostMapping("/paysuccess")
	public ModelAndView paysuccess(@RequestParam String payment_id, @RequestParam String screenMovieInfoID,
			@RequestParam int adult, @RequestParam int student, @RequestParam int silver, @RequestParam int price,
			@RequestParam int payDiscount, @RequestParam String[] selectedSeats) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ticketing/paysuccess");

		// Payment테이블 행 추가 후 그 행 가져오기
		PaymentDTO paymentDto = new PaymentDTO();
		paymentDto.setPayment_id(payment_id);
		paymentDto.setMember_id((String) session.getAttribute("s_id"));
		paymentDto.setMovie_information_id(screenMovieInfoID);
		paymentDto.setAdult(adult);
		paymentDto.setStudent(student);
		paymentDto.setSilver(silver);
		paymentDto.setPrice(price);
		paymentDto.setPay_discount(payDiscount);
		paymentDto.setRefund(1);
		PaymentDTO inputPaymentDto = reservationDao.insertPaymentAndReturnWithId(paymentDto);

		// 정보 불러오기
		ScreenMovieInfoDTO screenMovieInfo = screenMovieInfoDao.selectScreenMovieInfoById(screenMovieInfoID);
		MovieDTO movie = movieDao.selectMovieInfoById(String.valueOf(screenMovieInfo.getMovie_id()));
		TheaterBranchDTO theaterBranch = theaterBranchDao
				.selectTheaterBranchById(String.valueOf(screenMovieInfo.getBranch_id()));
		ScreenDTO screen = screenDao.selectScreenById(String.valueOf(screenMovieInfo.getScreen_id()));
		MemberDTO member = memberDao.selectMemberById((String) session.getAttribute("s_id"));

		// 결제완료된 좌석테이블에 행 추가
		for (String seat : selectedSeats) {
			PaymentSeatDTO paymentSeatDto = new PaymentSeatDTO();
			paymentSeatDto.setPayment_id(payment_id);
			paymentSeatDto.setSeat_x(Integer.parseInt(seat.substring(1)));
			paymentSeatDto.setSeat_y(seat.charAt(0) - 64);
			reservationDao.insertPaymentSeat(paymentSeatDto);
		}

		mav.addObject("memberName", member.getMember_name());
		mav.addObject("paymentId", inputPaymentDto.getPayment_id());
		mav.addObject("movieImage", movie.getMovie_image());
		mav.addObject("movieShowingDate", screenMovieInfo.getMovie_showing_date());
		mav.addObject("dayOfWeek", screenMovieInfo.getMovie_showing_date().getDayOfWeek()
				.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
		mav.addObject("movieShowingTime", screenMovieInfo.getMovie_showing_time());
		mav.addObject("movieEndTime",
				screenMovieInfo.getMovie_showing_time().plusMinutes(movie.getMovie_running_time()));
		mav.addObject("theaterBranchName", theaterBranch.getBranch_name());
		mav.addObject("screenLocation", screen.getScreen_location());
		mav.addObject("adult", adult);
		mav.addObject("student", student);
		mav.addObject("silver", silver);
		mav.addObject("selectedSeats", selectedSeats);
		mav.addObject("price", price);
		mav.addObject("payDiscount", payDiscount);

		return mav;
	}
}
