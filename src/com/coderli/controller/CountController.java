package com.coderli.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coderli.service.NewsService;
import com.google.gson.Gson;

@Controller("countController")
@SuppressWarnings("all")
@RequestMapping("/count")
public class CountController{
	@Resource(name="newsService")
	private NewsService service = null;
	
	@RequestMapping("/add")
	@ResponseBody
	public String count(String newsId){
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
		return new Gson().toJson(result);
	}
}
