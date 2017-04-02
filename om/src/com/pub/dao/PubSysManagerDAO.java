package com.pub.dao;

import java.util.List;
import java.util.Map;

/**
 * 后台平台管理员表DAO类。
 * @author Administrator
 *
 */
public interface PubSysManagerDAO {


	List<Map<String, Object>> selectSysManger();

	int insertSysManger(Map<String, Object> param);

	int updateSysManger(Map<String, Object> param);

}
