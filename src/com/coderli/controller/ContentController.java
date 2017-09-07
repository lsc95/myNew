package com.coderli.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import com.coderli.entity.News;
import com.coderli.service.NewsService;

@Controller("contentController")
@RequestMapping("/content")
public class ContentController {
	@Resource(name="newsService")
	private NewsService service = null;

	@RequestMapping("/list")
	public String info(String channel,WebRequest request){
		if (channel == null || "".equals(channel)) {
			channel="edu";
		}
		List<News> list =service.getChannelNew(channel);
		request.setAttribute("list", list,WebRequest.SCOPE_REQUEST);
		request.setAttribute("channel", channel,WebRequest.SCOPE_REQUEST);
		return "channel.jsp";
	}
}
