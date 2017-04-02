package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class WeiXinUtil {

	public static String appID = "wxc84573a485b7296d";
	public static String appsecret = "d4624c36b6795d1d99dcf0547af5443d";
	public static String token = "weixintoken123456";

	/**
	 * 获取微信的配置信息
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		if ("appID".equalsIgnoreCase(key)) {
			return appID;
		} else if ("appsecret".equalsIgnoreCase(key)) {
			return appsecret;
		} else if ("token".equalsIgnoreCase(key)) {
			return token;
		} else {
			return "";
		}
	}

	/**
	 * 生成微信Oauth2Code URL
	 * 
	 * @param returnUrl
	 *            原始URL
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getOauth2Code(String returnUrl)
			throws UnsupportedEncodingException {
		StringBuilder url = new StringBuilder(
				"https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		url.append(WeiXinUtil.get("appID"));
		url.append("&redirect_uri=");
		url.append(URLEncoder.encode(returnUrl, "UTF-8"));

		url.append("&response_type=code");
		url.append("&scope=snsapi_userinfo");
		url.append("&state=123");
		url.append("#wechat_redirect");
		return url.toString();
	}

	/**
	 * 根据code获取AccessToken
	 * 
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public static Map getAccessTokenByCode(String code) throws IOException {
		StringBuilder url = new StringBuilder(
				"https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		url.append(WeiXinUtil.get("appID"));
		url.append("&secret=");
		url.append(WeiXinUtil.get("appsecret"));

		url.append("&code=");
		url.append(code);
		url.append("&grant_type=authorization_code");
		String data = HttpUtil.get(url.toString());
		return JSON.parseObject(data);
	}

	/**
	 * 根据AccessToken获取OpenID,和用户信息。
	 * 
	 * @throws IOException
	 */
	public static Map getUserInfoByAccessToken(Map accessToken)
			throws IOException {
		StringBuilder url = new StringBuilder(
				"https://api.weixin.qq.com/sns/userinfo?access_token=");
		url.append(accessToken.get("access_token"));
		url.append("&openid=");
		url.append(accessToken.get("openid"));
		url.append("&lang=zh_CN");
		String data = HttpUtil.get(url.toString());
		return JSON.parseObject(data);
	}

	public static void main(String[] args) throws IOException {
		// System.out
		// .println(getAccessTokenByCode("041mqBRD0yukzg2lExQD0cxMRD0mqBRj"));

		// System.out.println(getUserInfoByAccessToken());
		
	}
}
