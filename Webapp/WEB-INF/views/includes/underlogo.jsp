
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css" >

			 	<a href="${pageContext.request.contextPath}/">
			<img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
		</a>
		<ul class="menu">
			<c:choose>
			<c:when test="${empty authUser}">
				<!-- 로그인 전 -->
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
				</c:when>
				<c:otherwise>
				<!-- 로그인 후 -->
				<li><a href="${pageContext.request.contextPath}/${authUser.id}">내 블로그</a></li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li> 
			
			</c:otherwise>
			</c:choose>
			</ul>
		