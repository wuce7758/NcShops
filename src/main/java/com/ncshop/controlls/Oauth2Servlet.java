package com.ncshop.controlls;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class Oauth2Servlet extends HttpServlet {
	protected WxMpInMemoryConfigStorage wxMpConfigStorage;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			wxMpConfigStorage = new WxMpInMemoryConfigStorage();
			wxMpConfigStorage.setAppId("wxd8276cabf8323d91"); // 设置微信公众号的appid
			wxMpConfigStorage.setSecret("64f28217f2ea488418026fac44506e4b"); // 设置微信公众号的app
																				// corpSecret
			wxMpConfigStorage.setToken("ncshops"); // 设置微信公众号的token
			wxMpConfigStorage.setAesKey("ncshops"); // 设置微信公众号的EncodingAESKey

			wxMpService = new WxMpServiceImpl();
			wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

			wxMpService.oauth2buildAuthorizationUrl(
					WxConsts.OAUTH2_SCOPE_USER_INFO, null);
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService
					.oauth2getAccessToken(req.getParameter("code"));

			wxMpOAuth2AccessToken = wxMpService
					.oauth2refreshAccessToken(wxMpOAuth2AccessToken
							.getRefreshToken());
			WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(
					wxMpOAuth2AccessToken, null);
			boolean valid = wxMpService
					.oauth2validateAccessToken(wxMpOAuth2AccessToken);
			//根据不同的状态值跳转不同页面
			String state=req.getParameter("state");
			
			if(state.equals("1")){
				//跳转到首页
				req.getRequestDispatcher("").forward(req, resp);
				return;
			}
			if(state.equals("2")){
				//跳转到订单页
				req.getRequestDispatcher("").forward(req, resp);
				return;
			}
			
			resp.getWriter().write(wxMpUser.getOpenId());
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("cuowu");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
