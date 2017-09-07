package com.coderli.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import com.coderli.service.NewsService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/news")
@SuppressWarnings("all")
public class NewsController{
	@Resource(name="newsService")
	private NewsService service = null;
	
	@RequestMapping("/appendChannel")
	@ResponseBody
	private String appendChannel(String catagory,Integer index,Integer rows) {
		int startIndex=(index-1)*rows;
		List<Map> list =service.appendChannelList(startIndex,rows,catagory);
		return new Gson().toJson(list);
	}
	@RequestMapping("/appendNews")
	@ResponseBody
	private String appendNews(Integer index,Integer rows){
		int startIndex=(index-1)*rows;
		List<Map> list = service.appendNews(startIndex+"",rows+"");
		return new Gson().toJson(list);
	}
	@RequestMapping("/selectHot")
	private String selectHot(WebRequest req) {
		List<Map> list = service.selectHotNews();
		req.setAttribute("list", list,WebRequest.SCOPE_REQUEST);
		return "main.jsp";
	}
}
