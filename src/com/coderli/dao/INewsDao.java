package com.coderli.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.coderli.entity.News;
@SuppressWarnings("all")
public interface INewsDao {
	List<News> getChannelNew(String channel);
	News getNewsDetail(String newsId);
	void addCount(String newsId);
	List<News> getAdviceNews();
	List<Map> appendNews(@Param("st")Integer index, @Param("r")Integer rows);
	int getCount(String newsId);
	List<Map> appendChannelList(@Param("st")int startIndex, @Param("r")Integer rows, @Param("catagory")String catagory);
}
