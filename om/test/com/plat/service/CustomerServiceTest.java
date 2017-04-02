package com.plat.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.service.PlatCustomerServiceI;
import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class CustomerServiceTest {

	@Resource
	PlatCustomerServiceI customerService;
	
	/**
	 * 测试查询全部收货地址
	 */
	@Test
	public void testSelectListCustomerAddress() {

		MM mm = MMUtil.getMM();

		mm.put("customer_id", 2);

		List<Map<String, Object>> data = customerService.selectListCustomerAddress();
		for (Map<String, Object> map : data) {
			System.out.println(map.get("consignee"));
		}
	}
	
	/**
	 * 测试修改收货地址
	 */
	@Test
	public void testUpdateCustomerAddress() {

		MM mm = MMUtil.getMM();

		mm.put("id", 2);
		mm.put("address", "aaa");

		int num = customerService.updateCustomerAddress();
		Assert.assertTrue(num == 1);
	}
}
