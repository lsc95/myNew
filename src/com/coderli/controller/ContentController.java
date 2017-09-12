package com.coderli.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.coderli.service.NewsService;

/**
 * 频道列表控制器
 * @author lishichun
 *
 */
@Controller("contentController")
@RequestMapping("/content")
public class ContentController {
	@Resource(name="newsService")
	private NewsService service = null;
	
	@RequestMapping("/show")
	public String showChannel(Integer channelId,WebRequest wr){
		List<Map> list = service.selectHotChannel(channelId);
		wr.setAttribute("list", list, WebRequest.SCOPE_REQUEST);
		return "/channel.jsp";
	}
}
