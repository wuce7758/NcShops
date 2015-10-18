package com.ncshop.controlls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncshop.domain.TUser;
import com.ncshop.service.Ouath2Service;
import com.ncshop.util.ConfigDao;
import com.ncshop.util.ConfigInfo;
import com.ncshop.util.LogBuilder;

@Controller
@RequestMapping("ouath")
public class Oauth2Controller {
	protected WxMpInMemoryConfigStorage wxMpConfigStorage;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;
	private ConfigDao configDao;
	private ConfigInfo configInfo;

	@Autowired
	private Ouath2Service service;

	@RequestMapping("/Oauth2Controller")
	public void Oauth2Servlet(HttpServletRequest req, HttpServletResponse resp) {
		WxMpUser wxMpUser = null;
		String state = null;
		try {
			initMessageContext();
			wxMpService = new WxMpServiceImpl();
			wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

			wxMpService.oauth2buildAuthorizationUrl(
					WxConsts.OAUTH2_SCOPE_USER_INFO, null);
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService
					.oauth2getAccessToken(req.getParameter("code"));

			wxMpOAuth2AccessToken = wxMpService
					.oauth2refreshAccessToken(wxMpOAuth2AccessToken
							.getRefreshToken());
			wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken,
					null);
			boolean valid = wxMpService
					.oauth2validateAccessToken(wxMpOAuth2AccessToken);
			// 根据不同的状态值跳转不同页面
			state = req.getParameter("state");
			TUser user = new TUser();
			user.setOpenId(wxMpUser.getOpenId());
			LogBuilder.writeToLog("kaoshi");
			TUser findUser = service.findUser(wxMpUser.getOpenId());
			LogBuilder.writeToLog("结束+00");
			if (state.equals("1")) {
				if (findUser == null) {
					req.getSession().setAttribute("user", user);
				} else {
					req.getSession().setAttribute("user", findUser);
				}
				resp.sendRedirect("/index.jsp");
				return;
			}
			if (state.equals("2")) {
				if (findUser == null) {
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				} else {
					// 跳转到订单页
					LogBuilder.writeToLog(findUser.getUserId()+"");
					resp.sendRedirect("/user/findOrdersByUser?userId=" + findUser.getUserId());
				}
				return;
			}
			return;
		} catch (Exception e) {
			LogBuilder.writeToLog(e.getMessage());
		}
	}
	private void initMessageContext() {
		configDao = new ConfigDao();
		configInfo = configDao.GetConfig();
		wxMpConfigStorage = new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId(configInfo.getWeChatAppID()); // 设置微信公众号的appid
		wxMpConfigStorage.setSecret(configInfo.getWeChatAppSecret()); // 设置微信公众号的app
		wxMpConfigStorage.setToken(configInfo.getWeChatToken()); // 设置微信公众号的token
		wxMpConfigStorage.setAesKey(configInfo.getWeChatAESKey()); // 设置微信公众号的EncodingAESKey
		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

	}

}
