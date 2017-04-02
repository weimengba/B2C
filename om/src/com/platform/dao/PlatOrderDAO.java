package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 管理后台订单DAO类
 * @author 苏鹏
 *
 */

public interface PlatOrderDAO {

	/**
	 * 查询所有订单
	 * @return 所有订单,返回map类型,list接收
	 */
	List<Map<String,Object>> selectOrder(Map<String, Object> param);
	
	/**
	 * 管理员 添加一条订单信息
	 * @param param 需要添加的具体的信息
	 * @return 返回影响条数
	 */
	int insertOrder(Map<String, Object> param);
	
	/**
	 * 修改订单
	 * @param map 需要修改的信息
	 * @return 返回影响的条数
	 */
	int updateOrderById(Map<String, Object> param);
}
