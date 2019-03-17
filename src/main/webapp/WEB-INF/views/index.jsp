<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
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
.carousel-inner {
	height: 500px;
}

#film, #comic, #tvPlay {
	padding: 40px 0;
}

#film img {
	height: 200px;
}

#tvPlay img {
	height: 200px;
}

#comic img {
	height: 200px;
}
</style>

<body>

	<%@include file="common/top.jsp"%>
	<!--broadcast-->

	<section id="broadcast" style="margin-top: 70px;">
		<div class="container">
			<div class="row">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<c:forEach items="${filmMap.broadcastFilm}" var="broadcastFilm"
							varStatus="status">
							<div class='item<c:if test="${status.first}"> active</c:if>'>
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${broadcastFilm.id}" target="_blank">
									<img src="${basePath}/statics/images/${broadcastFilm.filmImage}"
									class="img-responsive" alt="${broadcastFilm.filmName}" />					
								</a>
								<div class="carousel-caption">${broadcastFilm.filmName}</div>
							</div>
						</c:forEach>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>

			</div>

		</div>
	</section>
	<!--broadcast-->

	<!--film-->
	<section id="film">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-8 wow fadeInLeft">
					<h4 style="display: inline-block;">电影</h4>
					<span class="more"><a href="${basePath}/Film_toSearchPage.action?leftMore=1">更多&gt;</a></span>
					<div class="row">
						<c:forEach items="${filmMap.leftFilm}" var="leftFilm" begin="0"
							end="3">
							<div class="col-xs-6 col-md-3">
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${leftFilm.id}" class="thumbnail" target="_blank"> <img
									src="${basePath}/statics/images/${leftFilm.filmImage}"
									alt="${leftFilm.filmName}">
								</a>
							</div>
						</c:forEach>
					</div>
					<div class="row">
						<c:forEach items="${filmMap.leftFilm}" var="leftFilm" begin="4"
							end="7">
							<div class="col-xs-6 col-md-3">
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${leftFilm.id}" class="thumbnail" target="_blank"> <img
									src="${basePath}/statics/images/${leftFilm.filmImage}"
									alt="${leftFilm.filmName}">
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-xs-12 col-md-4 wow fadeInRight">
					<h4 style="display: inline-block;">热门电影推荐</h4>
					<span class="more"><a href="${basePath}/Film_toSearchPage.action?rightMore=1">更多&gt;</a></span>
					<div class="row">
						<div style="height: 435px;">
							<ul class="list-group">
							<c:forEach items="${filmMap.rightFilm}" var="rightFilm" varStatus="filmStatus">
							  <li class="list-group-item">
							  	<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${rightFilm.id}" target="_blank"><span class="badge">${filmStatus.index+1}</span>${rightFilm.filmName}</a>
							  </li>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<!--tvPlay-->
	<section id="tvPlay">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-8 wow fadeInLeft">
					<h4 style="display: inline-block;">电视剧</h4>
					<span class="more"><a href="${basePath}/Film_toSearchPage.action?leftMore=2">更多&gt;</a></span>
					<div class="row">
						<c:forEach items="${filmMap.leftTvPlay}" var="leftTvPlay" begin="0"
							end="3">
							<div class="col-xs-6 col-md-3">
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${leftTvPlay.id}" class="thumbnail" target="_blank"> <img
									src="${basePath}/statics/images/${leftTvPlay.filmImage}"
									alt="${leftTvPlay.filmName}">
								</a>
							</div>
						</c:forEach>
					</div>
					<div class="row">
						<c:forEach items="${filmMap.leftTvPlay}" var="leftTvPlay" begin="4"
							end="7">
							<div class="col-xs-6 col-md-3">
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${leftTvPlay.id}" class="thumbnail" target="_blank"> <img
									src="${basePath}/statics/images/${leftTvPlay.filmImage}"
									alt="${leftTvPlay.filmName}">
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-xs-12 col-md-4 wow fadeInRight">

					<h4 style="display: inline-block;">热门电视剧推荐</h4>
					<span class="more"><a href="${basePath}/Film_toSearchPage.action?rightMore=2">更多&gt;</a></span>
					<div class="row">
						<div style="height: 435px;">
							<ul class="list-group">
							<c:forEach items="${filmMap.rightTvPlay}" var="rightTvPlay" varStatus="tvPlayStatus">
							  <li class="list-group-item">
							  	<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${rightTvPlay.id}" target="_blank"><span class="badge">${tvPlayStatus.index+1}</span>${rightTvPlay.filmName}</a>
							  </li>
							</c:forEach>
							</ul>
						
						</div>

					</div>

				</div>
			</div>
		</div>
	</section>

	
	<!--comic-->
	<section id="comic">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-8 wow fadeInLeft">
					<h4 style="display: inline-block;">动漫</h4>
					<span class="more"><a href="${basePath}/Film_toSearchPage.action?leftMore=3">更多&gt;</a></span>
					<div class="row">
						<c:forEach items="${filmMap.leftComic}" var="leftComic" begin="0"
							end="3">
							<div class="col-xs-6 col-md-3">
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${leftComic.id}" class="thumbnail" target="_blank"> <img
									src="${basePath}/statics/images/${leftComic.filmImage}"
									alt="${leftComic.filmName}">
								</a>
							</div>
						</c:forEach>
					</div>
					<div class="row">
						<c:forEach items="${filmMap.leftComic}" var="leftComic" begin="4"
							end="7">
							<div class="col-xs-6 col-md-3">
								<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${leftComic.id}" class="thumbnail" target="_blank"> <img
									src="${basePath}/statics/images/${leftComic.filmImage}"
									alt="${leftComic.filmName}">
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-xs-12 col-md-4 wow fadeInRight">

					<h4 style="display: inline-block;">热门动漫推荐</h4>
					<span class="more"><a href="${basePath}/Film_toSearchPage.action?rightMore=3">更多&gt;</a></span>
					<div class="row">
						<div style="height: 435px;">
							<ul class="list-group">
							<c:forEach items="${filmMap.rightComic}" var="rightComic" varStatus="comicStatus">
							  <li class="list-group-item">
							  	<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${rightComic.id}" target="_blank"><span class="badge">${comicStatus.index+1}</span>${rightComic.filmName}</a>
							  </li>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	

	<%@include file="common/bottom.jsp"%>



</body>

</html>