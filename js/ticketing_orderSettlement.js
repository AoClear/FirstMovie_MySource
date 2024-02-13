const currentUrl = new URL(window.location.href);
const screenMovieInfoID = decodeURIComponent(currentUrl.searchParams.get('screenMovieInfoID'));
const selectedSeats = JSON.parse(decodeURIComponent(currentUrl.searchParams.get('selectedSeats')));
const adult = decodeURIComponent(currentUrl.searchParams.get('adult'));
const student = decodeURIComponent(currentUrl.searchParams.get('student'));
const silver = decodeURIComponent(currentUrl.searchParams.get('silver'));
const price = decodeURIComponent(currentUrl.searchParams.get('price'));

let memberID;
let movieName;
let movieAudienceRating;
let movieImage;
let movieRunningTime;
let movieShowingDate;
let movieShowingTime;
let theaterBranchName;
let screenLocation;
let couponDiscountRate = 0;
let selectedCouponID;
let usedPoint = 0;
let payDiscount = 0;

$(document).ready(function() {
	initialize();
});

function initialize() {
	// mCustomScrollbar 초기화 및 옵션 설정
	initializeCustomScrollbar();

	//최종 결제수단
	//handlePaymentButtonClick();

	//상세 결제수단
	//handlePayItemClick();

	//약관 동의
	handleProvisionCheckboxChange();

	//쿠폰사용하기 버튼클릭
	handleApplyCouponButtionClick();

	//사용 가능 쿠폰 목록
	handleCouponCheckboxChange();

	//쿠폰 사용 등록
	handleCouponSubmitButtonClick();

	//사용 포인트값 저장
	handlePointAmountInput();

	//쿠폰 취소
	handleCouponCancleButtonClick();

	//등록한 쿠폰 취소 버튼
	handleCouponCloseButtonClick();

	//결제 불가
	showPaymentWarning();

	//최종결제
	handlePaymentConfirmButtonClick();
}

function initializeCustomScrollbar() {
	$(".mCustomScrollbar").mCustomScrollbar({
		theme: "dark-thin", // 테마 설정 (dark 또는 light)
		scrollButtons: {
			enable: true
		}, // 스크롤 버튼 활성화
		scrollInertia: 300, // 스크롤 속도
	});
}

function printPrice() {
	payDiscount = Math.round(price * (couponDiscountRate / 100)) + usedPoint;
	$('.discount_amount strong').text(payDiscount.toLocaleString());
	$('.total_price strong').text((price - payDiscount).toLocaleString());
}

function handlePaymentButtonClick() {
	$('.bx_cate li>button').click(function() {
		// 모든 li 요소에서 'selected' 클래스를 제거
		$('.bx_cate li>button').removeClass('active');

		// 클릭된 li 요소에 'selected' 클래스 추가
		$(this).addClass('active');

		//신용카드 클릭시
		if ($('.bx_cate .pay_card').hasClass('active')) {
			// active 클래스가 있다면 article 클래스를 가진 요소를 보이게 함
			$('.pay_method_list .article_pay_card').css('display', 'block');
		} else {
			// active 클래스가 없다면 article 클래스를 가진 요소를 숨김
			$('.pay_method_list .article_pay_card').css('display', 'none');
		}

		//간편결재 클릭시
		if ($('.bx_cate .pay_simple').hasClass('active')) {
			// active 클래스가 있다면 article 클래스를 가진 요소를 보이게 함
			$('.pay_method_list .article_pay_simple').css('display', 'block');
		} else {
			// active 클래스가 없다면 article 클래스를 가진 요소를 숨김
			$('.pay_method_list .article_pay_simple').css('display', 'none');
		}
	});
}

function handlePayItemClick() {
	$('.pay_method_list button').click(function() {
		$('.pay_method_list li').removeClass('active');
		$(this).parent().closest('li').addClass('active');
	});
}

function handleProvisionCheckboxChange() {
	$('#chkSavingTerm').change(function() {
		//약관 모두 동의
		if ($(this).is(':checked')) {
			$('.provision_list input[type="checkbox"]').prop('checked', true);
			// 체크되었을 때 수행할 동작을 여기에 추가
		} else {
			$('.provision_list input[type="checkbox"]').prop('checked', false);
			// 체크 해제되었을 때 수행할 동작을 여기에 추가
		}
	});

	$('.provision_list input[type="checkbox"]').click(function() {
		const checkbox = $('.provision_list input[type="checkbox"]');

		// 체크박스들 중 모두 체크되어 있는지 확인
		const someUnchecked = checkbox.filter(':checked').length === checkbox.length;

		// 모든 체크박스의 체크 상태를 토글
		$('#chkSavingTerm').prop('checked', someUnchecked);
	});
}

function handleApplyCouponButtionClick() {
	$('.btn_coupon').click(function() {
		$('.dim').css('display', 'block');
		$('#layerDiscountCoupon').addClass('active');
	});
}

