package com.platform.dao;

import java.util.List;
import java.util.Map;

import com.util.MM;

/**
 * 后台权限表DAO类。
 * @author Administrator
 *
 */
public interface PlatSysPermissionDAO {


	/**
	 * 查询SysPermission所有数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectSysPermission();
	/**
	 * 修改SysPermission所有数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */

	int updateSysPermission(Map<String, Object> param);
	/**
	 * 增加SysPermission所有数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int insertSysPermission(Map<String, Object> param);

	List<Map<String, Object>> selectSysPermission(MM mm);


}
