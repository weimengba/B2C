package com.pub.dao;

import java.util.List;
import java.util.Map;

/**
 * 前端订单DAO类
 * @author 苏鹏
 *
 */

public interface PubOrderDAO {
	/**
	 * 添加订单
	 * @param param
	 * @return
	 */
	int insertOrder(Map<String, Object> param);
	/**
	 * 根据ID修改订单
	 * @param param
	 * @return
	 */
	int updateOrderByid(Map<String, Object> param);
	/**
	 * 订单查询
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectOrder(Map<String, Object> param);
	/**
	 * 根据客户ID查询
	 * @param param
	 * @return
	 */
	List<Map<String,Object>>selectOrderBycustomerId(Map<String, Object> param);
	/**
	 * 查询库存
	 */
	Map<String, Object>findGoodsDynamic(Map<String, Object> param);
}
