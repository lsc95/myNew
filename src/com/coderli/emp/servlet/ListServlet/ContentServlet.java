package com.coderli.emp.servlet.ListServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderli.entity.News;
import com.coderli.service.NewsService;
import com.coderli.service.NewsServiceImpl;

public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsService service = new NewsServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String channel = req.getParameter("channel");
		if (channel == null || "".equals(channel)) {
			channel="edu";
		}
		List<News> list =service.getChannelNew(channel);
		req.setAttribute("list", list);
		req.setAttribute("channel", channel);
		req.getRequestDispatcher("channel.jsp").forward(req, resp);
	}
}
