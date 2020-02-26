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
<button id="hellobtn">��ο� ��������</button>
</body>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(this).ready(function(){
	$('.back').addClass('backColor');
	
	//ũ�ҿ����� �Ұ���
	/*
	$('#hellobtn').click(function(){
		$(this).hide();
		alert("jQuery ����");
		$(this).show();
	});
	*/
	
	/*
	$('#hellobtn').click(function(){
		$(this).hide(function(){
			alert("jQuery ����");
		}).show(function(){
			
		});
	});
	*/
	
	$('#hellobtn').click(function(){
		$(this).hide(100, function(){
			alert("jQuery ����");
		}).show(function(){
			
		});
	});
});
</script>
</html>