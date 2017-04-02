package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 公共客户接口
 * @author Administrator
 *
 */
@Service
public interface PlatCustomerServiceI {
	
	/**
	 * 所有客户列表
	 * @return
	 */
	List<Map<String, Object>> selectListCustomer();
	
	/**
	 * 修改客户信息
	 * @return
	 */
	int updateCustomer();

	/**
	 * 添加客户信息
	 * @return
	 */
	int insertCustomer();
	
	/**
	 * 当前客户收货地址列表
	 * @return
	 */
	public List<Map<String, Object>> selectListCustomerAddress();

	/**
	 * 修改收货地址
	 * @return
	 */
	int updateCustomerAddress();
	
	/**
	 * 添加收货地址
	 * @return
	 */
	int insertCustomerAddress();

	/**
	 * 当前客户购物车列表
	 * @return
	 */
	List<Map<String, Object>> selectListCustomerCart();

	/**
	 * 修改购物车商品数量
	 * @return
	 */
	int updateCustomerCartNum();

	/**
	 * 添加购物车
	 * @return
	 */
	int insertCustomerCart();

}
