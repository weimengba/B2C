package com.plat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.dao.PlatSysRolePermissionDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

/**
 * 角色权限表DAO测试类
 * @author Administrator
 *
 */
public class PlatSysRolePermissionDAOTest {

	@Resource	
	PlatSysRolePermissionDAO platSysRolePermissionDAO;
	
	
	/**
	 * 查询角色权限
	 */
	@Test
	public void testSelectSysMangerRole(){
		
		List<Map<String, Object>> data = platSysRolePermissionDAO.SelectSysRolePermissionDAO();
		
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		
		Assert.assertNotNull(data);
	}
	/**
	 * 增加角色权限
	 */
	@Test
	public void testInsertSysMangerRole(){
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("roleId", 2);
		param.put("permissionId", 2);
		int date = platSysRolePermissionDAO.insertSysRolePermissionDAO(param);
		Assert.assertEquals(1,date);
	}

}
