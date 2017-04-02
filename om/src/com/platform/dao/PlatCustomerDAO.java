package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 管理后台客户DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PlatCustomerDAO {
	/**
	 * 添加customer数据
	 * 
	 * @param param: String account,String password,String mobile,
	 * 				 String email,String nickname,int sex,
	 *            	 Date ctime
	 * @return
	 */
	int insertCustomer(Map<String, Object> param);
	
	/**
	 * 根据ID更新customer数据
	 */
	int updateCustomerById(Map<String, Object> param);

	/**
	 * 按条件查询customer 数据
	 * @param param 
	 * @return
	 */
	List<Map<String, Object>> selectCustomer(Map<String, Object> param);
	
}
