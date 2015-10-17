package com.ncshop.controlls;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TUser;
import com.ncshop.service.UserService;
import com.ncshop.util.LogBuilder;

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
	@Autowired
	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		WxMpUser wxMpUser = null;
		String state = null;
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
			wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken,
					null);
			boolean valid = wxMpService
					.oauth2validateAccessToken(wxMpOAuth2AccessToken);
			// 根据不同的状态值跳转不同页面
			state = req.getParameter("state");
			TUser user = new TUser();
			TUser findUser = userService.findUser(wxMpUser.getOpenId());

			if (state.equals("1")) {
				// 跳转到首页

				// TUserDAO dao=new TUserDAO();
				// //List list = dao.findByProperty("oppenId",
				// wxMpUser.getOpenId());
				// if(list.size()>1){
				// user=(TUser) list.get(0);
				// }else{
				// user=new TUser();
				// user.setOpenId(wxMpUser.getOpenId());
				// dao.save(user);
				// //user=(TUser) dao.findByProperty("openId",
				// wxMpUser.getOpenId()).get(0);
				// }
				if (findUser == null) {
					req.getSession().setAttribute("user", user);
				} else {
					req.getSession().setAttribute("user", findUser);
				}
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
			if (state.equals("2")) {
				if (findUser == null) {
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				} else {
					// 跳转到订单页
					req.getRequestDispatcher(
							"/user/findOrdersByUser?userId" + user.getUserId()).forward(
							req, resp);
				}
				return;
			}

			resp.getWriter().write(wxMpUser.getOpenId());
		} catch (Exception e) {
			LogBuilder.writeToLog(e.getMessage());
			resp.getWriter().write(
					e.getMessage() + "cause: " + e.getCause() + " "
							+ e.getLocalizedMessage() + wxMpUser.getNickname()
							+ state);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
