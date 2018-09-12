package com.coderli.controller;

import com.coderli.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private NewsService service = null;

    @RequestMapping(value="/")
    private void selectHot(WebRequest req,HttpServletResponse response) throws IOException {
        response.sendRedirect("/news/selectHot");
    }
}
