<%-- 2018. 1. 17. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-main-style">
	<h1>글 수정</h1>
	<form:form commandName="command" action="update.do" id="modify_form" enctype="multipart/form-data">
		<form:hidden path="id"/>
		<form:hidden path="num"/>
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			
			<li>
				<label for="title">제목</label>
				<form:input path="title"/>
				<form:errors path="title" cssClass="error-color"/>
			</li>
			
			<li>
				<label for="content">내용</label>
				<form:textarea path="content" rows="10"/>
				<form:errors path="content" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">파일 업로드</label>
				<input type="file" name="upload" id="upload">
				<c:if test="${!empty command.filename}">
				<br><span>(${command.filename})파일이 등록되어 있습니다. 다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
			</li>
			
			
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록" onclick="location.href='list.do'">
			
		</div>
	</form:form>
</div>	
