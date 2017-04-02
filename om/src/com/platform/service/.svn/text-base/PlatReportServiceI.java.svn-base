/**
 * 
 */
package com.platform.service;

import java.util.List;
import java.util.Map;

/**
 * 管理后台 报表管理Service接口
 * @author 苏鹏
 */
public interface PlatReportServiceI {
	
	/**
	 * 订单概况统计 业务接口
	 * @return 返回本次查询的在一定时间段内的订单信息,返回类型map,list接收
	 */
	List<Map<String, Object>> selectOrderStatistics();
	
	/**
	 * 销售明细 业务接口
	 * @return 返回本次查询的在一定时间段内销售的详细信息,返回类型map,list接收
	 */
	List<Map<String, Object>> selectSaleDetails();
	
	/**
	 * 销售排行 业务接口
	 * @return 返回本次查询的在一定时间段内销售的排行信息,返回类型map,list接收
	 */
	List<Map<String, Object>> selectSalesRank();
}
