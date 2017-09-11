package com.coderli.entity;

import java.sql.Timestamp;

public class News {
	private Integer newsId;
	private String channel;
	private String title;
	private Timestamp time;
	private String src;
	private String pic;
	private String content;
	private String url;
	private int count;
	private String weburl;
	private boolean isShowBanner;
	private int hotpoint;

	public News() {
		// TODO Auto-generated constructor stub
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
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

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public boolean isShowBanner() {
		return isShowBanner;
	}

	public void setShowBanner(boolean isShowBanner) {
		this.isShowBanner = isShowBanner;
	}

	public int getHotpoint() {
		return hotpoint;
	}

	public void setHotpoint(int hotpoint) {
		this.hotpoint = hotpoint;
	}

}
