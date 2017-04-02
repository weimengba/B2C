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

import com.github.pagehelper.PageHelper;
import com.platform.dao.XXPlatSysManagerDAO;

//Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class XXPubSysManagerDAOTest {
	@Resource
	XXPlatSysManagerDAO dao;

	@Test
	public void testSelectSysManager() {
		PageHelper.startPage(1, 3);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "a");
		List<Map<String, Object>> data = dao.findSysManager(param);
		Assert.assertNotNull(data);
	}

	@Test
	public void testInsertSysManager() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "马云");
		param.put("account", "Jay"+System.currentTimeMillis());
		param.put("password", "123456");
		param.put("mobile", "13112341234");
		param.put("email", "test@test.com");		
		
		int num = dao.insertSysManager(param);
		Assert.assertEquals(1, num);
	}

	@Test
	public void testUpdateSysManager() {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("id", "7");
		
		param.put("name", "刘备");
		param.put("account", "aaa"+System.currentTimeMillis());
		param.put("password", "ccc");
		param.put("mobile", "sss");
		param.put("email", "vvv@test.com");		
		
		int num = dao.updateSysManager(param);
		Assert.assertEquals(1, num);
	}
}
