package com.coderli.service;

import java.util.List;
import java.util.Map;
import com.coderli.entity.News;
@SuppressWarnings("all")
public interface NewsService {

	List<Map> selectHotNews();

	List<Map> getAllChannel();
}
