package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 后台客户社交账号表DAO类。
 * @author Administrator
 *
 */
public interface PlatCustomerSnsDAO {

	/**
	 * 查询全部登录方式（未删除）
	 * @return
	 */
	List<Map<String,Object>> selectCustomerSns();
	
	/**
	 * 根据客户ID查询登录方式（未删除）
	 * @return
	 */
	List<Map<String,Object>> selectCustomerSnsByCustomerId(Map<String,Object> param);
	
	/**
	 * 根据第三方接口ID查询登录方式（未删除）
	 * @return
	 */
	List<Map<String,Object>> selectCustomerSnsBySnsId(Map<String,Object> param);
	
	/**
	 * 添加登录方式
	 * @return
	 */
	int insertCustomerSns(Map<String,Object> param);
}
