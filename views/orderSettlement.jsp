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
<link href="../css/ticketing/my_style.css" rel="stylesheet"
	type="text/css">
<link href="../css/ticketing/jquery.mCustomScrollbar.css"
	rel="stylesheet" type="text/css">
<script src="/js/jquery-3.7.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="/js/ticketing_orderSettlement.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
	const memberPoint = ${point};
</script>

<div class="wrap_reserve" style="margin: 1% auto;">
	<h2 class="hidden">예매하기</h2>
	<div class="section_step_tit">
		<ul>
			<li class="step01 prev"><a href="/ticketing/schedule"><strong
					class="tit"><span>01</span><br>상영시간</strong> </a></li>
			<li class="step02 prev"><a
				href="javascript:window.history.back();"><strong class="tit"><span>02</span><br>인원/좌석</strong>
			</a></li>
			<li class="step03 active"><a href="#"><strong class="tit"><span>03</span><br>결제</strong>
			</a></li>
			<li><a href="#" style="cursor: default;"><strong class="tit"><span>04</span><br>결제완료</strong></a></li>
		</ul>
	</div>
	<div id="reserveStep01" class="section_step_con step01 ">
		<h3 class="hidden">상영시간</h3>
	</div>
	<div id="reserveStep02" class="section_step_con step02 ">
		<h3 class="hidden">인원/좌석</h3>
	</div>
	<div id="reserveStep03" class="section_step_con step03 active">
		<h3 class="hidden">결제</h3>
		<div class="article article_sum_infor">
			<div class="group_top">
				<h4 class="tit">예매정보</h4>
			</div>
			<div class="inner">
				<div class="movie_infor new2020">
					<span class="thm"><img src="${ticketingInfo.movie_image}"></span><strong
						class="tit"><span
						class="ic_grade ${ticketingInfo.movie_audience_rating eq '전체' ? 'gr_all' : (ticketingInfo.movie_audience_rating eq '12세' ? 'gr_12' : (ticketingInfo.movie_audience_rating eq '15세' ? 'gr_15' : (ticketingInfo.movie_audience_rating eq '18세' ? 'gr_18' : '')))}"></span>&nbsp;${ticketingInfo.movie_name}</strong>
					<dl class="dlist_infor">
						<dt>일시</dt>
						<dd>
							<strong>${ticketingInfo.movie_showing_date}
								(${ticketingInfo.day_of_week})
								${ticketingInfo.movie_showing_time} ~
								${ticketingInfo.movie_end_time}</strong>
						</dd>
						<dt>영화관</dt>
						<dd>${ticketingInfo.branch_name}
							${ticketingInfo.screen_location}</dd>
						<dt>인원</dt>
						<dd>
							<c:if test="${adult > 0}">성인${adult} </c:if>
							<c:if test="${student > 0}">청소년${student} </c:if>
							<c:if test="${silver > 0}">경로${silver}</c:if>
						</dd>
					</dl>
				</div>
				<div class="seat_infor">
					<dl class="dlist_infor">
						<dt>좌석</dt>
						<dd>
							<strong><c:forEach var="seat" items="${selectedSeats}"
									varStatus="loop">
									<c:out value="${seat}" />
									<c:if test="${!loop.last}">
									</c:if>
								</c:forEach></strong>
						</dd>
					</dl>
				</div>
			</div>
		</div>
		<div class="article article_pay_method">
			<div class="group_top">
				<h4 class="tit">결제수단</h4>
			</div>
			<div class="inner">
				<div class="group_discount" style="display: block;">
					<h3 class="tit_payment">쿠폰</h3>
					<div class="wrap_coupon">
						<button class="btn_coupon">쿠폰 사용하기</button>
						<div class="wrap_selected_coupon" style="display: none;">
							<button type="button" class="btn_close">팝업 닫기</button>
							<div class="coupon_name">(쿠폰명)</div>
							<dl>
								<dd class="period">(사용기간)</dd>
							</dl>
						</div>
					</div>
					<h3 class="tit_payment">포인트</h3>
					<div class="remain_point">잔여 포인트 : ${point}</div>
					<input class="point_amount" type="number" placeholder="사용할 포인트 입력">
				</div>
			</div>
		</div>
		<div class="article article_payment">
			<div class="group_top">
				<h4 class="tit">결제하기</h4>
			</div>
			<div class="inner">
				<div class="select_item_wrap">
					<div class="group_item provision active">
						<div class="bx_item">
							<input type="checkbox" id="chkSavingTerm"><label
								for="chkSavingTerm" class="ty2">결제대행서비스 약관 동의</label>
						</div>
						<div class="group_side">
							<div class="bx_provision">
								<ul class="provision_list">
									<li><input type="checkbox" id="chkProvisionTerm01"><label
										for="chkProvisionTerm01" class="ty2">전자금융거래 이용약관 동의</label>
										<button class="btn_txt_more ty2">약관보기</button></li>
									<li><input type="checkbox" id="chkProvisionTerm02"><label
										for="chkProvisionTerm02" class="ty2">고유식별정보 수집 및 이용안내</label>
										<button class="btn_txt_more ty2">약관보기</button></li>
									<li><input type="checkbox" id="chkProvisionTerm03"><label
										for="chkProvisionTerm03" class="ty2">개인정보 수집 및 이용동의</label>
										<button class="btn_txt_more ty2">약관보기</button></li>
									<li><input type="checkbox" id="chkProvisionTerm04"><label
										for="chkProvisionTerm04" class="ty2">개인정보 제3자 제공/위탁동의</label>
										<button class="btn_txt_more ty2">약관보기</button></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="payment_sum_wrap">
					<dl>
						<div class="payment_disabled">결제를 진행할 수 없습니다.</div>
					</dl>
					<dl>
						<dt>상품금액</dt>
						<dd class="price">
							<strong><fmt:formatNumber value="${price}"
									pattern="#,##0" /></strong>원
						</dd>
					</dl>
					<dl>
						<dt>할인금액</dt>
						<dd class="discount_amount">
							-<strong>0</strong>원
						</dd>
					</dl>
					<dl>
						<dt>결제금액</dt>
						<dd class="total_price">
							총<strong><fmt:formatNumber value="${price}"
									pattern="#,##0" /></strong>원
						</dd>
					</dl>

					<a class="btn_col1 btn_confirm pay_button disabled">결제하기</a>

				</div>
			</div>
		</div>
		<div id="layerDiscountCoupon" class="layer_wrap layer_discount_Coupon">
			<strong class="hidden">레이어 팝업 시작</strong>
			<div class="layer_header">
				<h1 class="tit" id="popup_discount_title_A300">쿠폰</h1>
				<button type="button" class="btn_close">팝업 닫기</button>
			</div>
			<div class="layer_contents">
				<div class="fieldset_wrap" id="popup_discount_content_A300">
					<div class="fieldset_box">
						<div class="tit_area">
							<strong>사용 가능한 쿠폰<em id="counpon_rest_count">(${fn:length(userHavingCouponList)})
							</em></strong>
						</div>
						<c:choose>
							<c:when test="${empty userHavingCouponList}">
								<div class="nodata" style="display: block;">사용 가능한 할인권이
									없습니다.</div>
							</c:when>
							<c:otherwise>
								<div class="pay_coupon_list_wrap mCustomScrollbar">
									<ul class="list_pay_coupon">
										<c:forEach items="${userHavingCouponList}"
											var="userHavingCoupon" varStatus="loop">
											<li class="coupon"
												data-couponid="${userHavingCoupon.coupon_id}" data-coupondiscountrate="${userHavingCoupon.coupon_discount_rate}"><input
												type="checkbox" id="chkpay_coupon${loop.count}"><label
												for="chkpay_coupon${loop.count}" class="ty2">
													<div class="coupon_name">${userHavingCoupon.coupon_name}</div>
													<dl>
														<dd class="period">
															<fmt:formatDate
																value="${userHavingCoupon.coupon_create_date}"
																pattern="yyyy-MM-dd" />
															~
															<fmt:formatDate
																value="${userHavingCoupon.coupon_expiration_date}"
																pattern="yyyy-MM-dd" />
														</dd>
													</dl>
											</label></li>
										</c:forEach>
									</ul>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="btn_btm_wrap ty2">
					<a href="#" role="button" class="cancle btn_col3 ty6">취소</a><a
						href="#" role="button" class="submit btn_col2 ty6">등록</a>
				</div>
			</div>
		</div>
	</div>
	<div class="dim ty2" style="position: fixed; display: none;"></div>
</div>
<div id="reserveStep04" class="section_step_con step04 ">
	<h3 class="hidden">결제완료</h3>
</div>

<%@ include file="../footer.jsp"%>