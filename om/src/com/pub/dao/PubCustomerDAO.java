package com.pub.dao;

import java.util.List;
import java.util.Map;


/**
 * 公众前台客户DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PubCustomerDAO {
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
