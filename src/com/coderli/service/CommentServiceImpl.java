package com.coderli.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coderli.dao.CommentDao;
import com.coderli.entity.Comment;
@Service("commentService")
@Transactional(rollbackFor=Exception.class)
public class CommentServiceImpl implements CommentService{
	@Resource(name="CommentDao")
	private CommentDao dao =null;
	public List<Comment> baseSelect(String newsId,Integer order, Integer st, Integer r) {
		return dao.selectComment(newsId, order, st, r);
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
