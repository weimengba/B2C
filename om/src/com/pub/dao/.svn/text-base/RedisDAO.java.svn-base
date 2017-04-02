package com.pub.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDAO {
	@Resource
	StringRedisTemplate redisTemplate;

	/**
	 * 获取登录用户。
	 * 
	 * @return
	 */
	public List getLoginUser() {
		BoundListOperations<String, String> list = redisTemplate
				.boundListOps("loginuser");
		List<String> data = list.range(0, 100);
		return data;
	}

	/**
	 * 存储当前登录用户信息
	 * @param userKey
	 * @param param
	 */
	public void setLoginUser(String userKey, Map<String, Object> param) {
		BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate
				.boundHashOps("loginuser:"+userKey);
		boundHashOps.put("id", param.get("id").toString().trim());
		boundHashOps.put("name", param.get("name").toString().trim());
	}

	/**
	 * 获取当前登录用户信息
	 * @param userKey
	 * @return
	 */
	public Map getLoginUser(String userKey) {
		BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate
				.boundHashOps("loginuser:"+userKey);
		String name = (String) boundHashOps.get("name");
		String id = (String) boundHashOps.get("id");
		Map user = new HashMap();
		user.put("id", id);
		user.put("name", name);
		return user;
	}
	
	/**
	 * 删除指定用户信息（注销）
	 * @param userKey
	 */
	public void delLoginUser(String userKey){
		redisTemplate.delete("loginuser:"+userKey);
	}

}
