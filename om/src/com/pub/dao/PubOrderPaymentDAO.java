package com.pub.dao;

import java.util.List;
import java.util.Map;

/**
 * 前端订单支付信息DAO类
 * @author 苏鹏
 *
 */

public interface PubOrderPaymentDAO {
//	/**
//	 * 插入订单支付状态的抽象方法
//	 * @param param 传入Map类型的数据
//	 * @return 
//	 */
//	public int updateAddPubOrderPayment(Map<String, Object> param);
	/**
	 * 前台用户查询订单支付状的抽象方法
	 * 不需要传入参数
	 * @return 返回List集合
	 */ 
	public List<Map<String, Object>> selectPubOrderPayment();

	/**
	 * 查询指定用户的订单信息，最好能够按照时间的顺序查询并返回
	 * @param param 参数附带用户的ID
	 * @return 返回该用户的订单ID信息
	 */
	public List<Integer> selectOrderId(Map<String,Object> param);
	
	/**
	 * 根据订单id返回该订单中所有商品的订单信息
	 * @param param 商品id
	 * @return
	 */
	public List<Map<String, Object>> selectOrderGoods(Map<String, Object> param);

}
