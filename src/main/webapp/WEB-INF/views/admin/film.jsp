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

	<link rel="stylesheet" href="${basePath}/statics/css/font-awesome.min.css">
	<link rel="stylesheet" href="${basePath}/statics/css/main.css">

<script src="${basePath}/statics/js/ajaxfileupload.js"></script>
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>
<script type="text/javascript">
        $(function () {
        	 $("#statrs").rating({
     			min: 0,
                 max: 5,
                 step: 0.5,
                 size: 'sm',
                 showClear: false,
                 showCaption:false,
     			});
        	 $("#filmModifyModal #statrs").rating({
      			min: 0,
                  max: 5,
                  step: 0.5,
                  size: 'sm',
                  showClear: false,
                  showCaption:false,
      			});
        });
    </script>
  <body>
<%@include file="../common/nav.jsp" %>
  <div class="container-fluid">
      <div class="row">
		
    	<%@include file="../common/side_menu.jsp" %>
    
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="searchName" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button id="search" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" data-toggle="modal" data-target="#filmAddModal" id="apperAddModal"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox"></th>
                  <th>影名</th>
                  <th>上映时间</th>
                  <th>状态</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${pageInfo.pageList}" var="film">
              	
                <tr>
                  <td>${film.id}</td>
				  <td><input type="checkbox"></td>
                  <td><a href="${basePath}/Admin_toParticularFilm?filmid=${film.id}" target="_blank">${film.filmName}</a></td>
                  <td>${film.releaseTime}</td>
                  <td><c:if test="${film.statusId==2}"><span class="label label-success radius">上映</span></c:if><c:if test="${film.statusId==1}"><span class="label label-defaunt radius" style="color:red">已下架</span></c:if> </td>
                  <td>
				      <button type="button" class="btn btn-success btn-xs" <c:if test="${film.statusId==2}">value="1"</c:if> <c:if test="${film.statusId==1}">value="2"</c:if> id="${film.id}" name="statusId"><i class=" glyphicon glyphicon-check"></i></button>
				      <button type="button" class="btn btn-primary btn-xs appearModifyForm"  value="${film.id}"><i class=" glyphicon glyphicon-pencil"></i></button>
					  <button type="button" class="btn btn-danger btn-xs"  value="${film.id}"><i class=" glyphicon glyphicon-remove"></i></button>
					  

					  
				  </td>
                </tr>
               </c:forEach>
              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul id="paging" class="pagination">
								<c:if test="${pageInfo.totalPages!=0&&pageInfo.totalPages!=null}">
						<li
							class='<c:if test="${pageInfo.currentPage==1}">disabled</c:if>'>
							<a href="javascript:void(0)" aria-label="Previous"
							value="${pageInfo.currentPage-1}"> <span aria-hidden="true">&laquo;</span>
						</a>
						</li>
						<c:choose>
							<c:when test="${pageInfo.currentPage-2>0}">
								<c:choose>
									<c:when test="${pageInfo.currentPage+2<=pageInfo.totalPages}">
										<c:set var="endPage" value="${pageInfo.currentPage+2}"
											scope="page"></c:set>
										<c:set var="beginPage" value="${pageInfo.currentPage-2}"
											scope="page"></c:set>
									</c:when>
									<c:when
										test="${pageInfo.currentPage+2>pageInfo.totalPages&&pageInfo.currentPage+1<=pageInfo.totalPages}">
										<c:set var="endPage" value="${pageInfo.currentPage+1}"
											scope="page"></c:set>
										<c:choose>
											<c:when test="${pageInfo.currentPage-3>0}">
												<c:set var="beginPage" value="${pageInfo.currentPage-3}"
												scope="page"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="beginPage" value="${pageInfo.currentPage-2}"
												scope="page"></c:set>
											</c:otherwise>										
										</c:choose>	
									</c:when>
									<c:otherwise>
										<c:set var="endPage" value="${pageInfo.currentPage}"
											scope="page"></c:set>
										<c:choose>
											<c:when test="${pageInfo.currentPage-4>0}">
												<c:set var="beginPage" value="${pageInfo.currentPage-4}"
												scope="page"></c:set>
											
											</c:when>
											<c:when test="${pageInfo.currentPage-3>0}">
												<c:set var="beginPage" value="${pageInfo.currentPage-3}"
												scope="page"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="beginPage" value="${pageInfo.currentPage-2}"
												scope="page"></c:set>
											</c:otherwise>										
										</c:choose>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="${beginPage}" end='${endPage}' var="i">
									<li
										class="<c:if test='${i==pageInfo.currentPage}'>active</c:if>"><a
										href="javascript:void(0)" value="${i}">${i}</a></li>
								</c:forEach>
							</c:when>
							<c:when
								test="${pageInfo.currentPage-1>0&&pageInfo.currentPage-2<=0}">
								<c:choose>
									<c:when test="${pageInfo.currentPage+3<=pageInfo.totalPages}">
										<c:set var="endPage" value="${pageInfo.currentPage+3}"
											scope="page"></c:set>
									</c:when>
									<c:when
										test="${pageInfo.currentPage+3>pageInfo.totalPages&&pageInfo.currentPage+2<=pageInfo.totalPages}">
										<c:set var="endPage" value="${pageInfo.currentPage+2}"
											scope="page"></c:set>
									</c:when>
									<c:when
										test="${pageInfo.currentPage+2>pageInfo.totalPages&&pageInfo.currentPage+1<=pageInfo.totalPages }">
										<c:set var="endPage" value="${pageInfo.currentPage+1}"
											scope="page"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="endPage" value="${pageInfo.currentPage}"
											scope="page"></c:set>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="${pageInfo.currentPage-1}" end='${endPage}'
									var="i">
									<li
										class="<c:if test='${i==pageInfo.currentPage}'>active</c:if>"><a
										href="javascript:void(0)" value="${i}">${i}</a></li>
								</c:forEach>
							</c:when>
							<c:when test="${pageInfo.currentPage==1}">
								<c:choose>
									<c:when test='${pageInfo.currentPage+4<=pageInfo.totalPages}'>
										<c:set var="endPage" value="${pageInfo.currentPage+4}"
											scope="page"></c:set>
									</c:when>
									<c:when
										test='${pageInfo.currentPage+4>pageInfo.totalPages&&pageInfo.currentPage+3<=pageInfo.totalPages}'>
										<c:set var="endPage" value="${pageInfo.currentPage+3}"
											scope="page"></c:set>
									</c:when>
									<c:when
										test='${pageInfo.currentPage+3>pageInfo.totalPages&&pageInfo.currentPage+2<=pageInfo.totalPages}'>
										<c:set var="endPage" value="${pageInfo.currentPage+2}"
											scope="page"></c:set>
									</c:when>
									<c:when
										test='${pageInfo.currentPage+2>pageInfo.totalPages&&pageInfo.currentPage+1<=pageInfo.totalPages }'>
										<c:set var="endPage" value="${pageInfo.currentPage+1}"
											scope="page"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="endPage" value="${pageInfo.currentPage}"
											scope="page"></c:set>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="${pageInfo.currentPage}" end="${endPage}"
									var="i">
									<li
										class="<c:if test='${i==pageInfo.currentPage}'>active</c:if>"><a
										href="javascript:void(0)" value="${i}">${i}</a></li>
								</c:forEach>
							</c:when>
						</c:choose>
						<li
							class='<c:if test="${pageInfo.currentPage==pageInfo.totalPages}">
							disabled
						</c:if>'><a
							href="javascript:void(0)" aria-label="Next"
							value="${pageInfo.currentPage+1}"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li style="margin-left: 30px;">总记录数:${pageInfo.count},总页数:${pageInfo.totalPages}</li>
							 </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>



