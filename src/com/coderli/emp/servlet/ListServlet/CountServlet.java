package com.coderli.emp.servlet.ListServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.coderli.service.NewsService;
import com.coderli.service.NewsServiceImpl;
import com.google.gson.Gson;
@SuppressWarnings("all")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsService service = new NewsServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String newsId=req.getParameter("id");
		Map result = new HashMap<>();
		if(newsId==null||"".equals(newsId.trim())){
			result.put("msg", "请求不合法");
			result.put("status", false);
		}else{
			service.addCount(newsId);
			int count=service.getCount(newsId);
			result.put("msg", "操作成功");
			result.put("count",count);
			result.put("status", true);
		}
		resp.setContentType("application/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().print(new Gson().toJson(result));
	}
}
