package com.pub.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;


/**
 * 平台 订单实现类
 * 
 * @author 郭兰鑫
 * 
 */

@Service
public interface PubOrderServiceI {
	
    /**
     * 
     * 添加订单
     */
	int insertOrder();
   /**
     * 
     * 修改订单
     */
	int updateOrderByid();
   /**
     * 
     * 查询订单
     */
	List<Map<String, Object>> selectOrder();
	/**
	 * 通过客户ID查询
	 */
	List<Map<String,Object>>selectOrderBycustomerId();
	/**
	 * 条件查询购物车
	 * @return
	 */
	 List<Map<String, Object>> selectCustomerCart();
	 /**
	  * 支付流程
	  * @return
	  */
	 boolean placeOrder() throws ServletException, IOException;
	 
		/**
		 * 查询库存
		 */
		Map<String, Object>findGoodsDynamic();
	/**
	 * 添加购物车	
	 * @param param
	 * @return
	 * 
	 */	
	int insertCustomerCart();
		
}
