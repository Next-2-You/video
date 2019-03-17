<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="common/basequote.jsp"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<title>视频网</title>

</head>
<style type="text/css">
#filmdetails {
	margin-top: 90px;
}

#filmdetails h2 {
	margin-bottom: 50px;
}

#source ul li a{
	color: #444444;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#source ul:first a').click(function(e) {
 			$(this).tab('show');
		})

// 		$("#statrs").rating();

		$("#statrs").rating({
			min: 0,
            max: 5,
            step: 0.5,
            size: 'sm',
            showClear: false,
            showCaption:false,
			
			});
		
	})
</script>
<body>
	<%@include file="common/top.jsp"%>
	<section id="filmdetails">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-4">
					<div class="thumbnail">
						<img src="${basePath}/statics/images/${film.filmImage}" alt="${film.filmName}"
							class="img-responsive" />
					</div>
				</div>
				<div class="col-sm-12 col-md-8">
					<h2>${film.filmName}<c:if test="${film.statusId==1}"><a href="#" class="btn btn-default btn-xs disabled" role="button" style="background-color: #888888;color: #000000;font-weight: 900;margin-left: 6px;">已下架</a></c:if></h2>
					<h5>演员：${film.actor} <c:if test="${film.actor==null}">未知</c:if>
						</h5>
					<h5>类型： 
						<c:forEach items="${film.typeList }" var="type">
							${type.typeName}&nbsp
						</c:forEach>
						<c:if test="${film.typeList==null}">未知</c:if>
					</h5>
					<h5>地区： 
						${film.region.regionName}
						<c:if test="${film.region.regionName==null}">未知</c:if>			
					</h5>
					<h5>导演： 
						${film.director}
						<c:if test="${film.director==null}">未知</c:if>			
					</h5>
					<h5>上映日期：	
						<fmt:formatDate value="${film.releaseTime}" pattern="yyyy/MM/dd"/>
						<c:if test="${film.releaseTime==null}">未知</c:if>			
					</h5>
					<h5>	
						<input id="statrs" value="${film.statrs/2}" readonly/>
						<c:if test="${film.statrs==null}">评分：未知</c:if>			
					</h5>
					<h5>
						<a href="${film.beanlink}" target="_blank">豆瓣链接</a>		
					</h5>
					<span>剧情介绍：
						${film.introduction}
						<c:if test="${film.introduction==null}">未知</c:if>			
					</span>
				</div>
			</div>
		</div>
	</section>
	<section id="source">
		<div class="container">
			<div class="row pre-scrollable">
							<ul class="list-group">
								<c:forEach items="${filmEpisodeList}" var="episode"> 
									<li class="list-group-item"><a href="javascript:void(0)" value="${episode.id}">${episode.episodeNumber}、${episode.episodeName}</a></li>
								</c:forEach>						
							</ul>
			</div>
		</div>
	</section>
	<%@include file="common/bottom.jsp"%>
</body>

<form id="hiddenResourceForm" action="${basepath}/video/Details_toOnlinePage.action" method="post"> 
	<input type="hidden" name="episodeId" />
</form>

<script type="text/javascript">
	$(function(){
		
		$("#source ul li a").click(function(){			
			var value=$(this).attr("value");
			$("#hiddenResourceForm input[name=episodeId]").val(value);
			$("#hiddenResourceForm").submit();
		})
		
	})
	
	
</script>

</html>