<!-- 添加Modal -->
	<div class="modal fade" id="filmAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
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
					<form>
						<div class="form-group">
							<label for="filmName">视频名称</label> <input type="text"
								class="form-control" id="filmName" name="filmName"
								placeholder="filmName">
						</div>
						<div class="form-group">
							<label for="actor">演员</label> <input type="text"
								class="form-control" id="actor" name="actor" placeholder="actor">
						</div>
						<div class="form-group">
							<label for="director">导演</label> <input type="text"
								class="form-control" id="director" name="director"
								placeholder="director">
						</div>
						<div class="form-group">
							<label for="beanlink">豆瓣链接</label> <input type="text"
								class="form-control" id="beanlink" name="beanlink"
								placeholder="beanlink">
						</div>
						<div class="form-group">
							<label for="introduction">简介</label>
							<textarea type="text" class="form-control" rows="3" id="introduction" name="introduction" placeholder="introduction"></textarea>
						</div>
						<div class="form-group">
							<label for="region">地区</label> <select class="form-control"
								name="region" id="region">
								<c:forEach items="${classifyMap.regionList}" var="s">
									<option value="${s.id}">${s.regionName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="time">年代</label> <select class="form-control"
								name="time" id="time">
								<c:forEach items="${classifyMap.timeList}" var="s">
									<option value="${s.id}">${s.year}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="style">类别</label>
							<c:forEach items="${classifyMap.styleList}" var="s">
								<label class="radio-inline">
								<input type="radio" name="style"
								value="${s.id}">${s.styleName}
							</label> 			
							</c:forEach> 
						</div>
						<div class="form-group">
							<label for="typeList">类型</label> 
							<c:forEach items="${classifyMap.typeList}" var="s">
								<label class="checkbox-inline">
								<input type="checkbox" value="${s.id}" name="typeList">
								${s.typeName}
							</label>							
							</c:forEach>
						</div>
						<div class="form-group">
							<label for="statusId">状态</label> 
							<c:forEach items="${classifyMap.statusList}" var="s">
								<label class="radio-inline">
								<input type="radio" name="statusId"
								value="${s.id}">${s.status}
							</label>
							</c:forEach>
						</div>
						<div class="form-group">
							<label for="isVIP">是否收费</label> 
							<label class="radio-inline">
								<input type="radio" name="isVIP"
								value="1"> 免费
							</label> 
							<label class="radio-inline"> <input type="radio"
								name="isVIP" id="isVIP" value="2">
								VIP
							</label>
						</div>
						<div class="form-group">
							<label for="releaseTime">上映时间</label> 
							<input type="date" class="form-control" id='releaseTime' name="releaseTime"/>
						</div>
						<div class="form-group">
							<label for="statrs">星级</label> 
							<input id="statrs" name="starts"/>
						</div>
						<div class="form-group">
							<label for="filmImage">上传海报</label> <input
								type="file" id="fileAdd" name="file">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveButton">保存</button>
				</div>
			</div>		
		</div>
	</div>




	<!-- 修改Modal -->
	<div class="modal fade" id="filmModifyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModifyModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModifyModalLabel">修改</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="filmName">视频名称</label> <input type="text"
								class="form-control" id="filmName" name="filmName"
								placeholder="filmName">
						</div>
						<div class="form-group">
							<label for="actor">演员</label> <input type="text"
								class="form-control" id="actor" name="actor" placeholder="actor">
						</div>
						<div class="form-group">
							<label for="director">导演</label> <input type="text"
								class="form-control" id="director" name="director"
								placeholder="director">
						</div>
						<div class="form-group">
							<label for="beanlink">豆瓣链接</label> <input type="text"
								class="form-control" id="beanlink" name="beanlink"
								placeholder="beanlink">
						</div>
						<div class="form-group">
							<label for="introduction">简介</label>
							<textarea type="text" class="form-control" rows="3" id="introduction" name="introduction" placeholder="introduction"></textarea>
						</div>
						<div class="form-group">
							<label for="region">地区</label> <select class="form-control"
								name="region" id="region">
								<c:forEach items="${classifyMap.regionList}" var="s">
									<option value="${s.id}">${s.regionName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="time">年代</label> <select class="form-control"
								name="time" id="time">
								<c:forEach items="${classifyMap.timeList}" var="s">
									<option value="${s.id}">${s.year}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="style">类别</label>
							<c:forEach items="${classifyMap.styleList}" var="s">
								<label class="radio-inline">
								<input type="radio" name="style"
								value="${s.id}">${s.styleName}
							</label> 			
							</c:forEach> 
						</div>
						<div class="form-group">
							<label for="typeList">类型</label> 
							<c:forEach items="${classifyMap.typeList}" var="s">
								<label class="checkbox-inline">
								<input type="checkbox" value="${s.id}" name="typeList">
								${s.typeName}
							</label>							
							</c:forEach>
						</div>
						<div class="form-group">
							<label for="statusId">状态</label> 
							<c:forEach items="${classifyMap.statusList}" var="s">
								<label class="radio-inline">
								<input type="radio" name="statusId"
								value="${s.id}">${s.status}
							</label>
							</c:forEach>
						</div>
						<div class="form-group">
							<label for="isVIP">是否收费</label> 
							<label class="radio-inline">
								<input type="radio" name="isVIP"
								value="1"> 免费
							</label> 
							<label class="radio-inline"> <input type="radio"
								name="isVIP" id="isVIP" value="2">
								VIP
							</label>
						</div>
						<div class="form-group">
							<label for="releaseTime">上映时间</label> 
							<input type="date" class="form-control" id='releaseTime' name="releaseTime"/>
						</div>
						<div class="form-group">
							<label for="statrs">星级</label> 
							<input id="statrs" name="starts"/>
						</div>
						<div class="form-group">
							<label for="file">重新上传</label> <input
								type="file" id="fileModify" name="file">
							原本文件：<span id="filmImage"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="modifyButton">修改</button>
				</div>
			</div>		
		</div>
	</div>
</body>

	<script src="${basePath}/statics/js/docs.min.js"></script>     
    <script type="text/javascript">
	$(function() {

// 		搜索
		$("#search").click(function(){

			var searchName=$("#searchName").val();
			if(searchName!=null&&searchName.trim()!=''){
				location.href="${basePath}/Admin_toManageFilmPage.action?searchName="+searchName;
			}
		})
			

		

		

// 		带上搜索条件的翻页
		$("#paging li a").click(function() {
			if (!$(this).parent().hasClass("disabled")) {
				
				
				var page = $(this).attr("value")
				var pageIndex = (page - 1) * ${pageInfo.pageSize};

				var searchName=$("#searchName").val();

				var url="${basePath}/Admin_toManageFilmPage.action?pageInfo.pageIndex="+pageIndex;
				if(searchName!=null&&searchName.trim()!=''){
					url+="&searchName="+searchName;
				}
				location.href=url;

			}
		})


			$(".appearModifyForm").each(function() {
	    $(this).bind("click", function() {
	    	var id=$(this).val();
			modifyData(id);
			$("#modifyButton").val(id)
	    });
	});
	
	$("button[name=statusId]").each(function() {
	    $(this).bind("click", function() {
	    	var statusId=$(this).val();
	    	var id=$(this).attr("id");
	    	changeStatus(id,statusId);
	    });
	});
		
		$("#saveButton").click(function(){
			ajaxAddOrModifyButton("#filmAddModal",null,"fileAdd");
			emptyData();
		})
		

		$("#modifyButton").click(function(){
			var id=$(this).val();
			ajaxAddOrModifyButton("#filmModifyModal",id,"fileModify");    	
			})



		


		
	})




//
function modifyData(id){

	$.ajax({
		url : "${basepath}/video/Admin_filmById.action",
		type : "POST",
 		data : {
 	 			"id":id,
 	 		},
 	 	dataType : "json",	
		success : function(result) {		
			$("#filmModifyModal #filmName").val(result["filmName"]);
			$("#filmModifyModal #filmImage").text(result["filmImage"]);
			$("#filmModifyModal #actor").val(result["actor"]);
			$("#filmModifyModal #director").val(result["director"]);
			$("#filmModifyModal #introduction").val(result["introduction"]);
			var releaseTime=result["releaseTime"];
			if(releaseTime!=null){
				releaseTime=releaseTime.replace("T00:00:00","");
			}
			$("#filmModifyModal #releaseTime").val(releaseTime);
			$("#filmModifyModal #beanlink").val(result["beanlink"]);
			$("#filmModifyModal #statrs").rating('update',result["statrs"]);
			$("#filmModifyModal #region").val(result["region"]);
			$("#filmModifyModal #time").val(result["time"]);
			  
			$("#filmModifyModal input[name=statusId][value="+result["statusId"]+"]").attr("checked",'checked')
			$("#filmModifyModal input[name=style][value="+result["style"]+"]").attr("checked",'checked')
			$("#filmModifyModal input[name=isVIP][value="+result["isVIP"]+"]").attr("checked",'checked')
			$.each(result["typeList"],function(index,typeValue){
				$("#filmModifyModal input[name=typeList][value="+typeValue+"]").attr("checked",'checked')
			});
			
			$("#filmModifyModal").modal({
				backdrop : 'static'
			});
		}
	})
}


//添加和修改通用
function ajaxAddOrModifyButton(modal,id,fileID) {
	
	var temp="";
	$(modal+" input[name=typeList]:checked").each(function(i){
	 temp+=$(this).val()+",";	
		
	});
    $.ajaxFileUpload({
            url: "${basepath}/video/Admin_addOrUpdateFilm.action", //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: fileID, //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            data: {
                'film.id': id,
 	 			'film.filmName':$(modal+" #filmName").val(),
 	 			'film.actor':$(modal+" #actor").val(),
 	 			'film.director':$(modal+" #director").val(),
 	 			'film.beanlink':$(modal+" #beanlink").val(),
 	 			'film.introduction':$(modal+" #introduction").val(),
 	 			'film.region.id':$(modal+" #region").val(),
 	 			'film.time.id':$(modal+" #time").val(),
 	 			'film.style.id':$(modal+" input[name=style]:checked").val(),
 	 			'film.isVIP':$(modal+" input[name=isVIP]:checked").val(),
 	 			'film.statrs':$(modal+" #statrs").val(),
 	 			'film.releaseTime':$(modal+" #releaseTime").val(),
 	 			'film.statusId':$(modal+" input[name=statusId]:checked").val(),
  	 			'temp':temp,
  	 			'film.filmImage':$(modal+" #filmImage").text(),
 	 		},
            success: function (data, status)  //服务器成功响应处理函数
            {                         
                $(modal).modal('hide'); 	
                alert("操作成功！")

            },
            error: function (data, status, e)//服务器响应失败处理函数
            {       
                alert(e);
            }
  		})
    return false;
}

function emptyData(){
		$("#filmAddModal  #filmName").val("");
		$("#filmAddModal #actor").val("");
		$("#filmAddModal #director").val("");
		$("#filmAddModal #beanlink").val("");
		$("#filmAddModal #introduction").val("");
		$("#filmAddModal #region").val("");
		$("#filmAddModal #time").val("");
		$("#filmAddModal #releaseTime").val("");
		$("#filmAddModal #statrs").rating('update',0);
		
		$("#filmAddModal input[name=style]:eq(0)").attr("checked","checked")
		$("#filmAddModal input[name=isVIP]:eq(0)").attr("checked","checked")
		$("#filmAddModal input[name=statusId]:eq(0)").attr("checked","checked")
	 	$("#filmAddModal input[name=typeList]:checked").each(function(){
	 		$(this).prop("checked",false);
	 	})	
}


function changeStatus(id,statusId){
	$.ajax({
		url : "${basepath}/video/Admin_changeFilmStatus.action",
		type : "POST",
 		data : {
 	 			"id":id,
 	 			"film.statusId":statusId,
 	 		},
 	 	dataType : "json",	
		success : function(result) {
			if(result["isSuccess"]){

				var i="#"+id+"[name=statusId]";

				$(i).parent().prev().empty();
				
				if(statusId=="1"){
					
					$('<span class="label label-defaunt radius" style="color:red">已下架</span>').appendTo($(i).parent().prev());
					$(i).attr("value",2);
					
					alert("下架成功！")
				}else{

					$('<span class="label label-success radius">上映</span>').appendTo($(i).parent().prev());

					$(i).attr("value",1);
					alert("上映成功！")
				}
				

				
				
				
			}else{
				alert("操作失败！")
			}	
		}
	})

}
	

	
	
	
	
	
	
	
	
	
</script>

</html>
