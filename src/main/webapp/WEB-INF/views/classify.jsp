<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
#classify {
	margin-top: 80px;
	margin-bottom: -80px;
}
#classify>div>div>div {
	font-size: 16px;
	font-weight: bold;
	color: black;
	height: 35px;
	line-height: 35px;
	text-align: center;
}

#classify ul {
	text-align: left;
	margin-left: -51px;
}

#classify ul li {
	display: inline;
	margin-right: 18px;
}

#classify ul li a {
	color: #888;
	font-weight: 20px;
	text-decoration: none;
}
#classify ul li a:hover{
	color:#269ABC;
}
#classify ul li a[class="classifyActive"]{
	color: #006400;
	font-weight:900;
}


</style>
<script type="text/javascript">
	$(function(){
		$("#classify ul li a").click(function(){
			if(!$(this).hasClass("classifyActive")){
// 				$(this).parent().siblings().children().removeClass("classifyActive");
// 				$(this).addClass("classifyActive");
				var name="#hiddenClassifyFrom input[name="+$(this).attr("name")+"]";
				var value=$(this).attr("value");
				$(name).val(value);
				$("#hiddenClassifyFrom").submit();
			}
		})	
	})
</script>

<body>

	<%@include file="common/top.jsp"%>
	<section id="classify">
		<div class="container">
			<div class="row">
				<div class="row">
					<div class="col-xs-3 col-md-1">状态</div>
					<div class="col-xs-9 col-md-11">
						<ul>
							<li><a name="statusId"  class="<c:if test='${statusId=="0"}'>classifyActive</c:if>" href="javascript:void(0)" value="0">全部</a></li>
							<c:forEach items="${classifyMap.statusList}" var="s">
								<li><a name="statusId" class="<c:if test='${statusId==s.id}'>classifyActive</c:if>"  href="javascript:void(0)" value="${s.id}">${s.status}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3 col-md-1">类目</div>
					<div class="col-xs-9 col-md-11">
						<ul>
							<li><a name="styleId" class="<c:if test='${styleId=="0"}'>classifyActive</c:if>" href="javascript:void(0)" value="0">全部</a></li>
							<c:forEach items="${classifyMap.styleList}" var="s">
								<li><a name="styleId" class="<c:if test='${styleId==s.id}'>classifyActive</c:if>"  href="javascript:void(0)" value="${s.id}">${s.styleName}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3 col-md-1">类型</div>
					<div class="col-xs-9 col-md-11">
						<ul>
							<li><a name="typeId"  class="<c:if test='${typeId=="0"}'>classifyActive</c:if>" href="javascript:void(0)" value="0">全部</a></li>
							<c:forEach items="${classifyMap.typeList}" var="s">
								<li><a name="typeId" class="<c:if test='${typeId==s.id}'>classifyActive</c:if>" href="javascript:void(0)" value="${s.id}">${s.typeName}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3 col-md-1">地区</div>
					<div class="col-xs-9 col-md-11">
						<ul>
							<li><a name="regionId" class="<c:if test='${regionId=="0"}'>classifyActive</c:if>" href="javascript:void(0)" value="0">全部</a></li>
							<c:forEach items="${classifyMap.regionList}" var="s">
								<li><a name="regionId" class="<c:if test='${regionId==s.id}'>classifyActive</c:if>" href="javascript:void(0)" value="${s.id}">${s.regionName}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="clearfix visible-xs"></div>
				<div class="row">
					<div class="col-xs-3 col-md-1">年代</div>
					<div class="col-xs-9 col-md-11">
						<ul>
							<li><a name="timeId" class="<c:if test='${timeId=="0"}'>classifyActive</c:if>" href="javascript:void(0)" value="0">全部</a></li>
							<c:forEach items="${classifyMap.timeList}" var="s">
								<li><a name="timeId" class="<c:if test='${timeId==s.id}'>classifyActive</c:if>" href="javascript:void(0)" value="${s.id}">${s.year}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="clearfix visible-xs"></div>
				<div class="row">
					<div class="col-xs-3 col-md-1">状态</div>
					<div class="col-xs-9 col-md-11">
						<ul>
							<li><a name="isVIP" class="<c:if test='${isVIP=="0"}'>classifyActive</c:if>" href="javascript:void(0)" value="0">全部</a></li>
							<li><a name="isVIP" class="<c:if test='${isVIP=="1"}'>classifyActive</c:if>" href="javascript:void(0)" value="1">免费</a></li>
							<li><a name="isVIP" class="<c:if test='${isVIP=="2"}'>classifyActive</c:if>" href="javascript:void(0)" value="2">VIP</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/searchresult.jsp" %>

	<%@include file="common/bottom.jsp"%>

<form id="hiddenClassifyFrom" action="${basePath}/Classify_toClassifyPage.action" method="post">
	<input id="hiddenTimeId" type="hidden" name="timeId" value="${timeId}"/>
	<input id="hiddenStyleId" type="hidden" name="styleId" value="${styleId}"/>
	<input id="hiddenTtypeId" type="hidden" name="typeId" value="${typeId}"/>
	<input id="hiddenRegionId" type="hidden" name="regionId" value="${regionId}"/>
	<input id="hiddenStatusId" type="hidden" name="statusId" value="${statusId}"/>
	<input id="hiddenIsVIP" type="hidden" name="isVIP" value="${isVIP}"/>
</form>
</body>

</html>