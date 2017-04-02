package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 平台通用文件处理DAO
 * 
 * @author Administrator
 * 
 */
public interface XXPlatSysManagerDAO {
	int updateSysManager(Map<String, Object> param);	
	List<Map<String, Object>> findSysManager(Map<String, Object> param);
	int insertSysManager(Map<String, Object> param);
}
