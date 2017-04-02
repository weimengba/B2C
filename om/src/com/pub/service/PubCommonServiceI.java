package com.pub.service;

import java.util.List;
import java.util.Map;

/**
 * 通用文件   日志接口
 * @author Administrator
 *
 */
public interface PubCommonServiceI {
	/**
	 * 增加file数据方法
	 */
	int insertCommonFile();
	
	/**
	 * 按条件查询file数据方法
	 */
	List<Map<String, Object>> selectFile();
	
	/**
	 * 根据ID更新file数据方法
	 */
	int updateFileById();
}
