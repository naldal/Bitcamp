<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jQuery Hide</title>
</head>
<style type="text/css">
.backColor {
	background-color: green;
}
</style>
<body>
<h1 class="back">Hello jQuery</h1>
<button id="hellobtn">헬로우 제이쿼리</button>
</body>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(this).ready(function(){
	$('.back').addClass('backColor');
	
	//크롬에서는 불가능
	/*
	$('#hellobtn').click(function(){
		$(this).hide();
		alert("jQuery 연습");
		$(this).show();
	});
	*/
	
	/*
	$('#hellobtn').click(function(){
		$(this).hide(function(){
			alert("jQuery 연습");
		}).show(function(){
			
		});
	});
	*/
	
	$('#hellobtn').click(function(){
		$(this).hide(100, function(){
			alert("jQuery 연습");
		}).show(function(){
			
		});
	});
});
</script>
</html>