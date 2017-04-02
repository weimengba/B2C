package com.platform.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
/**
 * 管理后台订单管理DAO类测试
 * @author 苏鹏
 *
 */
public class CommonDAOTest {

	@Resource
	CommonDAO commonDao;

	@Test
	public void updateCommonDeleteById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("commonTable", "demo");
		param.put("id", "4");
		int delNum = commonDao.commonDeleteById(param);
		Assert.assertTrue(delNum == 1);
	}
	
	

	@Test
	public void commonGetDataById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("commonTable", "demo");
		param.put("id", "4");
		Object ob = commonDao.commonGetDataById(param);
		System.out.println(ob);
		Assert.assertNotNull(ob);
	}
}
