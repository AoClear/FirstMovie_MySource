package kr.co.fmos.screenMovieInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScreenMovieInfoDAOImp implements ScreenMovieInfoDAO {

	public ScreenMovieInfoDAOImp() {
		System.out.println("-----screenMovieInfoDAOImp() 객체 생성됨");
	}

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ScreenMovieInfoDTO> list() {
		return sqlSession.selectList("screenMovieInfo.list");
	}// list() end

	@Override
	public List<Map<String, Object>> showingTime(Map<String, Object> map) {
		return sqlSession.selectList("screenMovieInfo.showingTime", map);
	}// showingTime() end

	@Override
	public Map<String, Object> detail(String screenMovieInfoID) {
		return sqlSession.selectOne("screenMovieInfo.detail", screenMovieInfoID);
	}

	@Override
	public List<Map<String, Object>> emptySeats(String screenMovieInfoID) {
		return sqlSession.selectList("screenMovieInfo.emptySeats", screenMovieInfoID);
	}
	
	@Override
	public ScreenMovieInfoDTO selectScreenMovieInfoById(String screenMovieInfoID) {
		return sqlSession.selectOne("screenMovieInfo.selectScreenMovieInfoById", screenMovieInfoID);
	}// selectScreenMovieInfoById() end
	
	@Override
	public List<Map<String, Object>> paymentSeats(String screenMovieInfoID) {
		return sqlSession.selectList("screenMovieInfo.paymentSeats", screenMovieInfoID);
	}
	
	@Override
	public Map<String, Object> getTicketingInfo(String screenMovieInfoID){
		return sqlSession.selectOne("screenMovieInfo.getTicketingInfo", screenMovieInfoID); 
	}
}
