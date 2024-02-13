<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="/css/default.css">
<link rel="stylesheet" href="/css/owl.css">
<link rel="stylesheet" href="/css/swiper.css">
<link rel="stylesheet" href="/css/jquery.mCustomScrollbar.css">
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/content.css">
<link rel="stylesheet" href="/css/content_lc21new.css">
<link rel="stylesheet" href="/css/dev.css">
<link rel="stylesheet" href="/css/ticket_seat.css">

<br>
<div class="wrap_reserve">
	<h2 class="hidden">결제완료</h2>
	<div class="section_step_tit">
		<ul>
			<li class="step01 prev"><a href="#"><strong class="tit"><span>01</span><br>상영시간</strong>
			</a></li>
			<li class="step02 prev"><a href="#"><strong class="tit"><span>02</span><br>인원/좌석</strong>
			</a></li>
			<li class="step03 prev"><a href="#"><strong class="tit"><span>03</span><br>결제</strong>
			</a></li>
			<li class="step04 active"><a href="#"><strong class="tit"><span>04</span><br>결제완료</strong></a></li>
		</ul>
	</div>
	<div id="reserveStep01" class="section_step_con step01 ">
		<h3 class="hidden">상영시간</h3>
	</div>
	<div id="reserveStep02" class="section_step_con step02 ">
		<h3 class="hidden">인원/좌석</h3>
	</div>
	<div id="reserveStep03" class="section_step_con step03 ">
		<h3 class="hidden">결제</h3>
	</div>
	<div id="reserveStep04" class="section_step_con step04 active">
		<h3 class="hidden">결제완료</h3>
		<div class="article article_payment_fin ">
			<div class="group_top">
				<h4 class="tit">결제완료</h4>
			</div>
			<div class="inner">
				<div class="payment_fin_wrap">
					<div class="top_notice_ic ty1">
						<strong>${memberName}님, 결제가 성공적으로 완료되었습니다.</strong>
					</div>
					<div class="reserve_result_wrap">
						<div class="infor_wrap">
							<div class="bx_thm">
								<img src="${movieImage}" alt="노량: 죽음의 바다">
							</div>
							<div class="group_infor">
								<dl>
									<dt>예매번호</dt>
									<dd>
										<strong class="txt_num">${paymentId}</strong>
									</dd>
								</dl>
								<dl>
									<dt>상영일시</dt>
									<dd>
										${movieShowingDate} (${dayOfWeek}) <span>${movieShowingTime}
											~ ${movieEndTime}</span>
									</dd>
									<dt>상영관</dt>
									<dd>${theaterBranchName}${screenLocation}</dd>
									<dt>관람인원</dt>
									<dd>
										<c:if test="${adult ne 0}">
    										성인${adult} 
										</c:if>
										<c:if test="${student ne 0}">
    										청소년${student} 
										</c:if>
										<c:if test="${silver ne 0}">
    										경로${silver} 
										</c:if>
									</dd>
									<dt>좌석</dt>
									<dd>
										<c:forEach items="${selectedSeats}" var="seat"
											varStatus="loop">
											${seat}<c:if test="${not loop.last}">
											</c:if>
										</c:forEach>
									</dd>
								</dl>
								<!-- <button type="button" class="btn_col1 ty5">휴대폰으로 바로티켓
									받기</button> -->
							</div>
						</div>
						<div class="payment_wrap new2020">
							<div class="group_price case1">
								<dl>
									<dt>주문금액</dt>
									<dd>
										<strong>${price}</strong>원
									</dd>
								</dl>
							</div>
							<div class="group_price case2">
								<dl class="minus">
									<dt>할인금액</dt>
									<dd>
										<strong>${payDiscount}</strong>원
									</dd>
								</dl>
							</div>
							<div class="group_price case3">
								<dl>
									<dt>총 결제 금액</dt>
									<dd>
										<strong>${price - payDiscount}</strong>원
									</dd>
								</dl>
								<div class="pay_method">
									<dl class="sml">
										<dt>결제방법</dt>
										<dd class="sml last">${payType}</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<div class="btn_btm_wrap mb50 pb50">
						 <a href="/mypage/payment_detail.do" class="btn_col3 ty5">결제내역</a> 
						 <a href="/product/list.do" class="btn_col2 ty5">스토어 바로가기</a> 
						 <a href="/main" class="btn_col1 ty5">홈으로 바로가기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br>

<%@ include file="../footer.jsp"%>