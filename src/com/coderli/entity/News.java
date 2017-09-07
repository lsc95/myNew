package com.coderli.entity;

import java.util.Date;

public class News {
	private Integer newsId;
	private String channel;
	private String code;
	private String title;
	private Date time;
	private String src;
	private String category;
	private String pic;
	private String content;
	private String url;
	private int count;

	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(Integer newsId, String channel, String code, String title,
			Date time, String src, String category, String pic, String content,
			String url, int count) {
		super();
		this.newsId = newsId;
		this.channel = channel;
		this.code = code;
		this.title = title;
		this.time = time;
		this.src = src;
		this.category = category;
		this.pic = pic;
		this.content = content;
		this.url = url;
		this.count = count;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", channel=" + channel + ", code="
				+ code + ", title=" + title + ", time=" + time + ", src=" + src
				+ ", category=" + category + ", pic=" + pic + ", content="
				+ content + ", url=" + url + ", count=" + count + "]";
	}

}
