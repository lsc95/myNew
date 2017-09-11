package com.coderli.controller;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
