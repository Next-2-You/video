<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style type="text/css">
#searchResult {
	margin-top: 90px;
}
#searchResult a{
	text-decoration: none;

}
#searchResult img {
	height: 350px;
	width: 100%;
}

.caption {
	height: 120px;
	text-align: center;
	overflow: hidden;
}

.caption .title {
	font-size: 20px;
	font-family: inherit;
	font-weight: 500;
	line-height: 1.5;
	color: inherit;
}
</style>
<section id="searchResult">
	<div class="container">
		<div class="row">
			<c:forEach items="${pageInfo.pageList}" var="film" begin="0" end="3">
				<div class="col-sm-6 col-md-3" id="${film.id}">
					<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${film.id}" target="_blank">
						<div class="thumbnail">
							<img src="${basePath}/statics/images/${film.filmImage}"
								alt="${film.filmName }" class="img-responsive" />
							<div class="caption">
								<p class="title">${film.filmName }</p>
								<p>${film.introduction}</p>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach items="${pageInfo.pageList}" var="film" begin="4" end="7">
				<div class="col-sm-6 col-md-3">
				<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${film.id}" target="_blank">
					<div class="thumbnail">
						<img src="${basePath}/statics/images/${film.filmImage}"
							alt="${film.filmName }" class="img-responsive" />
						<div class="caption">
							<p class="title">${film.filmName }</p>
							<p>${film.introduction}</p>
						</div>
					</div>
				</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach items="${pageInfo.pageList}" var="film" begin="8" end="11">
				<div class="col-sm-6 col-md-3">
				<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${film.id}" target="_blank">
					<div class="thumbnail">
						<img src="${basePath}/statics/images/${film.filmImage}"
							alt="${film.filmName }" class="img-responsive" />
						<div class="caption">
							<p class="title">${film.filmName }</p>
							<p>${film.introduction}</p>
						</div>
					</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach items="${pageInfo.pageList}" var="film" begin="12"
				end="15">
				<div class="col-sm-6 col-md-3">
				<a href="${basepath}/video/Details_toFilmDetailsPage.action?id=${film.id}" target="_blank">
					<div class="thumbnail">
						<img src="${basePath}/statics/images/${film.filmImage}"
							alt="${film.filmName }" class="img-responsive" />
						<div class="caption">
							<p class="title">${film.filmName }</p>
							<p>${film.introduction}</p>
						</div>
					</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

<section id="paging">
	<div class="container">
		<div class="row">
			<nav aria-label="Page navigation" style="float: right;">
				<ul class="pagination pagination-lg">

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
				</ul>
			</nav>
		</div>

	</div>
</section>


<form
	action="${bashPath}/video/${ClassifyForm}<c:if test="${ClassifyForm==null}">Film_toSearchPage</c:if>.action"
	method="post" id="hiddenForm">
	<c:choose>
		<c:when test="${ClassifyForm==null}">
			<input type="hidden" name="leftMore" value="${leftMore}" />
			<input type="hidden" name="rightMore" value="${rightMore}" />
			<input type="hidden" name="searchName" value="${searchName}" />
		</c:when>
		<c:otherwise>
			<input id="hiddenTimeId" type="hidden" name="timeId"
				value="${timeId}" />
			<input id="hiddenStyleId" type="hidden" name="styleId"
				value="${styleId}" />
			<input id="hiddenTtypeId" type="hidden" name="typeId"
				value="${typeId}" />
			<input id="hiddenRegionId" type="hidden" name="regionId"
				value="${regionId}" />
			<input id="hiddenStatusId" type="hidden" name="statusId"
				value="${statusId}" />
			<input id="hiddenIsVIP" type="hidden" name="isVIP" value="${isVIP}" />
		</c:otherwise>
	</c:choose>
	<input type="hidden" name="pageInfo.pageSize"
		value="${pageInfo.pageSize}" /> <input id="toPageIndex" type="hidden"
		name="pageInfo.pageIndex" />
</form>

<script type="text/javascript">
	$(function() {
		$("#paging li a").click(function() {
			if (!$(this).parent().hasClass("disabled")) {
				var page = $(this).attr("value")
				var pageIndex = (page - 1) * ${pageInfo.pageSize};
				$("#toPageIndex").val(pageIndex);
				$("#hiddenForm").submit();
			}

		})
	})
</script>
