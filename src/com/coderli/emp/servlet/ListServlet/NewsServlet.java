package com.coderli.emp.servlet.ListServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.coderli.service.NewsService;
import com.coderli.service.NewsServiceImpl;
import com.google.gson.Gson;
@SuppressWarnings("all")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsService service = new NewsServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String oper = req.getParameter("oper");
		if("main".equals(oper)){
			selectHot(req,resp);
		}else if("append".equals(oper)){
			appendNews(req,resp);
		}else if("channelList".equals(oper)){
			appendChannel(req,resp);
		}else{
			resp.getWriter().write("url不存在，请您重新确定url地址");
		}
	}

	private void appendChannel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String catagory=req.getParameter("catagory");
		Integer index=Integer.parseInt(req.getParameter("index"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		int startIndex=(index-1)*rows;
		List<Map> list =service.appendChannelList(startIndex,rows,catagory);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(list));
	}

	private void appendNews(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer index=Integer.parseInt(req.getParameter("index"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		int startIndex=(index-1)*rows;
		List<Map> list = service.appendNews(startIndex+"",rows+"");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(list));
	}

	private void selectHot(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map> list = service.selectHotNews();
		req.setAttribute("list", list);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}
