<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台登陆</title>
</head>
<%@include file="../common/basequote.jsp"%>
<body>

	<div class="container" style="margin-top: 100px">
		<div style="width: 300px; margin: 0 auto;">
			<form >
				<h2 style="text-align: center;">视频网后台登陆</h2>
				<br />
				<div class="form-group">
					<label for="exampleInputEmail1">用户名</label> <input
						class="form-control" id="managerName" placeholder="Manager">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">密码</label> <input
						type="password" class="form-control" id="managerPasswd"
						placeholder="Password">
				</div>
				<button class="btn btn-default">提交</button>
			</form>
		</div>

	</div>

</body>
<script type="text/javascript">

	$(function(){


		$("button").click(function(){
			var managerName=$("#managerName").val();
			var managerPasswd=$("#managerPasswd").val();
			if(managerName!=null&&managerPasswd!=null&&managerName.trim()!=''&&managerPasswd.trim()!=''){
				login();
			}
			return false;
		})

	})

		
function login(){
		$.ajax({
			url:"$(basePath)/video/manager_doLogin",
			type:"POST",
			data:{
				"manager.managerName":$("#managerName").val(),
				"manager.managerPasswd":$("#managerPasswd").val()
				},
		dataType:"json",
			success:function(result){				
				if(result.msg){
					alert("登陆成功！");
					location.href="${basePath}/manager_toMainPage";

				}else{
					alert("登陆失败！");

			}
			},
			error:function(e){
				alert("系统错误！请联系程序员。。。");
			}
		})

	}

</script>



</html>