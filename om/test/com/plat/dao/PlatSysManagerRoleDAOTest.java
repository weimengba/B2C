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

import com.platform.dao.PlatSysManagerDAO;
import com.platform.dao.PlatSysManagerRoleDAO;
import com.platform.dao.PlatSysPermissionDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

/**
 * 平台管理员表DAO测试类
 * @author Administrator
 *
 */
public class PlatSysManagerRoleDAOTest {

	@Resource	
	PlatSysManagerRoleDAO platSysManagerRoleDAO;
	
	
	/**
	 * 查询管理员-角色中间表
	 */
	@Test
	public void testSelectSysMangerRole(){
		
		List<Map<String, Object>> data = platSysManagerRoleDAO.SelectSysMangerRole();
		
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		
		Assert.assertNotNull(data);
	}
	/**
	 * 增加管理员-角色中间表
	 */
	@Test
	public void testInsertSysMangerRole(){
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("managerId", 3);
		param.put("roleId", 1);
		int date = platSysManagerRoleDAO.insertSysMangerRole(param);
		Assert.assertEquals(1,date);
	}

}
