package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MM;
import com.util.MMUtil;

/**
 * 平台公共客户service类
 * @author Administrator
 *
 */
@Service
public class PlatCustomerService extends BasePlatService implements PlatCustomerServiceI {
	
	/**
	 * 所有客户列表
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectListCustomer() {
		// TODO 此处设计不够完善，需要在考虑！
		List<Map<String, Object>> data = platCustomerDAO.selectCustomer(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 修改客户信息
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateCustomer() {
		int result = platCustomerDAO.updateCustomerById(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 添加客户信息
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertCustomer() {
		int result = platCustomerDAO.insertCustomer(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 当前客户收货地址列表
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectListCustomerAddress() {
		// TODO 此处设计不够完善，需要在考虑！
		List<Map<String, Object>> data = platCustomerAddressDAO.selectCustomerAddress(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 修改收货地址
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateCustomerAddress() {
		int result = platCustomerAddressDAO.updateCustomerAddressById(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 添加收货地址
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertCustomerAddress() {
		int result = platCustomerAddressDAO.insertCustomerAddress(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 当前客户购物车列表
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectListCustomerCart() {
		// TODO 此处设计不够完善，需要在考虑！
		List<Map<String, Object>> data = platCustomerCartDAO.selectCustomerCart(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 修改购物车商品数量
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateCustomerCartNum() {
		int result = platCustomerCartDAO.updateCustomerCartById(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 添加购物车
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertCustomerCart() {
		int result = platCustomerCartDAO.insertCustomerCart(MMUtil.getMM());
		return result;
	}
}
