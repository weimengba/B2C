package com.pub.dao;

import java.util.List;
import java.util.Map;

/**
 * 公众前台客户地址表DAO类。
 * @author Administrator
 *
 */
public interface PubCustomerAddressDAO {

	/**
	 * 根据条件查询收货地址（未删除）
	 * @return
	 */
	List<Map<String,Object>> selectCustomerAddress(Map<String, Object> param);
	
	/**
	 * 添加当前客户收货地址
	 * @return
	 */
	int insertCustomerAddress(Map<String, Object> param);
	
	/**
	 * 根据ID修改客户收货地址
	 * @return
	 */
	int updateCustomerAddressById(Map<String, Object> param);
	
	/**
	 * 根据客户ID查询收货地址
	 * @param param
	 * @return
	 */
	List<Map<String,Object>> selectCustomerAddressByCustomerId(Map<String, Object> param);
	
	
}
