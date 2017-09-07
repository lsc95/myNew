package com.coderli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coderli.entity.Comment;

public interface ICommentDao {
	public List<Comment> selectComment(@Param("id")String newsId,@Param("order")Integer order,@Param("st")Integer st,@Param("r")Integer r);
}
