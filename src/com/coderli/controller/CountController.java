package com.coderli.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coderli.service.NewsService;
import com.google.gson.Gson;

/**
 * 此控制主要用来统计点赞次数
 * @author lishichun
 *
 */
@Controller("countController")
@SuppressWarnings("all")
@RequestMapping("/count")
public class CountController{
	@Resource(name="newsService")
	private NewsService service = null;
	
	@RequestMapping("/add")
	@ResponseBody
	public String count(String newsId){
		return newsId;
		
	}
}
