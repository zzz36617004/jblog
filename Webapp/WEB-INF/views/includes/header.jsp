
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css" >
		<div id="header">
			<h1><a href="">${blogvo.blogTitle}</a></h1>
			<ul>
			<c:choose>
			<c:when test="${empty authUser}">
				<!-- 로그인 전 -->
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
				</c:when>
				<c:otherwise>
				<!-- 로그인 후 -->
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li> 
				<c:if test="${authUser.id eq map.blogvo.id}">
				<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">내 블로그 관리</a></li>
				</c:if>
			</c:otherwise>
			</c:choose>
					
			</ul>
		</div>
