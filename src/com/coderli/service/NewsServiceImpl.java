package com.coderli.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.coderli.dao.INewsDao;
import com.coderli.entity.News;
import com.coderli.utils.MyBatisUtil;
@SuppressWarnings("all")
public class NewsServiceImpl implements NewsService {

	@Override
	public List<Map> selectHotNews() {
		SqlSession session = null;
		List<Map> list = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			list = dao.appendNews(0, 10);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<News> getChannelNew(String channel) {
		SqlSession session = null;
		List<News> list = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			list = dao.getChannelNew(channel);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public News getNewsDetail(String newsId) {
		SqlSession session = null;
		News news = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			news = dao.getNewsDetail(newsId);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return news;
	}

	@Override
	public void addCount(String newsId) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			dao.addCount(newsId);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
	}

	@Override
	public List<News> getAdviceNews() {
		SqlSession session = null;
		List<News> list = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			list = dao.getAdviceNews();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Map> appendNews(String index, String rows) {
		SqlSession session = null;
		List<Map> list = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			list = dao.appendNews(Integer.parseInt(index),Integer.parseInt(rows));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public int getCount(String newsId) {
		SqlSession session = null;
		int count=0;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			count = dao.getCount(newsId);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return count;
	}

	@Override
	public List<Map> appendChannelList(int startIndex, Integer rows,String catagory) {
		SqlSession session = null;
		List<Map> list = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			INewsDao dao = session.getMapper(INewsDao.class);
			list = dao.appendChannelList(startIndex,rows,catagory);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

}
