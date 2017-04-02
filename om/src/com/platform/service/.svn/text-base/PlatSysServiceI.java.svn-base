package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Administrator
 *
 */
@Service
public interface PlatSysServiceI {

	/**
	 * 登录检查
	 * @return
	 */
	List<Map<String, Object>> selectLoginCheck();
	
	/**
	 * 查询平台用户
	 */
	List<Map<String, Object>> selectListPlaySysManger();

	/**
	 * 添加平台用户
	 */
	int insertSysManger();

	/**
	 * 修改平台用户
	 */
	int updateSysManger();

	/**
	 * 用户权限列表
	 * (non-Javadoc)
	 */
	List<Map<String, Object>> selectSysPermission();
	
	/**
	 * 修改用户权限
	 * (non-Javadoc)
	 */
	int updateSysPermission();

	/**
	 * 添加用户权限
	 * (non-Javadoc)
	 */
	int insertSysPermission();

	/**
	 * 管理员  角色中间表
	 * (non-Javadoc)
	 */
	List<Map<String, Object>> selectSysMangerRole();
//
//	/**
//	 * 修改 角色中间表
//	 */
//	int updateManagerRole();

	/**
	 * 添加 角色中间表
	 */
	int insertManagerRole();

	List<Map<String, Object>> selectSysRoleList();

	int updateSysRole();

	int insertSysRole();

	/**
	 * 查询角色权限
	 * @return
	 */
	List<Map<String, Object>> SelectPermissionRoleList();

	int insertpermissionrole();

}
