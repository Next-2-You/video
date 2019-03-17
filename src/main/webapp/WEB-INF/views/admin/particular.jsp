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
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="50">#</th>
										<th>影片标题</th>
										<th width="100">状态</th>
										<th width="150">操作</th>
									</tr>
								</thead>
								<tbody>
								
									<c:forEach items="${episodeMap.allEpisodes}" var="episode">
										<tr>
											<td>${episode.id}</td>
											<td><a href="${basePath }/Admin_toresourceFilm?episodeid=${episode.id}&episodeName=${episode.episodeName}" target="_blank">${episode.episodeName}</a></td>
											<td><c:if test="${episode.statusId==2}">
													<span class="label label-success radius">上映</span>
												</c:if> <c:if test="${episode.statusId==1}">
													<span class="label label-defaunt radius" style="color: red">已下架</span>
												</c:if></td>
											<td>
												<button type="button" class="btn btn-success btn-xs updateEpisodeStatus"
													<c:if test="${episode.statusId==2}">temp="1"</c:if>
													<c:if test="${episode.statusId==1}">temp="2"</c:if>
													value="${episode.id}">
													<i class=" glyphicon glyphicon-check"></i>
												</button>
												<button type="button"
													class="btn btn-primary btn-xs apperModifyModal"
													value="${episode.id}">
													<i class=" glyphicon glyphicon-pencil"></i>
												</button>
												<button type="button" class="btn btn-danger btn-xs"
													value="${episode.id}">
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
<!-- 	<button class="btn btn-primary btn-lg apperModifyModal"  value="1">第一集修改</button> -->
<!-- <button class="btn btn-primary btn-lg apperModifyModal"  value="2">第二集修改</button> -->
<!-- <button class="btn btn-primary btn-lg deleteEpisode" value="1" temp="1">下架</button> -->
<!-- <button class="btn btn-primary btn-lg deleteEpisode" value="1" temp="2">上架</button> -->
<!-- 	<!-- Button trigger modal --> -->
<!-- 	<button type="button" class="btn btn-primary btn-lg" >添加</button> -->

	<!-- Modal -->
	<div class="modal fade" id="addEpisodeModal" tabindex="-1"
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
						<span class="input-group-addon" id="basic-addon1">名称</span> <input
							type="text" class="form-control" placeholder="episodeName"
							aria-describedby="basic-addon1" name="episodeName" id="episodeName">
					</div>
					<br/>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">集数</span> <input
							type="text" class="form-control" placeholder="episodeNumber"
							aria-describedby="basic-addon1" name="episodeNumber" id="episodeNumber">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveEpisode" value="${filmid}" temp="">保存</button>
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
			$("#saveEpisode").attr("temp","");
			$("#addEpisodeModal").modal({
				backdrop : 'static'
			});
		})	
		//出现修改模态框
		$(".apperModifyModal").each(function() {
		    $(this).bind("click", function() {
		    	var episodeId=$(this).val();
				emptyData("修改");
				//拿数据回显
				modifyData(episodeId);
				$("#saveEpisode").attr("temp",$(this).val())
				$("#addEpisodeModal").modal({
					backdrop : 'static'
				});
		    });
		});

		//确认保存或修改按钮
		$("#saveEpisode").click(function(){
			ajaxAddOrModifyButton();
		})

		//删除和上架通用
		$(".updateEpisodeStatus").each(function() {
		    $(this).bind("click", function() {
			    var id=$(this).val();
			    var statusId=$(this).attr("temp");
		    	changeStatusId(id,statusId);
		    });
		});
	})

//添加和修改通用
function ajaxAddOrModifyButton() {
	var filmId=$("#saveEpisode").val();
	var episodeId=$("#saveEpisode").attr("temp");
	$.ajax({
		url : "${basepath}/video/Admin_addOrUpdateEpisode.action",
		type : "POST",
 		data : {
 	 			"episode.id":episodeId,
 	 			"episode.episodeName":$("#episodeName").val(),
 	 			"episode.episodeNumber":$("#episodeNumber").val(),
 	 			"episode.film.id":filmId
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			$("#addEpisodeModal").modal('hide');
			alert("操作成功！")
		}
	})
}	

function modifyData(id){
	$.ajax({
		url : "${basepath}/video/Admin_findEpisodeById.action",
		type : "POST",
 		data : {
 	 			"id":id,
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			if(result["isSuccess"]){
				$("#episodeName").val(result["episodeName"]);		
				$("#episodeNumber").val(result["episodeNumber"]);			
			}
		}
	})
}

function changeStatusId(id,statusId){
	$.ajax({
		url : "${basepath}/video/Admin_changeEpisodeStatus.action",
		type : "POST",
 		data : {
 	 			"episode.id":id,
 	 			"episode.statusId":statusId
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			if(result["isSuccess"]){

				var i="button[value="+id+"]";

				$(i).parent().prev().empty();

				if(statusId=="1"){
					
					$('<span class="label label-defaunt radius" style="color:red">已下架</span>').appendTo($(i).parent().prev());
					$(i).attr("temp",2);
					
					alert("下架成功！")
				}else{

					$('<span class="label label-success radius">上映</span>').appendTo($(i).parent().prev());

					$(i).attr("temp",1);
					alert("上映成功！")
				}	
			}else{
				alert("操作失败！")
			}
		}
	})
}



	
function emptyData(title){
	$("#myModalLabel").text(title);
	$("#episodeName").val("");
	$("#episodeNumber").val("");
	$("#saveEpisode").text(title);
}


function changeStatus(id,statusId){
	$.ajax({
		url : "${basepath}/video/Admin_changeEpisodeStatus.action",
		type : "POST",
 		data : {
 	 			"episode.id":id,
 	 			"episode.statusId":statusId
 	 		},
 	 	dataType : "json",	
		success : function(result) {	
			if(result["isSuccess"]){
//					alert("操作成功！")		
			}else{
				alert("操作失败！")
			}
		}
	})
}


	

</script>

</html>










