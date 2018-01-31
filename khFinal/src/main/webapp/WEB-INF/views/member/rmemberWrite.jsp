<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    <div>
       <h1>가입</h1>
       <form:form commandName="rmemberCommand" action="rwrite.do" id="register_form">
      <ul>
         <li>
            <label for="id">아이디</label>
            <form:input path="id"/>
         </li>
         <li>
            <label for="pw">비밀번호</label>
            <form:password path="pw"/>
         </li>
         <li>
            <label for="name">이름</label>
            <form:input path="id"/>
         </li>
         <li>
            <label for="phone">전화번호</label>
            <form:input path="phone"/>
         </li>
         <li>
            <label for="licencenumber">면허증</label>
            <form:input path="licencenumber"/>
         </li>
         <li>
            <label for="preferloc">선호지역</label>
            <form:input path="preferloc"/>
         </li>
      </ul>
      <div>
          <input type="submit" value="전송">
          <input type="button" value="메인" onclick="location.href='${pageContect.request.contextPath}/main/main.do'">
      </div>
      
       </form:form>
       
    </div>
