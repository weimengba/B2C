package com.pub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.util.MMUtil;
import com.util.SysUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class TestPubOrderPaymentService {

	// cccccc

	@Resource
	PubOrderPaymentServiceI pubOrderPaymentService;

	/**
	 * 测试updateDemoName方法
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSelectOrderService() {
		
		//TODO 测试输入，注意删除
		MMUtil.getMM().put("customerId", "2");
		
		List<List<Map<String, Object>>> orderList = pubOrderPaymentService.selectPubOrderList();
		System.out.println(orderList);
		Assert.assertNotNull(orderList);
	}
}
