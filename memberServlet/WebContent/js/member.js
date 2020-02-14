//let count = 0;
//var id = null;

function checkWriteForm() {
	//유효성 체크
	if(document.writeForm.name.value=="") {
		alert("이름을 입력하세요.") ; //document = 현재 문서
	} else if(document.writeForm.id.value=="") {
		alert("아이디를 입력하세요.")
	} //else if(document.writeForm.pwd.value=="") {
	  else if(document.getElementById("pwd").value=="") {
		alert("비밀번호를 입력하세요.")
	} else if(document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.")
	} else if(document.writeForm.id.value != document.writeForm.check.value){
		alert("중복체크를 해주세요");
	} else {
		document.writeForm.submit();
	}
}

function checkPost() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
//                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("zipcode").value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();
}

// 우편번호 사용 방법
// 1. daum api 사용
// 2. 직접 다 받아다 사용

function checkId(){
	let sId = document.writeForm.id.value;
	if(sId=="") {
		alert("먼저 아이디를 입력하세요.");
	} else {
//		count=1;
		window.open("http://localhost:8080/memberServlet/CheckIdServlet?id="+sId
				, ""
				, "width=300 height=100 left=500 top=100");
	}
}

function checkIdClose(id){
	opener.writeForm.id.value = id;
	//document는 현재 자기자신의 위치인데 이 시점의 위치는 새로 뜬 팝업창이기 때문에 사용하면 찾지못한다.
	//opener는 현재 열려있는 창을 뜻하는 javascript 언어.
//	opener.id = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}

function checkLoginForm() {

	if(document.loginForm.id.value=="") {
		alert("아이디를 입력해주세요.");
	} else if(document.loginForm.pwd.value=="") {
		alert("비밀번호를 입력해주세요.");
	} else {
		document.loginForm.submit();
	}
}

//function signUp() {
//	location.href="http://localhost:8080/memberServlet/member/writeForm.html";
//}