package com.ncshop.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

public class BuildTemplate {
	protected WxMpInMemoryConfigStorage wxMpConfigStorage;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;

	public BuildTemplate setConfig() {
		wxMpConfigStorage = new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId("wxd8276cabf8323d91"); // 设置微信公众号的appid
		wxMpConfigStorage.setSecret("64f28217f2ea488418026fac44506e4b"); // 设置微信公众号的app
																			// corpSecret
		wxMpConfigStorage.setToken("ncshops"); // 设置微信公众号的token
		wxMpConfigStorage.setAesKey("ncshops"); // 设置微信公众号的EncodingAESKey

		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
		return this;
	}

	public void setID() {
		try {
			String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token="
					+ wxMpService.getAccessToken();
			System.out.println();
			URL connUrl = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) connUrl
					.openConnection();
			// 连接超时

			conn.setConnectTimeout(25000);

			// 读取超时 --服务器响应比较慢,增大时间

			conn.setReadTimeout(25000);

			HttpURLConnection.setFollowRedirects(true);

			// 请求方式

			conn.setRequestMethod("GET");

			conn.setDoOutput(true);

			conn.setDoInput(true);

			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

			conn.setRequestProperty("Referer", "https://api.weixin.qq.com/");

			String json = "{\"industry_id1\":\"34\",\"industry_id2\":\"4\";}";

			System.out.println(json);

			conn.getOutputStream().write(json.getBytes());
			int responseCode = conn.getResponseCode();

			if (responseCode == 200) {

				InputStream is = conn.getInputStream();
				// 从流中获取类jason数据的字符串
				System.out.println(parserInputStream(is));
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void build(){
		try {
			String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token="
					+ wxMpService.getAccessToken();
			System.out.println();
			URL connUrl = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) connUrl
					.openConnection();
			// 连接超时

			conn.setConnectTimeout(25000);

			// 读取超时 --服务器响应比较慢,增大时间

			conn.setReadTimeout(25000);

			HttpURLConnection.setFollowRedirects(true);

			// 请求方式

			conn.setRequestMethod("GET");

			conn.setDoOutput(true);

			conn.setDoInput(true);

			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

			conn.setRequestProperty("Referer", "https://api.weixin.qq.com/");

			String json = "{\"template_id_short\":\"TM00015\"}";

			System.out.println(json);

			conn.getOutputStream().write(json.getBytes());
			int responseCode = conn.getResponseCode();

			if (responseCode == 200) {

				InputStream is = conn.getInputStream();
				// 从流中获取类jason数据的字符串
				System.out.println(parserInputStream(is));
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把字节流转换成字符串
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public String parserInputStream(InputStream is) throws IOException {
		// 把输入流转换成 字符串
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// 内存流 写入读取的数据
		StringWriter sw = new StringWriter();

		String str = null;
		while ((str = br.readLine()) != null) {
			sw.write(str);
		}

		br.close();
		sw.close();
		return sw.toString();
	}

	public static void main(String[] args) {
			
			new BuildTemplate().setConfig().setID();
			new BuildTemplate().setConfig().build();
	}
}
