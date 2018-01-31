<%-- 2018. 1. 16. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="page-main-style">
	<h2>회원 상세정보</h2>
	<ul>
		<li>ID : ${member.id}</li>
		<li>이름 : ${member.name}</li>
		<li>전화번호 : ${member.phone}</li>
		<li>Email : ${member.email}</li>
		<li>우편번호 : ${member.zipcode}</li>
		<li>주소 : ${member.address1}</li>
		<li>상세주소 : ${member.address2}</li>
		<li>가입일 : ${member.reg_date}</li>
	</ul>
	<hr size="1" width="100%">
	<p class="align-right">
		<input type="button" value="수정" onclick="location.href='update.do'">
		<input type="button" value="삭제" onclick="location.href='delete.do'">
		<input type="button" value="홈" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
	</p>
</div>