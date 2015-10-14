package com.ncshop.test;

import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class TestWXMessage {

	public static void main(String[] args) {
		WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT()
				.content("测试加密消息").fromUser("longge").toUser("luoge").build();
				System.out.println(m.toXml());
	}
}
