<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/wap.css">
    <title>内容页</title>
</head>
<body style="background:#ececec">
<div class="pet_mian" >
    <div class="pet_head">
  <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
      <div class="am-header-left am-header-nav ">
          <a href="#left-link" class="iconfont pet_head_jt_ico">&#xe601;</a>
      </div>

      <h1 class="am-header-title pet_article_user">
      <span class="pet_article_user_ico"><img src="img/a1.png" alt="" class=""></span>
      <span class="pet_article_user_name">${news.src }</span>
      </h1>

      <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
      </div>
  </header>
</div>
<div class="pet_content">
	<div class="pet_content_block">
	  <article data-am-widget="paragraph" class="am-paragraph am-paragraph-default pet_content_article" data-am-paragraph="{ tableScrollable: true, pureview: true }">
	  <h1 class="pet_article_title">${news.title }</h1>
	  <div class="pet_article_user_time">发表于：<fmt:formatDate value="${news.time}" pattern="yyyy-MM-dd  HH:mm:ss" var="d" />${d}</div>
	      <img src="${news.pic }">
	     ${news.content }
	  </article>
	        <ul class="like_share_block">
	        <li><a class="link_share_button" id="addCount"><i class="iconfont share_ico_link">&#xe62f;</i> <span id="myCount">116</span></a></li>
	        <li><a class="link_share_button" href="###"><i class="iconfont share_ico_wx">&#xe630;</i>微信</a></li>
	        <li><a class="link_share_button" href="###"><i class="iconfont share_ico_pyq">&#xe62e;</i>朋友圈</a></li>
	      </ul>
	</div>
	<div class="pet_comment_list">
	  <div class="pet_comment_list_wap"><div class="pet_comment_list_title">精彩评论</div>
	  <div data-am-widget="tabs" class="am-tabs am-tabs-default pet_comment_list_tab" >
	      <ul class="am-tabs-nav am-cf pet_comment_list_title_tab">
	          <li class="am-active"><a href="[data-tab-panel-0]">人气</a></li>
	          <li class=""><a href="[data-tab-panel-1]">最新</a></li>
	          <li class=""><a href="[data-tab-panel-2]">最早</a></li>
	      </ul>
	      <div class="am-tabs-bd pet_pl_list">
	          <div data-tab-panel-0 class="am-tab-panel am-active">
	            <%--<c:forEach items="${comments}" var="comment">--%>
		            <%--<div class="pet_comment_list_block">--%>
		              <%--<div class="pet_comment_list_block_l"><img src="img/a4.png" alt=""></div>--%>
		              <%--<div class="pet_comment_list_block_r">--%>
		                <%--<div class="pet_comment_list_block_r_info">Drary</div>--%>
		                <%--<div class="pet_comment_list_block_r_text">${comment.content}</div>--%>
		                <%--<div class="pet_comment_list_block_r_bottom">--%>
		                  <%--<div class="pet_comment_list_bottom_info_l">1小时前</div>--%>
		                  <%--<div class="pet_comment_list_bottom_info_r">--%>
		                  <%--<span><i class="iconfont">&#xe631;</i>${comment.count}</span>--%>
		                  <%--<span> 回复</span></div>--%>
		                <%--</div>--%>
		              <%--</div>--%>
		            <%--</div>--%>
	            <%--</c:forEach>--%>
					<div class="pet_comment_list_block">
						<div class="pet_comment_list_block_l"><img src="img/a3.png" alt=""></div>
						<div class="pet_comment_list_block_r">
							<div class="pet_comment_list_block_r_info">AllThe</div>
							<div class="pet_comment_list_block_r_text">表紙の裏に移らないよに あけた一枚目のページの裏に透けた文字めくろうとして 指がとまって</div>
							<div class="pet_comment_list_block_r_bottom">
								<div class="pet_comment_list_bottom_info_l">30分钟前</div>
								<div class="pet_comment_list_bottom_info_r">
									<span><i class="iconfont">&#xe631;</i>5 </span>
									<span> 回复</span></div>
							</div>
						</div>
					</div>
	          </div>
	          <div data-tab-panel-1 class="am-tab-panel ">
	              
	            <div class="pet_comment_list_block">
	              <div class="pet_comment_list_block_l"><img src="img/a3.png" alt=""></div>
	              <div class="pet_comment_list_block_r">
	                <div class="pet_comment_list_block_r_info">AllThe</div>
	                <div class="pet_comment_list_block_r_text">表紙の裏に移らないよに あけた一枚目のページの裏に透けた文字めくろうとして 指がとまって</div>
	                <div class="pet_comment_list_block_r_bottom">
	                  <div class="pet_comment_list_bottom_info_l">30分钟前</div>
	                  <div class="pet_comment_list_bottom_info_r">
	                  <span><i class="iconfont">&#xe631;</i>5 </span>
	                  <span> 回复</span></div>
	                </div>
	              </div>
	            </div>
	          </div>
	          <div data-tab-panel-2 class="am-tab-panel ">
	            <div class="pet_comment_list_block">
	              <div class="pet_comment_list_block_l"><img src="img/a4.png" alt=""></div>
	              <div class="pet_comment_list_block_r">
	                <div class="pet_comment_list_block_r_info">Drary</div>
	                <div class="pet_comment_list_block_r_text">无论历经怎样的艰难坎坷，总有你相伴陪我度过。</div>
	                <div class="pet_comment_list_block_r_bottom">
	                  <div class="pet_comment_list_bottom_info_l">1小时前</div>
	                  <div class="pet_comment_list_bottom_info_r">
	                  <span><i class="iconfont">&#xe631;</i>5 </span>
	                  <span> 回复</span></div>
	                </div>
	              </div>
	            </div>
	          </div>
	      </div>
	  </div>
	  </div>
	</div>
