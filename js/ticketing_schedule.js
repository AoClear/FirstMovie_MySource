let selectedTheaterBranchID;
let selectedMovieID;
let selectedDate = formatDate(new Date());

$(document).ready(function() {
	initialize();
});

function initialize() {
	// mCustomScrollbar 초기화 및 옵션 설정
	initializeCustomScrollbar();

	//지역명 클릭
	handleRegionListClick();

	//지점명 클릭
	handleBrunchListClick();

	//영화 클릭
	handleMovieListClick();

	//날짜 표기부분 오늘로 초기화
	initializeDateToday();

	//날짜 클릭시
	handleDateRadioClick();

	//상영 시간 표시
	showingTime();
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

function handleRegionListClick() {
	$('.cinemaSelect .depth1').click(function() {
		event.stopPropagation(); // 이벤트 전파 중지

		// 지역 선택 표시
		$('.cinemaSelect .depth1').removeClass('active');
		$(this).addClass('active');

		// 선택한 지역에 포함된 지점명들 표시
		$('.depth2').css('display', 'none');
		$(this).find('.depth2').css('display', 'block');

		// 영화 목록 표시
		$('.movie_select_wrap').css('display', 'none');
		$('.timeScroll').css('display', 'none');

		//상단 지점명, 영화 목록 표기 삭제
		$('.selected_branch_name').empty();
		$('.selected_movie_name').empty();

		//선택한 지점 선택취소
		$('.cinemaSelect .depth2 li').removeClass();
		//선택한 영화 선택취소
		$('.movie_select_wrap li').removeClass('active');
	});
}

function handleBrunchListClick() {
	$('.cinemaSelect .depth2 li').click(function() {
		event.stopPropagation(); // 이벤트 전파 중지

		//지점 선택 표시
		$('.cinemaSelect .depth2 li').removeClass();
		$(this).addClass('active');

		//선택한 지점 저장
		selectedTheaterBranchID = $(this).data("theaterbranchid");

		//상단에 선택 지점명 표시
		$('.selected_branch_name').text($(this).text());

		//영화 목록 표시
		$('.movie_select_wrap').css('display', 'block');
	});
}

function handleMovieListClick() {
	$('.movie_select_wrap li').click(
		function() {
			//선택한 영화 표시
			$(".movie_select_wrap li").removeClass("active")
				.addClass("disabled");
			$(this).removeClass("disabled").addClass("active");

			//상영 시간 표시
			$('.timeScroll').css('display', 'block');

			//선택한 영화 저장
			selectedMovieID = $(this).data("movieid");

			//상영 시간 구역에 표시할 영화제목
			let movieGrade = $(".movie_select_wrap .active .ic_grade").attr("class");
			let movieName = $(".movie_select_wrap .active .tit").text();

			//상영 시간 표시 부분에 선택한 영화 표시
			$(".time_select_tit .ic_grade").removeClass().addClass(movieGrade);
			$(".time_select_tit strong").text(movieName);

			//상단에 선택한 영화명 표시
			$('.selected_movie_name').text($(this).find('.movie_name').text());
		});
}

function initializeDateToday() {
	// 오늘 날짜 객체 생성
	const today = new Date();

	// 요일을 가져오기 위한 배열
	const weekdays = ["일", "월", "화", "수", "목", "금", "토"];
	const dayOfWeek = weekdays[today.getDay()]; // 요일 가져오기
	const formattedDate = formatDate(today) + "(" + dayOfWeek + ")";

	for (let i = 0; i <= 7; i++) {
		// 현재 날짜를 생성
		const currentDate = new Date();

		// 현재 날짜에 i일을 더함
		const futureDate = new Date(currentDate.getTime() + i * 24 * 60 * 60 * 1000);

		//요일 표시
		let playweek = "";
		if (i === 0) {
			playweek = "오늘";
		}
		else {
			playweek = weekdays[futureDate.getDay()];
		}

		//토, 일의 css
		let weekStyle = "";
		if (playweek === "토") {
			weekStyle = "sat";
		} else if (playweek === "일") {
			weekStyle = "sun";
		}

		let htmlContent = '<div class="owl-item active" style="width: 52.5px;">' +
			'<li class="item">';

		//오늘 부분에 이번달 표시
		if (i === 0) {
			htmlContent += '<strong class="month">' + (futureDate.getMonth() + 1) + '월' + '</strong>';
		}

		//다음달 첫날 부분에 다음달 표시
		if (futureDate.toDateString() === new Date(today.getFullYear(), today.getMonth() + 1, 1).toDateString()) {
			htmlContent += '<strong class="month">' + (futureDate.getMonth() + 1) + '월' + '</strong>';
		}

		htmlContent +=
			'<a href="#none" class="date ' + weekStyle + '"><label for="radioDate' + i + '">' +
			'<input type="radio" id="radioDate' + i + '" name="radioDate1"' +
			'data-displayyn="Y" data-playdate="' + formatDate(futureDate) + '"' +
			'data-isplaydate="Y" data-playweek="' + playweek + '" checked=""><strong>' + futureDate.getDate() + '</strong><em>' + playweek + '</em></label></a></li>' +
			'</div >';

		//날짜 화면 출력
		$(".article_time .owl-stage").append(htmlContent);
		//오늘 날짜 선택
		$('input[name="radioDate1"][data-playweek="오늘"]').prop('checked', true);
	}
}

// 날짜 포맷팅 함수
function formatDate(date) {
	const year = date.getFullYear();
	const month = padZero(date.getMonth() + 1);
	const day = padZero(date.getDate());
	return year + '-' + month + '-' + day;
}

// 숫자를 두 자리로 만들어주는 함수
function padZero(num) {
	return num < 10 ? '0' + num : num;
}

function handleDateRadioClick() {
	$('input[name="radioDate1"]').on('change', function() {
		$('.article_time .tit').text($(this).data("playdate") + "(" + $(this).data("playweek") + ")");
		selectedDate = $(this).data("playdate");
	});
}

function showingTime() {
	//날짜 클릭시
	$('input[name="radioDate1"]').on('change', showingTimeProcess);
	//영화 클릭
	$('.movie_select_wrap li').click(showingTimeProcess);
	//지점명 클릭
	$('.cinemaSelect .depth2 li').click(showingTimeProcess);

	function showingTimeProcess() {
		if (selectedTheaterBranchID === undefined || selectedMovieID === undefined) {
			return;
		}

		$(".list_time").empty();
		const showingTimeParam = {
			branchID: selectedTheaterBranchID,
			movieID: selectedMovieID,
			showingDate: selectedDate
		};

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/screenMovieInfo/showingTime",
			data: JSON.stringify(showingTimeParam),
			success: function(data) {
				$.each(data, function(index, showingTimeInfo) {
					let htmlContent = '<li class="screenMovieInfo';

					const screenSeatCount = showingTimeInfo.screen_row * showingTimeInfo.screen_line - showingTimeInfo.none_exist_seats_count;
					let remainSeatCount = screenSeatCount - showingTimeInfo.payment_count;

					if (remainSeatCount <= 0) {
						htmlContent += ' disabled';
						remainSeatCount = 0;
					}

					htmlContent += '" data-screenmovieinfoid = ' + showingTimeInfo.movie_information_id + ' data-remainSeatCount=' + remainSeatCount + '>' +
						'<a role="button" href="#none"><dl>' +
						'<dt>상영시간</dt>' +
						'<dd class="time">' +
						'<strong>' + showingTimeInfo.movie_showing_time.slice(0, -3) + '</strong>' +
						'</dd>' +
						'<dt>잔여석</dt>' +
						'<dd class="seat">' +
						'<strong>' + remainSeatCount + '</strong>' + ' / ' + screenSeatCount +
						'</dd>' +
						'<dt>상영관</dt>' +
						'<dd class="hall">' + showingTimeInfo.screen_location + '</dd>' +
						'</dl></a></li>';

					$(".list_time").append(htmlContent);

					//상영 시간 버튼 클릭시 다음페이지로 이동
					$('.list_time').on('click', '.screenMovieInfo:not(.disabled)', handleScreenMovieInfoClick);
				});
			},
			error: function(error) {
				console.error('Error:', error);
			}
		});
	}
}

//상영 시간 클릭시 좌석선택 페이지로 이동하는 클릭 이벤트 핸틀러
function handleScreenMovieInfoClick() {
	window.location.href = "/ticketing/personseat?screenMovieInfoID=" + encodeURIComponent($(this).data("screenmovieinfoid"))
		+ "&remainSeatCount=" + encodeURIComponent($(this).data("remainseatcount"));
}