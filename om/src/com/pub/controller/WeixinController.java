package com.pub.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/weixin")
public class WeixinController extends BasePubController {

	/**
	 * 微信消息处理接口
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/message")
	@ResponseBody
	public Object message(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		// 微信验证
		String isValidateWeixin = validateWeiXin(req);
		if (isValidateWeixin != null) {
			return isValidateWeixin;
		} else {
			// 微信消息接收并处理。

			int length = req.getContentLength();
			System.out.println(length);
			if (length <= 0) {
				return "success";
			}
			InputStream is = req.getInputStream();
			byte buf[] = new byte[length];
			is.read(buf);
			System.out.println(new String(buf));

			return "success";
		}
	}

	/**
	 * 验证微信方法。参考微信文档对微信介入进行验证。
	 * 
	 * @return
	 */
	public String validateWeiXin(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		if (signature != null) {
			// TODO 并未完成对微信介入的验证。请参考微信文档完成。
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");

			System.out.println("signature:" + signature);
			System.out.println("timestamp:" + timestamp);
			System.out.println("nonce:" + nonce);
			System.out.println("echostr:" + echostr);

			return echostr;
		} else {
			return null;
		}
	}
}
