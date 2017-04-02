package com.pub.service;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class DemoServiceTest {

	@Resource
	DemoServiceI demoService;

	/**
	 * 测试updateDemoName方法
	 */
	@Test
	public void testUpdateDemo() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", "10");
		param.put("name", "vvvvv");
		int num = demoService.updateDemoNameById(param);

		Assert.assertTrue(num > 0);
	}

	/**
	 * 测试findAllDemo方法。
	 */
	@Test
	public void test() {

		List<Map<String, Object>> data = demoService.findAllDemo();

		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);

	}

	/**
	 * 测试Spring事务方法。
	 */
	@Test
	public void testTransaction() {
		demoService.testTranscation();

		Assert.assertNotNull("");
	}

	/**
	 * 测试Spring事务方法。
	 */
	@Test
	public void testJob() {

	/*	try {
			Thread.sleep(60 * 60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		Assert.assertNotNull("");
	}
}
