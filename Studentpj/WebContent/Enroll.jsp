<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="enroll.css" type="text/css">
</head>

<body>
    <div class="form">
        <h1> ���������Է�</h1>
        
        <div id="nameSection">
            �̸� : <input type="text" name="name" value="���Ϲ�">
        </div>

        <div id="phoneSection">
            ��ȭ��ȣ :
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
        ���� :
            <input type="checkbox" name="chk_hobby" id="reading">����
            <input type="checkbox" name="chk_hobby" id="movie">��ȭ
            <input type="checkbox" name="chk_hobby" id="music">����
            <input type="checkbox" name="chk_hobby" id="game">����
            <input type="checkbox" name="chk_hobby" id="shopping">����
        </div>

        <div id="genderSection">
        ��� :
	        <input type="radio" name="chk_gender" value="0">����
	        <input type="radio" name="chk_gender" value="1">����
        </div>
        
        <div id="buttonSection">
            <button type="button" onclick="location.href='Join.jsp?name=${name}">���</button>
            <button type="button" onclick="location.href='Fix.jsp'">����</button>
            <button type="button" onclick="location.href='Delete.jsp'">����</button>
            <button type="button" onclick="location.href='Clear.jsp'">�����</button>
        </div>
    </div>
</body>

</html>