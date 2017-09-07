package com.coderli.entity;

import java.util.Date;

public class Comment {
	private Integer commentId;
	private Date time;
	private String name;
	private int count;
	private String content;
	private int newsId;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer commentId, Date time, String name, int count,
			String content, int newsId) {
		super();
		this.commentId = commentId;
		this.time = time;
		this.name = name;
		this.count = count;
		this.content = content;
		this.newsId = newsId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", time=" + time + ", name="
				+ name + ", count=" + count + ", content=" + content
				+ ", newsId=" + newsId + "]";
	}

}
