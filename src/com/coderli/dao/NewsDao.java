package com.coderli.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.coderli.entity.News;
@SuppressWarnings("all")
public interface NewsDao {
	public List<Map> getMainTop();
	public List<Map> getChannels();
	public List<Map> getBanner();
	public List<Map> getCahnnel(@Param("st")Integer i, @Param("r")Integer j,@Param("id")Integer id);
	public Map getNewsById(Integer newsId);
}
