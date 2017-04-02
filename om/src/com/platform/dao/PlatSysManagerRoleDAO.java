package com.platform.dao;

import java.util.List;
import java.util.Map;

/**
 * 后台管理员-角色中间表DAO类。
 * @author Administrator
 *
 */
public interface PlatSysManagerRoleDAO {

	List<Map<String, Object>> SelectSysMangerRole();

	int insertSysMangerRole(Map<String, Object> param);

	int updateSysMangerRole(Map<String, Object> param);
}
