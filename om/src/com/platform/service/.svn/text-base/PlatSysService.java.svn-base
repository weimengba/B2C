package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MMUtil;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class PlatSysService extends BasePlatService implements PlatSysServiceI{

	/**
	 * 登录检查
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectLoginCheck() {
		List<Map<String, Object>> data = platSysManagerDAO.selectSysManger(MMUtil.getMM());
		return data;
	}
	
	/**
	 * 查询平台用户
	 */
	@Override
	public List<Map<String, Object>> selectListPlaySysManger() {
		List<Map<String,Object>> manger = platSysManagerDAO.selectSysManger(MMUtil.getMM());
		return manger;
	}

	/**
	 * 添加平台用户
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertSysManger() {
		System.out.println(MMUtil.getMM());
		int manger = platSysManagerDAO.insertSysManger(MMUtil.getMM());
		return manger;
	}
	
	/**
	 * 修改平台用户
	 */
	@SuppressWarnings("unchecked")
	public int updateSysManger(){
		int manger = platSysManagerDAO.updateSysManger(MMUtil.getMM());
		return manger;
	}

	/**
	 * 用户权限列表
	 * (non-Javadoc)
	 */
	@Override
	public List<Map<String, Object>> selectSysPermission() {
		List<Map<String,Object>> manger = platSysPermissionDAO.selectSysPermission(MMUtil.getMM());
		return manger;
	}

	/**
	 * 修改用户权限
	 * (non-Javadoc)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateSysPermission() {
		int permission = platSysPermissionDAO.updateSysPermission(MMUtil.getMM());
		return permission;
	}

	/**
	 * 添加用户权限
	 * (non-Javadoc)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertSysPermission() {
		int permission = platSysPermissionDAO.insertSysPermission(MMUtil.getMM());
		return permission;
	}

	/**
	 * 管理员  角色中间表
	 * (non-Javadoc)
	 */
	@Override
	public List<Map<String, Object>> selectSysMangerRole() {
		List<Map<String,Object>> mangerRole = platSysManagerRoleDAO.SelectSysMangerRole();
		return mangerRole;
	}

//	/**
//	 * 修改 角色中间表
//	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public int updateManagerRole() {
//		int mangerRole = platSysManagerRoleDAO.updateSysMangerRole(MMUtil.getMM());
//		return mangerRole;
//	}

	/**
	 * 添加 角色中间表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertManagerRole() {
		int mangerRole = platSysManagerRoleDAO.insertSysMangerRole(MMUtil.getMM());
		return mangerRole;
	}
/**
 * 角色列表
 */
	@Override
	public List<Map<String, Object>> selectSysRoleList() {
		List<Map<String,Object>> sysRole = platSysRoleDAO.selectSysRole(MMUtil.getMM());
		return sysRole;
	}

	@Override
	public int updateSysRole() {
		int updateSysRole = platSysRoleDAO.updateSysRole(MMUtil.getMM());
		return updateSysRole;
	}

	@Override
	public int insertSysRole() {
		int insertSysRole = platSysRoleDAO.insertSysRole(MMUtil.getMM());
		return insertSysRole;
	}

	/**
	 * 查询角色权限
	 */
	@Override
	public List<Map<String, Object>> SelectPermissionRoleList() {
		List<Map<String,Object>> rolePermissionDAO = platSysRolePermissionDAO.SelectSysRolePermissionDAO();
		return rolePermissionDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int insertpermissionrole() {
		int permissionDAO = platSysRolePermissionDAO.insertSysRolePermissionDAO(MMUtil.getMM());
		return permissionDAO;
	}


	
}
