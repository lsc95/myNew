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
		return dao.appendNews(0, 10);
	}

	@Override
	public List<News> getChannelNew(String channel) {
		return dao.getChannelNew(channel);
	}

	@Override
	public News getNewsDetail(String newsId) {
		return dao.getNewsDetail(newsId);
	}

	@Override
	public void addCount(String newsId) {
		dao.addCount(newsId);
	}

	@Override
	public List<News> getAdviceNews() {
		return dao.getAdviceNews();
	}

	@Override
	public List<Map> appendNews(String index, String rows) {
		return dao.appendNews(Integer.parseInt(index),Integer.parseInt(rows));
	}

	@Override
	public int getCount(String newsId) {
		return dao.getCount(newsId);	
	}

	@Override
	public List<Map> appendChannelList(int startIndex, Integer rows,String catagory) {
		return dao.appendChannelList(startIndex,rows,catagory);
	}

}
