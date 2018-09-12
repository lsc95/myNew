package com.coderli.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import com.coderli.service.NewsService;
import com.coderli.util.DataUtil;

/**
 * 主页
 * @author lishichun
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController{
	@Autowired
	private NewsService service = null;

	@RequestMapping(value="/getNewData")
	private String getData(){
		List<Map> channels=service.getAllChannel();
		for (Map map : channels) {
			String channel = (String) map.get("channel");
			Integer channelId = (Integer) map.get("channel_id");
			try {
				String data = DataUtil.getData(channel, "10", "0");
				DataUtil.saveData(channelId,data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "/index.jsp";
	}
	
	@RequestMapping(value="/selectHot")
	private String selectHot(WebRequest req) {
		List<Map> channels=service.getAllChannel();
		List<Map> list = service.selectHotNews();
		List<Map> banners = service.getBanner();
		req.setAttribute("list", list, WebRequest.SCOPE_REQUEST);
		req.setAttribute("channels", channels, WebRequest.SCOPE_REQUEST);
		req.setAttribute("banners", banners, WebRequest.SCOPE_REQUEST);
		return "/main.jsp";
	}
}
