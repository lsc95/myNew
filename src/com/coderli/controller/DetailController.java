package com.coderli.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import com.coderli.entity.Comment;
import com.coderli.entity.News;
import com.coderli.service.CommentService;
import com.coderli.service.NewsService;

@Controller
@RequestMapping("/detail")
public class DetailController{
	@Resource(name="newsService")
	private NewsService nservice = null;
	@Resource(name="commentService")
	private CommentService cservice = null;
	
	@RequestMapping("/show")
	public String show(String newsId,WebRequest req){
		if(newsId==null||"".equals(newsId)){
			System.out.println("请求的页面不存在,请检查url");
			return null;
		}
		News news =nservice.getNewsDetail(newsId);
		List<News> advices=nservice.getAdviceNews();
		List<Comment> comments = cservice.selectTopComments(newsId, 0, 10);
		req.setAttribute("news", news,WebRequest.SCOPE_REQUEST);
		req.setAttribute("comments", comments,WebRequest.SCOPE_REQUEST);
		req.setAttribute("advices", advices,WebRequest.SCOPE_REQUEST);
		return "content.jsp";
	}
}
