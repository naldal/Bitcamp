function checkGuestbookWriteForm() {
	if(document.writeForm.subject.value=="")
		alert("제목을 입력하세요")
	else if(document.writeForm.content.value=="")
		alert("내용을 입력하세요")
	else {
		document.writeForm.submit();
	}
}