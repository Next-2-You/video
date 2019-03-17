<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<ul style="padding-left:0px;" class="list-group">
					<li class="list-group-item tree-closed" >
						<a href="#"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a> 
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon glyphicon-tasks"></i>视频管理<span class="badge" style="float:right">1</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="${basepath}/video/Admin_toManageFilmPage.action" style="color:red"><i class="glyphicon glyphicon-user"></i>视频管理</a> 
							</li>
<!-- 							<li style="height:30px;"> -->
<!-- 								<a href="film.jsp"><i class="glyphicon glyphicon-king"></i>动漫管理</a>  -->
<!-- 							</li> -->
<!-- 							<li style="height:30px;"> -->
<!-- 								<a href="film.jsp"><i class="glyphicon glyphicon-lock"></i>电视剧管理</a>  -->
<!-- 							</li> -->
						</ul>
					</li>
					<li class="list-group-item tree-closed" >
						<a href="#"><i class="glyphicon glyphicon-equalizer"></i>分类管理</a> 
					</li>
				</ul>
			</div>
        </div>
        
 <script type="text/javascript">
            $(function () {

                
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });
 </script>      