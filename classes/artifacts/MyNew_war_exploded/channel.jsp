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
  <link rel="stylesheet" href="css/wap.css">
  <title>内容页列表页</title>
</head>
<body style="background:#ececec">
  <div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a href="#left-link" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>

        <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
        </div>
      </header>
    </div>
    <div class="pet_content pet_content_list">
      <div class="pet_article_like">
        <div class="pet_content_main pet_article_like_delete">
          <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
            <div class="am-list-news-bd">
              <ul class="am-list">
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
			                <div class="pet_list_tag pet_list_tag_xxs">${news.channel }</div>
			            </div>
			        </div>
			        <div class=" am-u-sm-8 am-list-main pet_list_one_nr">
			            <h3 class="am-list-item-hd pet_list_one_bt"><a href="${pageContext.request.contextPath}/detail/show?newsId=${news.news_id }" class="">${news.title}</a></h3>
			            <div class="am-list-item-text pet_list_one_text">${news.content }</div>
			        </div>
			          <div class="am-u-sm-4 am-list-thumb">
			            <a href="detail?id=${news.news_id }" class="">
			              <img src="${news.pic }" class="pet_list_one_img" alt=""/>
			            </a>
			          </div>
			      </li>
                </c:forEach>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="pet_article_footer_info">Copyright(c)2015 PetShow All Rights Reserved</div>
      </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/amazeui.min.js"></script>
    <script type="text/javascript">
	var index=1;
	var rows=10;
$(function(){
	var channel ="${channel}";
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
	function append(){
		 if($(window).height() + $(window).scrollTop()>$(document).height()-50){
			 $(window).unbind("scroll");
			 index++;
			$.get("news?oper=channelList&catagory=${channel}&index="+index+"&rows="+rows,function(data){
				var news=eval(data);
				for(var i=0;i<news.length;i++){
					console.log(news[i]);
					var clone=$(".am-list").children(":first").clone();
					var tx=clone.children(0);
					tx[0].innerHTML="<div class='pet_list_one_info_l'> <div class='pet_list_one_info_name'> </div></div><div class='pet_list_one_info_r'><div class='pet_list_tag pet_list_tag_xxs'>"+news[i].channel+"</div></div>";
					tx[1].innerHTML="<h3 class='am-list-item-hd pet_list_one_bt'><a href='detail?id="+news[i].news_id+"'>"+news[i].title+"</a></h3><div class='am-list-item-text pet_list_one_text'>"+news[i].content+"</div>";
					tx[2].innerHTML=" <a href='detail?id="+news[i].news_id+"' ><img src='"+news[i].pic+"' class='pet_list_one_img' /></a>";
					$(".am-list").append(clone);
					$(window).unbind("scroll").bind("scroll", function(e){  
						append();
					}); 
				}
				
			});
		 }
	}
	$(window).unbind("scroll").bind("scroll", function(e){  
		append();
	});  
});
</script>
</body>
</html>