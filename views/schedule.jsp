<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="../css/ticketing/common.css" rel="stylesheet"
	type="text/css">
<link href="../css/ticketing/content.css" rel="stylesheet"
	type="text/css">
<link href="../css/ticketing/content_lc2.css" rel="stylesheet"
	type="text/css">
<link href="../css/ticketing/default.css" rel="stylesheet"
	type="text/css">
<link href="../css/ticketing/owl.css" rel="stylesheet" type="text/css">
<link href="../css/ticketing/dev.css" rel="stylesheet" type="text/css">
<link href="../css/ticketing/jquery.mCustomScrollbar.css"
	rel="stylesheet" type="text/css">
<script src="/js/jquery-3.7.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="/js/ticketing_schedule.js"></script>

<div id="loading" class="loader loader-bouncing is-active hidden"></div>
<div class="wrap_reserve" style="margin: 1% auto;">
	<h2 class="hidden">예매하기</h2>
	<div class="section_step_tit">
		<ul>
			<li class="active step01"><a href="#reserveStep01"><strong
					class="tit"><span>01</span><br>상영시간</strong> </a></li>
			<li class="disabled"><a style="cursor: default;"><strong
					class="tit"><span>02</span><br>인원/좌석</strong></a></li>
			<li class="disabled"><a style="cursor: default;"><strong
					class="tit"><span>03</span><br>결제</strong></a></li>
			<li class="disabled"><a style="cursor: default;"><strong
					class="tit"><span>04</span><br>결제완료</strong></a></li>
		</ul>
	</div>
	<div id="reserveStep01" class="section_step_con step01 active">
		<h3 class="hidden">상영시간</h3>
		<div class="article article_cinema area__movingbar litype2">
			<div class="group_top">
				<h4 class="tit selected_branch_name"></h4>
			</div>
			<div class="inner">
				<ul class="tab_wrap outer actionmovingbar">
					<div class="tab_con">
						<div class="cinema_select_wrap cinemaSelect basicCinema">
							<ul>
								<c:forEach items="${regionList}" var="region">
									<li class="depth1"><a href="#none">${region.region} </a>
										<div class="depth2" style="display: none;">
											<div class="mCustomScrollbar">
												<ul>
													<c:forEach items="${theaterBranchList}" var="theaterBranch">
														<c:if
															test="${region.getRegion_id() eq theaterBranch.region_id}">
															<li class="theaterBranchID"
																data-theaterbranchid="${theaterBranch.branch_id}"><a
																href="#none">${theaterBranch.branch_name}</a></li>
														</c:if>
													</c:forEach>
												</ul>
											</div>
										</div></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</ul>
			</div>
		</div>
		<div class="article article_movie">
			<div class="group_top">
				<h4 class="tit selected_movie_name"></h4>
			</div>
			<div class="inner">
				<div class="movie_select_wrap list mCustomScrollbar thm"
					style="display: none;">
					<ul>
						<c:forEach items="${movieList}" var="movie" varStatus="loopStatus">
							<li class="movieID disabled" data-movieid="${movie.movie_id}"><a
								href="#none">
									<div class="bx_thm">
										<span class="rank"><span class="hidden">순위</span><strong>${loopStatus.index + 1}</strong></span><img
											src="${movie.movie_image}" alt="포스터" class="mCS_img_loaded">
									</div>
									<div class="group_infor">
										<div class="bx_tit">
											<c:choose>
												<c:when test="${movie.movie_audience_rating eq '전체'}">
													<span class="ic_grade gr_all">전체 관람가</span>
												</c:when>
												<c:when test="${movie.movie_audience_rating eq '12세'}">
													<span class="ic_grade gr_12">12세 관람가</span>
												</c:when>
												<c:when test="${movie.movie_audience_rating eq '15세'}">
													<span class="ic_grade gr_15">15세 관람가</span>
												</c:when>
												<c:when test="${movie.movie_audience_rating eq '18세'}">
													<span class="ic_grade gr_18">18세 관람가</span>
												</c:when>
											</c:choose>
											<strong class="tit movie_name">${movie.movie_name}</strong>
										</div>
										<span class="sub_info1"><span class="time blacktype"><span
												class="roboto">${movie.movie_running_time}</span>분</span></span>
										<dl>
											<dt>개봉일</dt>
											<dd>${movie.movie_production_year}</dd>
										</dl>
									</div>
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="article article_time area__movingbar litype6">
			<div class="group_top">
				<h4 class="tit">
					<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"
						var="formattedDate" />
					<c:out value="${formattedDate}(오늘)" />
				</h4>
			</div>
			<div class="inner">
				<div class="date_select_wrap dateReserveWrap">
					<div class="slide_wrap slide_reserve_date">
						<ul class="owl-carousel owl-loaded owl-drag">
							<div class="owl-stage-outer">
								<div class="owl-stage"
									style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 735px;">
								</div>
							</div>
						</ul>
					</div>
				</div>
				<div class="tab_con">
					<div class="timeScroll mCustomScrollbar">
						<div class="group_time_select">
							<div class="time_select_tit">
								<span class="ic_grade"></span><strong></strong>
							</div>
							<div class="time_select_wrap timeSelect">
								<ul class="list_time">
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

			<li class="wrap_nav_underline"><span class="nav_underline"></span></li>
			</ul>
		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>