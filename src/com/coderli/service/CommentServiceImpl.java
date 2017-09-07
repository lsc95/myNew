package com.coderli.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.coderli.dao.ICommentDao;
import com.coderli.entity.Comment;
import com.coderli.utils.MyBatisUtil;

public class CommentServiceImpl implements CommentService{

	public List<Comment> baseSelect(String newsId,Integer order, Integer st, Integer r) {
		SqlSession session=null;
		List<Comment> list=null;
		try {
			session=MyBatisUtil.getSqlSessionFactory().openSession();
			ICommentDao dao = session.getMapper(ICommentDao.class);
			list=dao.selectComment(newsId, order, st, r);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Comment> selectNewComments(String newsId, Integer st, Integer r) {
		return baseSelect(newsId, 2, st, r);
	}

	@Override
	public List<Comment> selectLastComments(String newsId, Integer st, Integer r) {
		return baseSelect(newsId, 3, st, r);
	}

	@Override
	public List<Comment> selectTopComments(String newsId, Integer st, Integer r) {
		return baseSelect(newsId, 1, st, r);
	}

}
