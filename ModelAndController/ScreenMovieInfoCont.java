package kr.co.fmos.screenMovieInfo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/screenMovieInfo")
public class ScreenMovieInfoCont {
	public ScreenMovieInfoCont() {
		System.out.println("-----ScreenMovieInfoCont() 객체 생성됨");
	}

	@Autowired
	ScreenMovieInfoDAO screenMovieInfoDao;

	@PostMapping("/selectScreenMovieInfoById")
	public ScreenMovieInfoDTO selectScreenMovieInfoById(@RequestParam String screenMovieInfoID) {
		return screenMovieInfoDao.selectScreenMovieInfoById(screenMovieInfoID);
	}

	@PostMapping("/showingTime")
	@ResponseBody
	public List<Map<String, Object>> showingTime(@RequestBody Map<String, Object> map) {
		return screenMovieInfoDao.showingTime(map);
	}

	@PostMapping("/emptySeats")
	@ResponseBody
	public List<Map<String, Object>> emptySeats(@RequestBody String screenMovieInfoID) {
		return screenMovieInfoDao.emptySeats(screenMovieInfoID);
	}

	@PostMapping("/paymentSeats")
	@ResponseBody
	public List<Map<String, Object>> paymentSeats(@RequestBody String screenMovieInfoID) {
		System.out.println("paymentSeats");
		return screenMovieInfoDao.paymentSeats(screenMovieInfoID);
	}
}