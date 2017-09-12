package com.coderli.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class DataUtil {
	
	private DataUtil() { }

	/**
	 * 根据传入的参数，获取阿里云api数据
	 * 
	 * @param propertiesPath
	 *            配置文件名
	 * @param channel
	 *            频道名称
	 * @param num
	 *            获取多少条数据
	 * @param start
	 *            从第几条开始获取
	 * @return 返回数据
	 * @throws Exception
	 */
	public static String getData(String channel,String num, String start) throws Exception {
		Properties properties = new Properties();
		properties.load(DataUtil.class.getClassLoader().getResourceAsStream("api.properties"));
		String host = properties.getProperty("api.host");
		String path = properties.getProperty("api.path");
		String method = properties.getProperty("api.method");
		String appcode = properties.getProperty("api.appcode");
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("channel", channel);
		querys.put("num", num);
		querys.put("start", start);
		HttpResponse r = HttpUtils.doGet(host, path, method, headers, querys);
		String text = EntityUtils.toString(r.getEntity());
		return text;
	}

	/**
	 * 将String结构的数据存储到数据库中
	 * @param channelId 
	 * 
	 * @param data
	 * @throws SQLException 
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public static void saveData(Integer channelId, String data) {
		LinkedHashMap json = new Gson().fromJson(data, LinkedHashMap.class);
		String msg = (String) json.get("msg");
		if (msg == null || !"ok".equals(msg)) {
			System.out.println("api获取数据失败！");
			return;
		}
		List<Map> list = (List<Map>) (((LinkedTreeMap) json.get("result"))
				.get("list"));

		int[] results = null;
		Connection conn = null;
		String sql = "insert into t_news(channel_id,title,content,pic,src,time,url,weburl) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			pstm = conn.prepareStatement(sql);
			for (Map map : list) {
				String title = (String) map.get("title");
				long date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(
						(String) map.get("time")).getTime();
				Timestamp timestamp = new Timestamp(date);
				String src = (String) map.get("src");
				String pic = (String) map.get("pic");
				String content = (String) map.get("content");
				String url = (String) map.get("url");
				String weburl = (String) map.get("weburl");
				pstm.setObject(1, channelId);
				pstm.setObject(2, title);
				pstm.setObject(3, content);
				pstm.setObject(4, pic);
				pstm.setObject(5, src);
				pstm.setObject(6, timestamp);
				pstm.setObject(7, url);
				pstm.setObject(8, weburl);
				pstm.addBatch();
			}
			results = pstm.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBUtil.closeAll(conn, pstm, null);
		}
		for (int i = 0; i < results.length; i++) {
			System.out.println("第" + i + "条数据插入数据库成功");
		}
	}
}
