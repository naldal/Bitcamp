function write(){
	//유효성 체크
	if(document.boardForm.subject.value=="")
		alert("제목을 입력하세요");
	else if(document.boardForm.content.value=="")
		alert("내용을 입력하세요");
	else {
		document.boardForm.submit();
	}
}

function write2(){
	//유효성 체크
	alert("asdfa");
	if(document.boardForm.subject.value=="")
		alert("제목을 입력하세요");
	else if(document.boardForm.content.value=="")
		alert("내용을 입력하세요");
	else {
		document.boardForm.submit();
	}
}
function gotoSomeWhere(){
	location.href=
		"http://localhost:8081/guestbookServlet/GuestWriteServlet";
	
	
	
	
	
	
//	let name = document.boardForm.name.value;
//	let email = document.boardForm.name.value;
//	let homepage = document.boardForm.name.value;
//	let subject = document.boardForm.name.value;
//	let content = document.boardForm.name.value;
	
//		"?name="+name+
//		"&email="+email+
//		"&homepage="+homepage+
//		"&subject="+subject+
//		"&content="+content;

}