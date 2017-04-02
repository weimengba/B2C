package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 平台通用文件处理DAO
 * @author Administrator
 *
 */
public interface PlatCommonFileDAO {
	/**
	 * 添加commonFile数据
	 * 
	 * @param param: String type,int object_id,String file_name
	 * 				 String old_name,String content_type,int length
	 *            	 String path,Date ctime
	 * @return
	 */
	int insertFile(Map<String, Object> param);
	
	/**
	 * 根据ID更新commonFile数据
	 */
	int updateFileById(Map<String, Object> param);
	
	/**
	 * 按条件查询commonFile 数据
	 * @param param 
	 * @return
	 */
	List<Map<String, Object>> selectFile(Map<String, Object> param);
}
