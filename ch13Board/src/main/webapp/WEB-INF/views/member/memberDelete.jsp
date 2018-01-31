<%-- 2018. 1. 16. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h1>회원 탈퇴</h1>
	<form:form commandName="command" action="delete.do" id="delete_form">
		<form:hidden path="id"/>
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="passwd">PW</label>
				<form:password path="passwd"/>
				<form:errors path="passwd" cssClass="error-color"/>
			</li>
			
		</ul>
		<div class="align-center">
			<input type="submit" value="회원탈퇴">
			<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			
		</div>
	</form:form>
</div>	