<div class="pet_article_like">
<div class="pet_article_like_title">猜你喜欢</div>



<div class="pet_content_main pet_article_like_delete">
  <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
  <div class="am-list-news-bd">
  <ul class="am-list">
     <!--缩略图在标题右边-->
     <c:forEach items="${advices}" var="n">
	     <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">
			<div class="pet_list_one_info">
			   <div class="pet_list_one_info_l">
			       <div class="pet_list_one_info_name">
			          <fmt:formatDate value="${n.time}" pattern="yyyy-MM-dd  HH:mm:ss" var="d" />${d}
			        </div>
			    </div>
			    <div class="pet_list_one_info_r">
			        <div class="pet_list_tag pet_list_tag_xxs">${n.channel }</div>
			    </div>
			  </div>
			  <div class=" am-u-sm-8 am-list-main pet_list_one_nr">
			      <h3 class="am-list-item-hd pet_list_one_bt"><a href="detail?id=${n.newsId }" class="">${n.title}</a></h3>
			       <div class="am-list-item-text pet_list_one_text">${n.content }</div>
			   </div>
			   <div class="am-u-sm-4 am-list-thumb">
			      <a href="detail?id=${n.newsId }" class="">
			         <img src="${n.pic }" class="pet_list_one_img" alt=""/>
			      </a>
			  </div>
			</li>
		</c:forEach>
    </ul>
  </div>

    </div>

</div>
</div>
<div class="pet_article_footer_info">Copyright(c)2015 Amaze UI All Rights Reserved</div>
</div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script>

$(function(){
    // 动态计算新闻列表文字样式
    auto_resize();
    $(window).resize(function() {
        auto_resize();
    });
    $('.am-list-thumb img').load(function(){
        auto_resize();
    });
    $('.pet_article_like li:last-child').css('border','none');
        function auto_resize(){
        $('.pet_list_one_nr').height($('.pet_list_one_img').height());
                // alert($('.pet_list_one_nr').height());
    }
        $('.pet_article_user').on('click',function(){
            if($('.pet_article_user_info_tab').hasClass('pet_article_user_info_tab_show')){
                $('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_show').addClass('pet_article_user_info_tab_cloes');
            }else{
                $('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_cloes').addClass('pet_article_user_info_tab_show');
            }
        });

        $('.pet_head_gd_ico').on('click',function(){
            $('.pet_more_list').addClass('pet_more_list_show');
       });
        $('.pet_more_close').on('click',function(){
            $('.pet_more_list').removeClass('pet_more_list_show');
        });
});
$(function(){
	$("#addCount").click(function(){
		$.get("addCount?id=${news.newsId}",function(data){
			var result=eval(data);
			if(result){
				//alert("操作成功");
				$("#myCount").html(result.count);
			}else{
				alert("操作失败");
			}
		});
	});
});
</script>
</body>
</html>