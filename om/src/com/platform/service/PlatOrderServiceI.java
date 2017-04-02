package com.platform.service;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Service;

/**
 * 平台订单增、改、查业务接口
 * 
 * @author sqy
 *
 */
@Service
public interface PlatOrderServiceI {
	/**
	 * 编辑历史订单的抽象方法
	 * @return 受影响行数
	 */
	int updatetPubOrderHistory();
	/**
	 * 添加历史订单的抽象方法
	 * @return 受影响行数
	 */
	int insertPubOrderHistory();
	/**
	 * 定义查询所有历史订单的抽象方法
	 * @return 返回一个Map类型的List集合
	 */
	List<Map<String, Object>> selectPlatOrderHistory();
	/**
	 * 查询订单
	 */ 
	List<Map<String, Object>> selectOrder();
	
	/**
	 * 更新订单
	 */
	int updateOrderById();
	
	/**
	 * 插入订单
	 */
	int insertOrder();
	
	/**
	 * 添加订单的抽象方法
	 * @return 受影响行数
	 */
	int insertPubOrderPayment();
	/**
	 * 定义查询所有订单的抽象方法
	 * @return 返回一个Map类型的List集合
	 */
	List<Map<String, Object>> selectPlatOrderPayment();
	/**
	 * 修改平台订单信息的抽象方法
	 * @return 受影响行数
	 */
	int updatePlatOrderPayment ();
	/**
	 * 查询订单详情
	 * @return 返回一个Map类型的List集合
	 */
	List<Map<String,Object>> selectOrderItem();
}
