package com.coderli.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderli.dao.NewsDao;
import com.coderli.entity.News;
@Service("newsService")
@Transactional(rollbackFor=Exception.class)
@SuppressWarnings("all")
public class NewsServiceImpl implements NewsService {
	@Resource(name="newsDao")
	private NewsDao dao=null;

	@Override
	public List<Map> selectHotNews() {
		
		return dao.getMainTop();
	}
	public List<Map> getAllChannel(){
		return dao.getChannels();
	}
	
}
