package com.pub.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.util.MMUtil;

/**
 * 公共客户实现类
 * @author Administrator
 *
 */
@Service
public class PubCustomerService extends BasePubService implements PubCustomerServiceI {
	
	/**
	 * 所有客户列表
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectListCustomer() {
		// TODO 此处设计不够完善，需要在考虑！
		List<Map<String, Object>> data = pubCustomerDAO.selectCustomer(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 修改客户信息
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateCustomer() {
		int result = pubCustomerDAO.updateCustomerById(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 添加客户信息
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertCustomer() {
		int result = pubCustomerDAO.insertCustomer(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 当前客户收货地址列表
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectCustomerAddressByCustomerId() {
		List<Map<String, Object>> data = pubCustomerAddressDAO.selectCustomerAddressByCustomerId(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 修改收货地址
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateCustomerAddress() {
		int result = pubCustomerAddressDAO.updateCustomerAddressById(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 添加收货地址
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertCustomerAddress() {
		int result = pubCustomerAddressDAO.insertCustomerAddress(MMUtil.getMM());
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
		List<Map<String, Object>> data = pubCustomerCartDAO.selectCustomerCart(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 修改购物车商品数量
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateCustomerCartNum() {
		int result = pubCustomerCartDAO.updateCustomerCartById(MMUtil.getMM());
		return result;
	}
	
	/**
	 * 添加购物车
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertCustomerCart() {
		int result = pubCustomerCartDAO.insertCustomerCart(MMUtil.getMM());
		return result;
	}
}
