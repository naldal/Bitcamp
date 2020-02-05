function checkBoard(){
	if(document.boardForm.subject.value=="")
		alert("제목을 입력하세요");
	else if(document.boardForm.content.value=="")
		alert("내용을 입력하세요");
	else 
		document.boardForm.submit();
}