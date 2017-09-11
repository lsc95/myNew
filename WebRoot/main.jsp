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
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/wap.css?2">
    <title>首页</title>
</head>
<body>
<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
    <a href="#top" title="">
        <img class="am-gotop-icon-custom" src="img/goTop.png" />
    </a>
</div>

<div class="pet_mian" id="top">
  <div data-am-widget="slider" class="am-slider am-slider-a1" data-am-slider='{"directionNav":false}' >
  <ul class="am-slides">
      <li>
            <img src="img/fl01.png">
            <div class="pet_slider_font">
                <span class="pet_slider_emoji"> (╭￣3￣)╭♡   </span>
                <span>“大白”有望成为现实：充气机器人研究取得进展</span>
            </div>
            <div class="pet_slider_shadow"></div>
      </li>
      <li>
            <img src="img/fl02.png">
            <div class="pet_slider_font">
                <span class="pet_slider_emoji"> []~(￣▽￣)~*　</span>
                <span>已然魔性的雪橇犬哈士奇 —《雪地狂奔》</span>
            </div>
            <div class="pet_slider_shadow"></div>
      </li>
      <li>
            <img src="img/fl03.png">
            <div class="pet_slider_font">
                <span class="pet_slider_emoji"> (｡・`ω´･)　</span>
                <span>《星际争霸2:虚空之遗》国服过审!</span>
            </div>
            <div class="pet_slider_shadow"></div>
      </li>
  </ul>
</div>


<div class="pet_circle_nav">
    <ul class="pet_circle_nav_list">
    	<c:forEach items="${channels}" var="channel">
        <li ><a href="content?channel=${channel.channel_id}" class="iconfont pet_nav_xinxianshi " style="background-color:${channel.color};">${channel.iconfont}</a><span>${channel.channel }</span></li>
        </c:forEach>
    </ul>
    <div class="pet_more_list"><div class="pet_more_list_block">
    <div class="iconfont pet_more_close">×</div>
    </div></div>
</div>
<div class="pet_content_main">
  <div data-am-widget="list_news" class="am-list-news am-list-news-default" >
  <div class="am-list-news-bd">
  <ul class="am-list">
     <!--缩略图在标题右边-->
     <c:forEach items="${list}" var="news">
	      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">
	        <div class="pet_list_one_info">
	            <div class="pet_list_one_info_l">
	                <div class="pet_list_one_info_name">
	                	<fmt:formatDate value="${news.time}" pattern="yyyy-MM-dd  HH:mm:ss" var="d" />
			             ${d}
	                </div>
	            </div>
	            <div class="pet_list_one_info_r">
	                <div class="pet_list_tag pet_list_tag_xxs">${news.channel}</div>
	            </div>
	        </div>
	        <div class=" am-u-sm-8 am-list-main pet_list_one_nr">
	            <h3 class="am-list-item-hd pet_list_one_bt"><a href="detail?id=${news.news_id }" class="detail-url">${news.title}</a></h3>
	            <div class="am-list-item-text pet_list_one_text">${news.content}</div>
	        </div>
	          <div class="am-u-sm-4 am-list-thumb">
	            <a href="detail?id=${news.news_id}" class="pic-url">
	              <img src="${news.pic}" class="pet_list_one_img" alt=""/>
	            </a>
	          </div>
	      </li>
     </c:forEach>
    </ul>
  </div>

    </div>

</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script type="text/javascript">
	var index=1;
	var rows=10;
$(function(){

    // 动态计算新闻列表文字样式
    auto_resize();
    $(window).resize(function() {
        auto_resize();
    });
    $('.am-list-thumb img').load(function(){
        auto_resize();
    });

    $('.am-list > li:last-child').css('border','none');
    function auto_resize(){
        $('.pet_list_one_nr').height($('.pet_list_one_img').height());

    }
        $('.pet_nav_gengduo').on('click',function(){
            $('.pet_more_list').addClass('pet_more_list_show');
       });
        $('.pet_more_close').on('click',function(){
            $('.pet_more_list').removeClass('pet_more_list_show');
        });
});
	$(function(){
		function append(){
			 if($(window).height() + $(window).scrollTop()>$(document).height()-50){
				 $(window).unbind("scroll");
				 index++;
				$.get("news?oper=append&index="+index+"&rows="+rows,function(data){
					var news=eval(data);
					for(var i=0;i<news.length;i++){
						console.log(news[i]);
						var clone=$(".am-list").children(":first").clone();
						var tx=clone.children(0);
						tx[0].innerHTML="<div class='pet_list_one_info_l'> <div class='pet_list_one_info_name'> </div></div><div class='pet_list_one_info_r'><div class='pet_list_tag pet_list_tag_xxs'>"+news[i].channel+"</div></div>";
						tx[1].innerHTML="<h3 class='am-list-item-hd pet_list_one_bt'><a href='detail?id="+news[i].news_id+"'>"+news[i].title+"</a></h3><div class='am-list-item-text pet_list_one_text'>"+news[i].content+"</div>";
						tx[2].innerHTML=" <a href='detail?id="+news[i].news_id+"' ><img src='"+news[i].pic+"' class='pet_list_one_img' /></a>";
						$(".am-list").children(":last").append(clone);
						$(window).unbind("scroll").bind("scroll", function(e){  
							append();
						}); 
					}
					
				});
			 }
		}
		/* $(window).unbind("scroll").bind("scroll", function(e){  
			append();
		});   */
	});
</script>
</body>
</html>