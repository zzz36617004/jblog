<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<div id="content" class="full-screen">
					<c:import url="/WEB-INF/views/includes/admin-name.jsp"></c:import>
				
		      	<table class="admin-cat">
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		
		      		<tbody id=cateList>
		      			
					</tbody>
					
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add" >
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="btnAddCate" type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	
			</div>
		</div>

		
		<!-- 푸터-->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){  //객체화 하는 작업이 끝나면 함수 진행
	fetchList();
});

$("#btnAddCate").on("click",function(){
	var id="${blogvo.id}";
	var name=$("[name=name]").val();
	var desc=$("[name=desc]").val();
	console.log(name);
	console.log(desc);
	$.ajax({
		url : "${pageContext.request.contextPath }/${blogvo.id}/admin/addcategory",
		type : "post",
		data : {id:id , cateName:name , description:desc},						
		 //이름은 상관없이 결과값 받아주는 거, 여기 result는 controller에서 받아준 no값
		dataType : "json",
	    success : function(categoryVo) {
	            render(categoryVo, "up");
	            $("[id=name]").val("");
	            $("[id=desc]").val("");
	         },
	         error : function(XHR, status, error) {
	            console.error(status + " : " + error);
	         }
	      })
	   });
	   
$("tbody").on("click","img",function(){       //내가 너를 클릭하지만 실제 행동은 상속받는 li가 한다.
	var cateNo=$(this).attr("class");
	console.log(cateNo);
	$.ajax({
		url : "${pageContext.request.contextPath }/${blogvo.id}/admin/del",
		type : "get",
		data :{cateNo:cateNo},						
		dataType : "json",
		success :  function(result){ //이름은 상관없이 결과값 받아주는 거, 여기 result는 controller에서 받아준 no값
			console.log(result);
		if(result==0){
			alert("포스트가 있는 경우 삭제할수 없습니다.");
		}
		else{
			$("#"+result).remove();
		}
			
			 //tbody.removeChild(result);
			
        },	
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	})
});
function fetchList(){
	var id="${blogvo.id}";
	console.log(id);
	//리스트 요청 ajax
		$.ajax({
			url : "${pageContext.request.contextPath }/${blogvo.id}/admin/category/list",
			type : "get",
			data :{id:id},						//앞에 키값 뒤가 밸류
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

function render(categoryVo, updown){
		var str="";
		str+="<tr id="+categoryVo.cateNo+">";
		str+="<td>"+categoryVo.cateNo+"</td>";
		str+="<td>"+categoryVo.cateName+"</td>";
		str+="<td>"+categoryVo.postNum+"</td>";
		str+="<td>"+categoryVo.description+"</td>";
		str+="<td><img id='del' class="+categoryVo.cateNo+" src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>";
		str+="</tr>";
		
		if(updown == "up"){
			$("#cateList").prepend(str);
		}
		else if(updown == "down"){
			$("#cateList").append(str);
		}
		else{
			console.log("오류");
			
		}
	
	}
</script>

</html>