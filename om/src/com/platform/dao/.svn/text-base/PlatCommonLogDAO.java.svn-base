package com.platform.dao;

import java.util.List;
import java.util.Map;


/**
 * 后台通用日志表DAO类。
 * @author Administrator
 *
 */
public interface PlatCommonLogDAO {
	/**
	 * 添加commonLog数据
	 * 
	 * @param param: String type,int operator_id,int operator_type
	 *            	 Date operator_time,Date ctime
	 * @return
	 */
	int insertLog(Map<String, Object> param);
	
	/**
	 * 根据ID更新commonLog数据
	 */
	int updateLogById(Map<String, Object> param);
	
	/**
	 * 按条件查询commonLog 数据
	 * @param param 
	 * @return
	 */
	List<Map<String, Object>> selectLog(Map<String, Object> param);
}
