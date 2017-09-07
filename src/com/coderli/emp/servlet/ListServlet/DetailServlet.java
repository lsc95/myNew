package com.coderli.emp.servlet.ListServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderli.entity.Comment;
import com.coderli.entity.News;
import com.coderli.service.CommentService;
import com.coderli.service.CommentServiceImpl;
import com.coderli.service.NewsService;
import com.coderli.service.NewsServiceImpl;

public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsService nservice = new NewsServiceImpl();
	private CommentService cservice = new CommentServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String newsId=req.getParameter("id");
		if(newsId==null||"".equals(newsId)){
			resp.getWriter().print("请求的页面不存在,请检查url");
			return;
		}
		News news =nservice.getNewsDetail(newsId);
		List<News> advices=nservice.getAdviceNews();
		List<Comment> comments = cservice.selectTopComments(newsId, 0, 10);
		req.setAttribute("news", news);
		req.setAttribute("comments", comments);
		req.setAttribute("advices", advices);
		req.getRequestDispatcher("content.jsp").forward(req, resp);
	}
}
