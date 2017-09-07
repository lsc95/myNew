package com.coderli.service;

import java.util.List;
import java.util.Map;
import com.coderli.entity.News;
@SuppressWarnings("all")
public interface NewsService {

	List<Map> selectHotNews();

	List<News> getChannelNew(String channel);

	News getNewsDetail(String newsId);

	void addCount(String newsId);

	List<News> getAdviceNews();

	List<Map> appendNews(String index, String rows);

	int getCount(String newsId);

	List<Map> appendChannelList(int startIndex, Integer rows, String catagory);

}
