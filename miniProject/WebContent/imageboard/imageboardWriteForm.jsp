<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="imageBoardForm" action="/miniProject/imageboard/imageboardWrite.do" method="post" enctype="multipart/form-data">
<table border="1" cellpadding="7">
    <tr>
        <td>상품코드</td>
        <td><input type="text" name="imageid" placeholder="img"></td>
    </tr>
    <tr>
        <td>상품명</td>
        <td><input type="text" name="imagename" placeholder="상품명 입력"></td>
    </tr>
    <tr>
        <td>단가</td>
        <td><input type="text" name="imageprice" placeholder="단가 입력"></td>
    </tr>
    <tr>
        <td>갯수</td>
        <td><input type="text" name="imageqty" placeholder="갯수 입력"></td>
    </tr>
    <tr>
        <td>내용</td>
        <td><textarea name="imagecontent" id="imagecontent"
            placeholder="내용입력" cols="30" rows="10"></textarea></td>
    </tr>
    <tr >
        <td colspan="2" align="center">
            <input type="file" name="image1">
        </td>
    </tr>
    <tr >
        <td colspan="2" align="center">
            <input type="submit" value="이미지 등록">
            <input type="reset" value="다시 작성">
        </td>
    </tr>
</table>
</form>