function handleCouponCheckboxChange() {
	$('.list_pay_coupon input[type="checkbox"]').change(function() {
		// 모든 체크박스의 체크를 해제
		$('.list_pay_coupon input[type="checkbox"]').prop('checked', false);
		// 현재 선택된 체크박스만 체크
		$(this).prop('checked', true);
	});
}

function handleCouponSubmitButtonClick() {
	$('#layerDiscountCoupon .submit').click(function() {
		//선택된 쿠폰이 없으면 아무것도 표기하지않음
		if ($('.list_pay_coupon input[type="checkbox"]:checked').length === 0) {
			$('.dim').css('display', 'none');
			return;
		}

		//사용 쿠폰 선택창 닫기
		$('.dim').css('display', 'none');
		$('#layerDiscountCoupon').removeClass('active');

		//체크한 쿠폰을 등록시 페이지에 표기
		$('.wrap_selected_coupon').css('display', 'block');
		const checkedBox = $('.list_pay_coupon input[type="checkbox"]:checked').closest('li');
		const couponName = checkedBox.find('.coupon_name').text();
		const couponPeriod = checkedBox.find('.period').text();
		const couponConstraints = checkedBox.find('dt').text();
		selectedCouponID = checkedBox.data("couponid");
		couponDiscountRate = checkedBox.data("coupondiscountrate");

		$('.wrap_selected_coupon .coupon_name').text(couponName);
		$('.wrap_selected_coupon .period').text(couponPeriod);
		$('.wrap_selected_coupon dt').text(couponConstraints);

		printPrice();
	});
}

function handleCouponCancleButtonClick() {
	$('#layerDiscountCoupon .cancle').click(function() {
		$('.dim').css('display', 'none');
		$('#layerDiscountCoupon').removeClass('active');
	});
}

function handlePointAmountInput() {
	$(".point_amount").on("input", function() {
		const enteredPoints = $(this).val();

		//비어있으면 사용포인트 변수에 0할당
		if (enteredPoints.trim() === "") {
			usedPoint = 0;
		}
		//입력 포인트가 사용자 보유포인트 초과시 사용자 보유포인트 값으로 변경
		else if (enteredPoints > memberPoint) {
			usedPoint = memberPoint;
			$(this).val(memberPoint);
		}
		//입력 값을 양수로 제한
		else {
			usedPoint = parseInt(enteredPoints.replace(/[^0-9.]/g, ''), 10) || '';
		}

		printPrice();
	});
}

function showPaymentWarning() {
	$('.provision input[type="checkbox"]').on('change', showPaymentWarningProcess);

	function showPaymentWarningProcess() {
		const provisionCheckboxes = $('.provision_list input[type="checkbox"]');
		if (provisionCheckboxes.length === provisionCheckboxes.filter(':checked').length) {
			$('.payment_disabled').text("");
			$('.pay_button').removeClass("disabled");
		}
		else {
			$('.payment_disabled').text("결제를 진행할 수 없습니다.");
			$('.pay_button').addClass("disabled");
		}
	}
}

function handlePaymentConfirmButtonClick() {
	$('.pay_button').click(function() {
		IMP.init("imp14397622");
		IMP.request_pay({
			pg: "html5_inicis",  // PG사
			pay_method: "card",  // 결제 수단
			merchant_uid: "FirstMovie_" + screenMovieInfoID + new Date().getTime(), // 주문번호
			name: "first movie_" + movieName,  // 상품명
			amount: 100,//price - payDiscount,  // 결제 금액
			buyer_name: memberID
		}, function(rsp) {
			if (rsp.success) {
				payment_id = rsp.merchant_uid;
				postPaysuccess();
			} else {
				alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
			}
		});

		function postPaysuccess() {
			// 새로운 폼 엘리먼트 생성
			let form = document.createElement('form');

			// 폼 속성 설정 (페이지 URL과 전송 방식 설정)
			form.action = '/ticketing/paysuccess'; // 대상 페이지 URL
			form.method = 'post';

			// 폼에 전송할 데이터 추가 (키-값 쌍 형식)
			addFormField(form, 'payment_id', payment_id);
			addFormField(form, 'screenMovieInfoID', screenMovieInfoID);
			addFormField(form, 'adult', adult);
			addFormField(form, 'student', student);
			addFormField(form, 'silver', silver);
			addFormField(form, 'price', price);
			addFormField(form, 'payDiscount', payDiscount);
			addFormField(form, 'selectedSeats', selectedSeats);
			// ... 원하는 만큼 필드 추가

			// 폼을 문서에 추가하고 자동으로 제출
			document.body.appendChild(form);
			form.submit();

			// 폼에 필드를 추가하는 함수
			function addFormField(form, name, value) {
				let input = document.createElement('input');
				input.type = 'hidden';
				input.name = name;
				input.value = value;
				form.appendChild(input);
			}
		}
	});
}

function handleCouponCloseButtonClick() {
	$('.wrap_selected_coupon .btn_close').click(function() {
		$('.wrap_selected_coupon').css('display', 'none');
		selectedCouponID = undefined;
		couponDiscountRate = 0;
	});
}
