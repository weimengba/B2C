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

import com.platform.dao.PlatSysRoleDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

/**
 * 平台管理员表DAO测试类
 * @author Administrator
 *
 */
public class PlatSysRoleDAOTest {

	@Resource	
	PlatSysRoleDAO platSysRoleDAO;
	
	
	/**
	 * 查询所有权限
	 */
	@Test
	public void testSelectSysRole(){
		
		List<Map<String, Object>> data = platSysRoleDAO.selectSysRole(null);
		
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		
		Assert.assertNotNull(data);
		
	}
	/**
	 * 修改权限
	 */
	@Test
	public void testUpdateSysRole(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 3);
		param.put("name","赵六");
		param.put("remark", "无说明");
		int manger = platSysRoleDAO.updateSysRole(param);
		Assert.assertEquals(1, manger);
	}
	
	/**
	 * 添加权限
	 */
	@Test
	public void testInsertSysRole(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name","王五");
		param.put("remark", "无说明");
		int manger = platSysRoleDAO.insertSysRole(param);
		Assert.assertEquals(1, manger);
	}
	
	
}
