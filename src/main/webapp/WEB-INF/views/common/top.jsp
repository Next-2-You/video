<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!--导航-->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
				<div class="row">
					<!--小屏幕导航按钮和logo-->
					<div class="navbar-header">
						<button class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a href="${bashPath}/video/Film_toIndexPage.action" class="navbar-brand">视频网</a>
					</div>
					<!--小屏幕导航按钮和logo-->
					<!--导航-->
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${bashPath}/video/Film_toIndexPage.action">首页</a></li>
							<li><a href="${basePath}/Film_toSearchPage.action?rightMore=1">电影</a></li>
							<li><a href="${basePath}/Film_toSearchPage.action?rightMore=2">电视剧</a></li>
							<li><a href="${basePath}/Film_toSearchPage.action?rightMore=3">动漫</a></li>
							<li><a href="${basePath}/Classify_toClassifyPage.action">分类</a></li>
							<li><a href="#app">联系客服</a></li>
							<c:choose>
								<c:when test="${user!=null}">
									<li class="visible-xs">
										<a href="#contact">个人信息</a>
									</li>
									<li class="hidden-xs">
										<img src="${basePath}/statics/images/a.png" alt="..." class="img-circle img-responsive" style="width: 50px; height: 50px;margin-top: 10px;margin-right: 20px">
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="#contact">登陆</a>
									</li>
									<li>
										<a href="#contact">注册</a>
									</li>
								</c:otherwise>
							</c:choose>
							<li><input id="search" type="text" class="form-control" placeholder="Search" style="width: 85%" value="${searchName}"></li>
						</ul>
				</div>
				</div>
		</div>
	</nav>
<form action="${bashPath}/video/Film_toSearchPage.action" method="post" id="hiddenSeach">
	<input id="hiddenSearchName" type="hidden" name="searchName" value="${searchName}"/>
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}"/>
	<input id="searchPageIndex" type="hidden" name="pageInfo.pageIndex"/>
</form>
	<!--导航-->
<script type="text/javascript">
	$(function(){
		$("#search").keydown(function(e){
			if(e.keyCode==13){
				var searchName=$(this).val();
				$("#hiddenSearchName").val(searchName);
				var pageIndex=0;
				$("#searchPageIndex").val(pageIndex);
				$("#hiddenSeach").submit();
			}
			})
		})
</script>