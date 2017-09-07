package com.coderli.service;

import java.util.List;
import com.coderli.entity.Comment;

public interface CommentService {
	List<Comment> selectTopComments(String newsId,Integer st,Integer r);
	List<Comment> selectNewComments(String newsId,Integer st,Integer r);
	List<Comment> selectLastComments(String newsId,Integer st,Integer r);
}
