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

/**
 * 主页
 * @author lishichun
 *
 */
@Controller
@RequestMapping("/news")
@SuppressWarnings("all")
public class NewsController{
	@Resource(name="newsService")
	private NewsService service = null;

	@RequestMapping(value="/selectHot")
	private String selectHot(WebRequest req) {
		List<Map> list = service.selectHotNews();
		List<Map> channels=service.getAllChannel();
		List<Map> banners = service.getBanner();
		req.setAttribute("list", list, WebRequest.SCOPE_REQUEST);
		req.setAttribute("channels", channels, WebRequest.SCOPE_REQUEST);
		req.setAttribute("banners", banners, WebRequest.SCOPE_REQUEST);
		return "/main.jsp";
	}
}
