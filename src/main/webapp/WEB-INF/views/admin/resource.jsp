<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/basequote.jsp"%>

<link rel="stylesheet"
	href="${basePath}/statics/css/font-awesome.min.css">
<link rel="stylesheet" href="${basePath}/statics/css/main.css">

<script src="${basePath}/statics/js/ajaxfileupload.js"></script>
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>

<body>
<%@include file="../common/nav.jsp" %>
  <div class="container-fluid">
      <div class="row">
		
    	<%@include file="../common/side_menu.jsp" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input class="form-control has-success" type="text"
										placeholder="请输入查询条件">
								</div>
							</div>
							<button type="button" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<button type="button" class="btn btn-primary"
							style="float: right;" data-toggle="modal"
							data-target="#filmAddModal" id="apperAddModal">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</button>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered" style="word-break:break-all; word-wrap:break-all;table-layout:fixed">
								<thead>
									<tr>										
										<th width="30"><input type="checkbox"></th>
										<th width="50">#</th>
										<th width="250">影片标题</th>
										<th width="100">链接类型</th>
										<th width="100">影片分辨率</th>
										<th>影片资源</th>
										<th width="120">操作</th>
									</tr>
								</thead>
								<tbody>
								
									<c:forEach items="${allreSources}" var="resource">
										<tr>
											<td><input type="checkbox" value="${resource.id}"></td>
											<td>${resource.id}</td>
											<td>${episodeName}</td>
											<td><c:if test="${resource.linkType==1}">迅雷下载</c:if><c:if test="${resource.linkType!=1}">在线观看</c:if></td>
											<td> ${resource.resolution.resolution}</td>
											<td>${resource.link}</td>
											<td>
												<button type="button"
													class="btn btn-primary btn-xs apperModifyModal"
													value="${resource.id}">
													<i class=" glyphicon glyphicon-pencil"></i>
												</button>
												<button type="button" class="btn btn-danger btn-xs deleteResource"
													value="${resource.id}">
													<i class=" glyphicon glyphicon-remove"></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	
<!-- 	<button class="btn btn-primary btn-lg apperModifyModal"  value="1">资源1修改</button> -->
<!-- <button class="btn btn-primary btn-lg apperModifyModal"  value="2">资源2修改</button> -->
<!-- <button class="btn btn-primary btn-lg deleteResource" value="1">删除</button> -->

<!-- 	<!-- Button trigger modal --> -->
<!-- 	<button type="button" class="btn btn-primary btn-lg" id="apperAddModal">添加</button> -->
	
	
	<!-- Modal -->
	<div class="modal fade" id="addResourceModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">资源链接/资源名称</span><input
							type="text" class="form-control" placeholder="link"
							aria-describedby="basic-addon1" name="link" id="link">
					</div>
					<br/>
					<div class="form-group">
							<label for="region">分辨率</label> <select class="form-control"
								name="resolution" id="resolution">
								<c:forEach items="${resolutionList}" var="s">
									<option value="${s.id}">${s.resolution}</option>
								</c:forEach>
							</select>
					</div>
					<div class="form-group">
							<label for="region">类型</label> 
							<select class="form-control" name="linkType" id="linkType">
									<option value="2">在线观看</option>							
									<option value="1">下载</option>
							</select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveResource" value="${episodeid}" temp="">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
</body>
<script type="text/javascript">
	$(function(){
		//出现添加模态框
		$("#apperAddModal").click(function(){
			emptyData("添加");
			$("#saveResource").attr("temp","");
			$("#addResourceModal").modal();
		})	
		//出现修改模态框
		$(".apperModifyModal").each(function() {
		    $(this).bind("click", function() {
		    	var ResourceId=$(this).val();
				emptyData("修改");
				//拿数据回显
				modifyData(ResourceId);
				$("#saveResource").attr("temp",$(this).val())
				$("#addResourceModal").modal(
// 						{
// 					backdrop : 'static'
// 				}
				);
		    });
		});

		//确认保存或修改按钮
		$("#saveResource").click(function(){
			ajaxAddOrModifyButton();
		})

		//删除和上架通用
		$(".deleteResource").each(function() {
		    $(this).bind("click", function() {
			    var id=$(this).val();
			    deleteResource(id);
		    });
		});
	})

//添加和修改通用
function ajaxAddOrModifyButton() {
	var episodeId=$("#saveResource").val();
	var ResourceId=$("#saveResource").attr("temp");
	$.ajax({
		url : "${basepath}/video/Admin_addOrUpdateResource.action",
		type : "POST",
 		data : {
 	 			"Resource.id":ResourceId,
 	 			"Resource.resolution.id":$("#resolution").val(),
 	 			"Resource.link":$("#link").val(),
 	 			"Resource.linkType":$("#linkType").val(),
 	 			"Resource.episode.id":episodeId
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			$("#addResourceModal").modal('hide');
			alert("添加成功！")
		}
	})
}	

function modifyData(id){
	$.ajax({
		url : "${basepath}/video/Admin_findResolutionById.action",
		type : "POST",
 		data : {
 	 			"id":id,
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			if(result["isSuccess"]){
				$("#linkType").val(result["linkType"]);		
				$("#link").val(result["link"]);			
				$("#resolution").val(result["resolutionId"]);				
			}
		}
	})
}

function deleteResource(id){
	$.ajax({
		url : "${basepath}/video/Admin_deleteResource.action",
		type : "POST",
 		data : {
 	 			"Resource.id":id,
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			if(result["isSuccess"]){
				var i="button.deleteResource[value="+id+"]";
				$(i).parents("tr").remove();
				alert("删除成功！")		
			}else{
				alert("删除失败！")
			}
		}
	})
}
	
function emptyData(title){
	$("#myModalLabel").text(title);
	$("#resolution").val("");
	$("#link").val("");
	$("#linkType").val("");
	$("#saveResource").text(title);
}

</script>

</html>










