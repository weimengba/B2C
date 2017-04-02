package com.pub.dao;

import java.util.List;
import java.util.Map;

/**
 * 后台管理员-角色中间表DAO类。
 * @author Administrator
 *
 */
public interface PubSysManagerRoleDAO {

	List<Map<String, Object>> selectSysMangerRole();

	int insertSysMangerRole(Map<String, Object> param);


}
