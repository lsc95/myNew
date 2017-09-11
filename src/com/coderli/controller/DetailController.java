package com.coderli.controller;

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
	private NewsService nservice = null;

	
	@RequestMapping("/show")
	public String show(String newsId,WebRequest req){
		return newsId;
	}
}
