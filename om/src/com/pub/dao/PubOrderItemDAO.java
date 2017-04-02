package com.pub.dao;

import java.util.List;
import java.util.Map;

/**
 * 前端订单详情DAO类
 * @author 苏鹏
 *
 */

public interface PubOrderItemDAO {
	/**
	 * 根据订单ID查询
	 * @param param
	 * @return
	 */
	List<Map<String,Object>>selectOrderByorderId(Map<String, Object> param);
	int insertOrderItem(Map<String, Object> param); 
}
