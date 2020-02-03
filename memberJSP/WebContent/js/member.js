
function checkWriteForm(){
	// 유효성 체크
	if (document.writeForm.name.value == "") // 현재문서.폼이름.태그이름.value
		alert("이름을 입력하세요");
	else if (document.writeForm.id.value == "")
		alert("아이디를 입력하세요");
	// else if(document.writeForm.pwd.value=="")
	else if (document.getElementById("pwd").value == "")
		alert("비밀번호를 입력하세요");
	else if (document.writeForm.repwd.value != document.writeForm.pwd.value)
		alert("비밀번호가 맞지 않습니다");
	else if (document.writeForm.id.value != document.writeForm.check.value)
		alert("중복체크 하세요");
	else
		document.writeForm.submit(); // 현재문서.폼이름.액션찾기
}


function checkPost() {
	window.open("checkPost.jsp", "", "width=300 height=300 scrollbars=yes");
}

function checkId(){
	count = 1;
	sId = document.writeForm.id.value;
	if(sId=="") 
		alert("아이디를 입력하세요");
	else 	
		window.open
		("http://localhost:8081/memberJSP/member/checkId.jsp?id="+sId,"","width=500 height=100 left=900 top=300");
}


function checkIdClose(id){
	opener.writeForm.id.value= id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}

function checkLoginForm() {

	if (document.loginForm.id.value=="")
		alert("아이디를 입력하세요");
	else if (document.loginForm.pwd.value=="")
		alert("아이디를 입력하세요");
	else 
		document.loginForm.submit();
}

function gotoSignIn(){
	location.href="../member/writeForm.html";
}
