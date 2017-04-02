package com.platform.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.util.MMUtil;

/**
 * 管理平台订单业务实现类
 * 
 * @author sqy
 * 
 */
@Service
// 扫描Service组件
public class PlatOrderService extends BasePlatService implements
		PlatOrderServiceI {

	/**
	 * 管理平台添加订单方法
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertPubOrderPayment() {

		MMUtil.put("commonTable", "orderPayment");
		int addNumber = platOrderPaymentDAO.insertPlatOrderPayment(MMUtil
				.getMM());
		return addNumber;
	}

	/**
	 * 管理平台订单修改方法
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updatePlatOrderPayment() { 
		int updateNumber = platOrderPaymentDAO.updatePlatOrderPayment(MMUtil
				.getMM());
		return updateNumber;
	}

	/**
	 * 查询支付日志信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectPlatOrderPayment() {
		List<Map<String, Object>> date=platOrderPaymentDAO.selectPlatOrderPayment(MMUtil
				.getMM());
		return date;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectOrder() {
		List<Map<String, Object>> data = platOrderDAO.selectOrder(MMUtil.getMM());
		return data;
	}

	@Override
	public int updateOrderById() {
		int i = platOrderDAO.updateOrderById(MMUtil.getMM());
		return i;
	}

	@Override
	public int insertOrder() {
		int i = platOrderDAO.insertOrder(MMUtil.getMM());
		return i;
	}

	@Override
	public List<Map<String, Object>> selectOrderItem() {
		// TODO Auto-generated method stub
		return platOrderItemDAO.selectOrderItem(MMUtil.getMM());
	}
    
	/**
	 * 添加历史订单
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int insertPubOrderHistory() {

		MMUtil.put("commonTable", "orderPayment");
		int addNumber = platOrderHistoryDAO.insertPlatOrderHistory(MMUtil
				.getMM());
		return addNumber;
	}
   /**
    * 查询历史订单
    */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectPlatOrderHistory() {
		List<Map<String, Object>> date=platOrderHistoryDAO.selectPlatOrderHistory(MMUtil
				.getMM());
		return date;
	}
    
	/**
	 * 编辑历史订单
	 */
	@Override
	public int updatetPubOrderHistory() {
		int updateNumber = platOrderHistoryDAO.updatePlatOrderHistory(MMUtil
				.getMM());
		return updateNumber;
	}

}
