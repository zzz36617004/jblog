<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>

	<div id="container">

		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${map.post.postTitle} </h4>
					<p>${map.post.postContent}
					</p>
					<c:if test="${map.emptys==1}">
      				<h4>등록된 글이 없습니다.</h4>
					<p>
						
					<p>
      				</c:if>
      				
      				
					</div>
					
					
						<c:if test="${not empty authUser}">
						<div id="comment">
						<table>
							<tr>
								<td></td><td><input type="text" name="name" value="${authUser.userName}"/></td>
								<td></td><td><input type="text" name="content" /></td>
								<td colspan=4 align=right><input id="btnadd" type="button" VALUE=" 저장 " /></td>
							</tr>
						</table>
						</div>
				</c:if>
				
				<ul id="guestbook-list">
					
					</ul>
					
				<ul class="blog-list">
				<c:forEach items="${map.postlist}" var="vo">
					<li>
						<a href="${pageContext.request.contextPath}/${blogvo.id}?cateNo=${vo.cateNo}&postNo=${vo.postNo}">${vo.postTitle}</a> 
						<span>${vo.regDate}</span>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/upload/${blogvo.logoFile}">				
			</div>
		</div>

	<div id="navigation">
			<h2>카테고리</h2>
			<ul>
			<c:forEach items="${map.catelist}" var="vo">
				<li><a href="${pageContext.request.contextPath}/${blogvo.id}?cateNo=${vo.cateNo}&postNo=0">${vo.cateName}</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<!-- 푸터-->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div>
</body>
<script type="text/javascript">

$(document).ready(function(){  //객체화 하는 작업이 끝나면 함수 진행
	fetchList();
});

function fetchList(){
	var castNo="${map.castNo}"
	var postNo="${map.postNo}"
	var userNo="${map.uservo.userNo}"
	//리스트 요청 ajax
		$.ajax({
			url : "${pageContext.request.contextPath }/${blogvo.id}/commentslist",
			type : "get",
			data :{postNo:postNo,castNo:castNo,userNo:userNo},						//앞에 키값 뒤가 밸류
			dataType : "json",
			success : function(list){
				console.log(list);
			for(var i=0;i<list.length;i++){
				render(list[i],"down");
			}
			/*성공시 처리해야될 코드 작성*/
			},
			error : function(XHR, status, error) {
			console.error(status + " : " + error);
			}
		})
		}
		
$("#btnadd").on("click",function(){
	var userNo="${map.uservo.userNo}"
	var postNo="${map.postNo}"
	var id="${blogvo.id}";
	var name=$("[name=name]").val();
	var content=$("[name=content]").val();
	console.log(name);
	$.ajax({
		url : "${pageContext.request.contextPath }/${blogvo.id}/admin/addcomment",
		type : "post",
		data : {userNo:userNo , postNo:postNo , cmtContent:content, userName:name},						
		 //이름은 상관없이 결과값 받아주는 거, 여기 result는 controller에서 받아준 no값
		dataType : "json",
	    success : function(CommentsVo) {
	            render(CommentsVo, "up");
	            $("[namn=name]").val("");
	            $("[name=content]").val("");
	         },
	         error : function(XHR, status, error) {
	            console.error(status + " : " + error);
	         }
	      })
	   });
	   
$("ul").on("click","input",function(){       //내가 너를 클릭하지만 실제 행동은 상속받는 li가 한다.
	console.log("삭제삭제");
	var cmtNo=$(this).attr("class");
	
	$.ajax({
		url : "${pageContext.request.contextPath }/${blogvo.id}/admin/delcomment",
		type : "get",
		data :{cmtNo:cmtNo},						
		dataType : "json",
		success :  function(result){ //이름은 상관없이 결과값 받아주는 거, 여기 result는 controller에서 받아준 no값
			console.log(result);
			$("#"+result).remove();
			 //tbody.removeChild(result);
        },	
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	})
});

function render(commentsVo, updown){
	var str="";
	str+="<li id='"+commentsVo.cmtNo+"'>";
	str+="	<table>";
	str+="		<tr>";
	str+="			<td>["+commentsVo.userName+"]</td>";
	str+="			<td>"+commentsVo.cmtContent+"</td>";
	str+="			<td>"+commentsVo.regDate+"</td>";
	if(commentsVo.userNo=="${authUser.userNo}"){
	str+="			<td><input id='btnModal' type='button' class='"+commentsVo.cmtNo+"' value='삭제'/></td>";
	}
	str+="		</tr>";
	str+="	<table>";
	str+="</li>";
	if(updown == "up"){
		$("#guestbook-list").prepend(str);
	}
	else if(updown == "down"){
		$("#guestbook-list").append(str);
	}
	else{
		console.log("오류");
		
	}

}
</script>
</html>