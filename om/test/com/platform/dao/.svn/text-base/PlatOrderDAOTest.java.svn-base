package com.platform.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.fabric.xmlrpc.base.Data;
import com.platform.dao.PlatOrderDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

/**
 * 管理后台订单管理DAO类测试
 * @author 苏鹏
 *
 */
public class PlatOrderDAOTest {
	
	@Resource
	PlatOrderDAO platOrderDao;
	
	@Test
	public void testSelectOrder(){
		System.out.println("Hello1");
		List<Map<String, Object>> data = platOrderDao.selectOrder(null);
		
		System.out.println("Hello2");
		for(Map<String, Object> row : data){
			System.out.println(row);
		}
		
		Assert.assertNotNull(data);
	}

}
