<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/${blogvo.id}/admin/basic">기본설정</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/${blogvo.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/${blogvo.id}/admin/write">글작성</a></li>
				</ul>