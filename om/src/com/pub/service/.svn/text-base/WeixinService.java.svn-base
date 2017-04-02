package com.pub.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

/**
 * Demo业务实现类
 * 
 * @author Administrator
 * 
 */

@Service
public class WeixinService extends BasePubService implements WeixinServiceI {

	/**
	 * 微信自动登录业务方法。
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public Map weixinLogin(Map userInfo) {
		// 1检查openid是否存在。
		Map user = weixinDAO.selectUserByOpenid(userInfo);
		if (user != null) {
			// 2存在则返回用户信息
			return user;
		} else {
			// 不存在则新建用户
			// 先插入一条用户信息。
			Map userParam = new HashMap();
			userParam.put("headimg", userInfo.get("headimgurl"));	
			userParam.put("nickname", userInfo.get("nickname"));
			userParam.put("sex", userInfo.get("sex"));
			weixinDAO.addWeixinUser(userParam);

			// 再把微信信息存到om_customer_sns表中
			Map snsParam = new HashMap();
			snsParam.put("customerId", userParam.get("id"));

			snsParam.put("snsId", userInfo.get("openid"));
			snsParam.put("snsType", "weichat");
			snsParam.put("snsInfo", JSON.toJSONString(userInfo));
			weixinDAO.addWeixinUserSns(snsParam);
			
			//再查询用户信息
			user = weixinDAO.selectUserByOpenid(userInfo);
			return user;
		}
	}
}
