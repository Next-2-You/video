<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script type="text/javascript"
	src="${basePath}/statics/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript">
	/*   var flashvars={
	    f:'http://movie.ks.js.cn/flv/other/1_0.mp4',  //视频地址
	    i:'statics/images/1476253019826.jpg', //指定播放器暂停情况下显示图片
	    s:0,  //使用网址形式调用视频地址
	    c:0, //只在站内使用播放器，调用ckplayer.js中ckstyle()函数
	    h:3, //按后缀名自动判断按关键帧（mp4）还是时间点(flv)进行拖动
	    e:1 //支持HTML5，播放结束时循环播放
	    };
	    var video=['C:\Users\Next 2 You\Desktop\test.mp4->video/mp4'];
	     CKobject.embed('/statics/ckplayer/ckplayer.swf','online','ckplayer_online','600','400',false,flashvars,video);*/
</script>
<style type="text/css">
#view {
	margin-top: 100px;
}
</style>
<body>

	<%@include file="common/top.jsp"%>
	<section id="view">
		<div class="container">
			<div class="row">
<!-- 			class="visible-lg visible-md" -->
				<div id="video" style="height: 658px;"></div>
			</div>
		</div>
	</section>
	<section id="download">
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${downLoadResourceList==null}">
						<c:choose>
							<c:when test="${filmIsVIP==true}">
								<h4>该视频为VIP视频，无法下载！</h4>
							</c:when>
							<c:otherwise>
								<h4>请先登录才能下载该视频！</h4>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<h4 style="margin-top: 40px; margin-bottom: 15px;">下载</h4>
						<div class="btn-group" role="group">
							<c:forEach items="${downLoadResourceList}" var="downloadResource">
								<button type="button" class="btn btn-default">
									<a href="${downloadResource.link}">${downloadResource.resolution.resolution}</a>
								</button>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>



	<%@include file="common/bottom.jsp"%>

</body>

<script type="text/javascript">
	var videoObject = {
		container : '#video', //容器的ID或className
		variable : 'player', //播放函数名称
		flashplayer : true,
		poster : 'material/poster.jpg', //封面图片
		video : [ //视频地址列表形式
				<c:forEach items="${watchResourceList}" var="watchResource">[
						'${basePath}/statics/resource/${watchResource.link}',
						'video/mp4', '${watchResource.resolution.resolution}',
						0], </c:forEach> ]
	};
	var player = new ckplayer(videoObject);
</script>

</html>