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
public class PlatSysManagerDAOTest {

	@Resource
	PlatSysManagerDAO platSysManagerDAO;
	
	/**
	 * 查询平台管理员
	 */
	@Test
	public void testSelectSysManger(){
		
		List<Map<String, Object>> data = platSysManagerDAO.selectSysManger(MMUtil.getMM());
		
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		
		Assert.assertNotNull(data);
	}
	
	/**
	 * 增加平台管理员
	 */
	@Test
	public void testInsertSysManger(){
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("name", "老大");
		param.put("account", "LD");
		param.put("password", "123456789");
		param.put("mobile", "12345679812");
		param.put("email", "123456@qq.com");
		int date = platSysManagerDAO.insertSysManger(param);
		Assert.assertEquals(1,date);
	}
	
	/**
	 * 修改平台管理员
	 */
	@Test
	public void testUpdateSysManger(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 4);
		param.put("name","赵武");
		param.put("password", "admin");
		param.put("mobile", "12365465489");
		param.put("email", "zw@qq.com");
		int manger = platSysManagerDAO.updateSysManger(param);
		Assert.assertEquals(1, manger);
	}
	
}
