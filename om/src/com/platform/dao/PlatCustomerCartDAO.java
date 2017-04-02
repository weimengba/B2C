package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 后台购物车表DAO类。
 * @author Administrator
 *
 */
public interface PlatCustomerCartDAO {
	
	/**
	 * 条件查询购物车
	 * @return
	 */
	List<Map<String, Object>> selectCustomerCart(Map<String, Object> param);
	
	/**
	 * 添加购物车
	 * @return
	 */
	int insertCustomerCart(Map<String, Object> param);
	
	/**
	 * 根据ID修改购物车信息
	 * @return
	 */
	int updateCustomerCartById(Map<String, Object> param);
}
