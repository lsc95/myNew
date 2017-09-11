package com.coderli.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.coderli.entity.News;
@SuppressWarnings("all")
public interface NewsDao {
	public List<Map> getMainTop();
	public List<Map> getChannels();
}
