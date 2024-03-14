package kr.co.fmos.screenMovieInfo;

import java.util.List;
import java.util.Map;

public interface ScreenMovieInfoDAO {
	public List<ScreenMovieInfoDTO> list();

	public ScreenMovieInfoDTO selectScreenMovieInfoById(String screenMovieInfoID);

	public List<Map<String, Object>> showingTime(Map<String, Object> map);

	public Map<String, Object> detail(String screenMovieInfoID);

	public List<Map<String, Object>> emptySeats(String screenMovieInfoID);

	public List<Map<String, Object>> paymentSeats(String screenMovieInfoID);

	public Map<String, Object> getTicketingInfo(String screenMovieInfoID);
}