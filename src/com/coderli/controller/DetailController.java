package com.coderli.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.coderli.service.NewsService;
/**
 * 咨询详情
 * @author lishichun
 *
 */
@Controller
@RequestMapping("/detail")
public class DetailController{
	@Resource(name="newsService")
	private NewsService service = null;

	
	@RequestMapping("/show")
	public String show(Integer newsId,WebRequest wr){
		Map news =service.selectOne(newsId);
		wr.setAttribute("news", news, WebRequest.SCOPE_REQUEST);
		return "/content.jsp";
	}
}
