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
	<div class="center-content">
		
		
		<c:import url="/WEB-INF/views/includes/underlogo.jsp"></c:import>
		<form class="join-form" id="join-form" method="post" action="joins">
			<label class="block-label" for="name">이름</label>
			<input type="text" name="userName"  value="" />
			
			<label class="block-label" for="id">아이디</label>
			<input type="text" name="id" id="id" value="" />
			
			<input id="btn-checkid" type="button" value="id 중복체크">
			<input name="check" type="hidden" value="false">
			<p id="checkid-msg" class="form-error">
			&nbsp;
			</p>
			
			<label class="block-label" for="password">패스워드</label>
			<input type="password" name="password"  value="" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input id="submit" type="submit" value="가입하기">

		</form>
	</div>

</body>

<script type="text/javascript">

$("#submit").on("click",function(){
	var flag=false;
 	 if($("[name=userName]").val()==""){
 		alert("이름입력하세요");
	}
	else if($("[name=id]").val()==""){
		alert("아이디입력하세요");
	}
	else if($("[name=check]").val()=="false"){
		alert("아이디 중복 체크 하세요.");
	}
	else if($("[name=password]").val()==""){
		alert("패스워드입력하세요");
	}
	else if(!$("#agree-prov").is(":checked")){
		alert("약관동의 하세요 ");
		
	}
	else{
		flag=true;
	}
 	 
 	 return flag;
 	 
});




	$("#btn-checkid").on("click",function(){
		var id=$("#id").val();
		console.log(id);
		
		$.ajax({
			url : "${pageContext.request.contextPath }/user/idcheck",
			type : "post",
			data :{id:id},						//앞에 키값 뒤가 밸류
			dataType : "json",
			success : function(isExists){
				console.log(isExists);
				if(isExists==true){
					$("#checkid-msg").html("사용중인 아이디 입니다.");
				}else{
					$("#checkid-msg").html("사용 가능합니다.");
					$("[name=check]").val("true");
				}
				
			/*성공시 처리해야될 코드 작성*/
			},
			error : function(XHR, status, error) {
			//console.error(status + " : " + error);
			}
		});
	});

</script>

</html>