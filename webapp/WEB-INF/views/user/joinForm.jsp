<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>
<body>
	<div id="center-content">
		
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- 메인 해더 -->
	

		<div>
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
					<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
					<tr>
						<td><label for="txtId">아이디</label></td>
						<td><input id="txtId" type="text" name="id" value=""></td>
						<td><button id="btnIdCheck" type="button">아이디체크</button></td>
					</tr>
					<tr>
						<td></td>
						<td id="tdMsg" colspan="2"></td>
					</tr>
					<tr>
						<td><label for="txtPassword">패스워드</label></td>
						<td><input id="txtPassword" type="password" name="password" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="txtUserName">이름</label></td>
						<td><input id="txtUserName" type="text" name="userName" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><span>약관동의</span></td>
						<td colspan="3"><input id="chkAgree" type="checkbox" name="agree" value="y"> <label for="chkAgree">서비스 약관에 동의합니다.</label></td>
					</tr>
				</table>
				<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit">회원가입</button>
				</div>

			</form>

		</div>

		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		<!-- 메인 푸터  자리-->
	
	</div>

</body>
<script type="text/javascript">

/*중복아이디 체크버튼 눌렀을 때*/
$("#btnIdCheck").on("click", function(){
	console.log("중복아이디 체크버튼 클릭");
	
	var id = $("#txtId").val();
	
	console.log(id);
	//서버로 데이터 전송
	$.ajax({
		
		url : "${pageContext.request.contextPath }/user/idCheck",		
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(id),

		dataType : "json",
		success : function(result){
			/*성공시 처리해야될 코드 작성*/
			
			if(result == "available") {
				$("#tdMsg").text("사용할 수 있는 아이디 입니다.");
			}else {
				$("#tdMsg").text("다른 아이디로 가입해 주세요.");
			}
			
			
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
});

/*회원가입 버튼 클릭*/
$("#joinForm").on("submit", function(){
	console.log("회원가입 버튼 클릭");
	
	
	var id = $("#txtId").val();
	var password = $("#txtPassword").val();
	var name = $("#txtUserName").val();
	
	if(id == "" || id == null){
		alert("아이디를 입력해주세요");
		return false;
	}
	
	if(password == "" || password == null){
		alert("패스워드를 입력해주세요");
		return false;
	}
	
	if(name == "" || name == null){
		alert("이름을 입력해주세요");
		return false;
	}
	
	//약관동의
	var agree = $("#chkAgree").is(":checked");
	if(agree == false) {
		alert("약관에 동의해주세요")
		return false;
	}

	
	return true;
});

</script>


</html>