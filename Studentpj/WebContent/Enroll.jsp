<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="enroll.css" type="text/css">
</head>

<body>
    <div class="form">
        <h1> 개인정보입력</h1>
        
        <div id="nameSection">
            이름 : <input type="text" name="name" value="송하민">
        </div>

        <div id="phoneSection">
            전화번호 :
            <select name="tel1">
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="018">018</option>
            </select>
            -
            <input id="tel2" name="tel2" type="text" width="10px">
            -
            <input id="tel3" name="tel3" type="text" width="10px">
        </div>

        <div id="nameSection">
        성별 :
            <input type="checkbox" name="chk_hobby" id="reading">독서
            <input type="checkbox" name="chk_hobby" id="movie">영화
            <input type="checkbox" name="chk_hobby" id="music">음악
            <input type="checkbox" name="chk_hobby" id="game">게임
            <input type="checkbox" name="chk_hobby" id="shopping">쇼핑
        </div>

        <div id="genderSection">
        취미 :
	        <input type="radio" name="chk_gender" value="0">남성
	        <input type="radio" name="chk_gender" value="1">여성
        </div>
        
        <div id="buttonSection">
            <button type="button" onclick="location.href='Join.jsp?name=${name}">등록</button>
            <button type="button" onclick="location.href='Fix.jsp'">수정</button>
            <button type="button" onclick="location.href='Delete.jsp'">삭제</button>
            <button type="button" onclick="location.href='Clear.jsp'">지우기</button>
        </div>
    </div>
</body>

</html>