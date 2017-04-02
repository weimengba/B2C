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
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

/**
 * 平台管理员表DAO测试类
 * @author Administrator
 *
 */
public class PlatSysPermissionDAOTest {

	@Resource	
	PlatSysPermissionDAO platSysPermissionDAO;
	
	
	/**
	 * 查询所有权限
	 */
	@Test
	public void testSelectSysPermission(){
		
		List<Map<String, Object>> data = platSysPermissionDAO.selectSysPermission(MMUtil.getMM());
		
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		
		Assert.assertNotNull(data);
		
	}
	/**
	 * 修改权限
	 */
	@Test
	public void testUpdateSysPermission(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 1);
		param.put("name","增加用户");
		param.put("url", "123456//8081");
		int manger = platSysPermissionDAO.updateSysPermission(param);
		Assert.assertEquals(1, manger);
	}
	
	/**
	 * 添加权限
	 */
	@Test
	public void testInsertSysPermission(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name","删除用户");
		param.put("url", "123456//8080");
		int manger = platSysPermissionDAO.insertSysPermission(param);
		Assert.assertEquals(1, manger);
	}
	
	
}
