function checkWriteForm() {
//	alert("여기까진")
	if(document.writeForm.name.value==""){
		alert("이름을 입력하세요.");
	} else if(document.writeForm.id.value=="") {
		alert("아이디를 입력하세요.")
	} else if(document.writeForm.pwd.value=="") {
		alert("비밀번호를 입력하세요.")
	} else if(document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.")
	} else if(document.writeForm.id.value != document.writeForm.idCheck.value) {
		alert("중복체크를 해주세요.")
	} else {
		document.writeForm.submit();
	}
}

function checkPost() {
	window.open("/miniProject/member/checkPost.do", "", "width=400 height=400 ");
}

function idCheck2() {

	let sId = document.writeForm.id.value;
	if(sId=="") {
		alert("먼저 아이디를 입력하세요.");
	} else {
		window.open("/miniProject/member/checkId.do?id="+sId
		, ""
		, "width=300 height=100 left=500 top=100");
	}
}

function checkIdClose(id) {
	opener.writeForm.id.value = id;
	/*alert(id);*/
	opener.writeForm.idCheck.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}

function checkLoginForm() {
	
	if(document.loginForm.id.value==""){
		alert("아이디를 입력해주세요.")
	} else if(document.loginForm.pwd.value=="") {
		alert("비밀번호를 입력해주세요.")
	} else {
		document.loginForm.submit();
	}
}

function checkModifyForm() {
	if(document.getElementById('id').value==""){
		alert("이름을 입력하세요.");
	} else if(document.getElementById('pwd').value=="") {
		alert("비밀번호를 입력하세요.")
	} else if(document.getElementById('pwd').value != document.getElementById('repwd').value) {
		alert("비밀번호가 일치하지 않습니다.")
	} else {
		document.modifyForm.submit();
	}
}

function checkBoardWriterForm() {
	if(document.getElementById('subject').value=="") {
		alert("제목을 입력하세요.");
	} else if(document.getElementById('content').value=="") {
		alert("내용을 입력하세요.");
	} else {
		document.boardWriteForm.submit();
	}
}