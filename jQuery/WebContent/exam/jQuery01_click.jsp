<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<input type="button" id="btn1" value="commit_1" onclick="process()">
<input type="button" id="btn2" value="commit_2">
<input type="button" id="btn3" value="commit_3">

</body>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script> -->
<script type="text/javascript">
function process(){
	alert("commit_1 호출");
}

$(document).ready(function(){
	$('#btn2').click(function(){
	//selector(선택자).이벤트(함수)
		alert("commit_2 호출");
	});
	
	$('#btn3').bind('click', function(){
		alert("commit_3 호출");
	});
});
</script>
</html>