package com.pub.dao;

import java.util.Date;
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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.Demo;
import com.util.MM;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class DemoDAOTest {

	// cccccc

	@Resource
	DemoDAO demoDAO;

	/**
	 * 测试updateDemoName方法
	 */
	@Test
	public void testUpdateDemo() {
		System.out.println("111111111111");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", "10");
		param.put("name", "nnnn");
		int num = demoDAO.updateDemo(param);
		System.out.println("123");

		Assert.assertTrue(num > 0);
	}

	/**
	 * 测试FindAll方法
	 */
	@Test
	public void testfindAll() {
		List<Map<String, Object>> data = demoDAO.findAll();

		for (Map<String, Object> row : data) {
			System.out.println(row);
			System.out.println(row.get("money").getClass());
			System.out.println(JSON.toJSONString(row, true));
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 测试findDemoDynamic方法
	 */
	@Test
	public void findDemoDynamic() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "红酒");
		param.put("age", 12);
		List<Map<String, Object>> data = demoDAO.findDemoDynamic(param);

		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 121211111111111111111111
	 */
	/**
	 * 测试findDemoDynamic方法
	 */
	@Test
	public void findDemoDynamicOfDemo() {

		PageHelper.startPage(-10, 5);
		PageHelper.orderBy("name desc");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "红酒");
		param.put("age", 12);
		// param.put("order", "id");
		// param.put("desc", "1");

		List<Demo> data = demoDAO.findDemoDynamicOfDemo(param);

		Page page = (Page) data;

		System.out.println(page);

		System.out.println(data.getClass().getName());

		System.out.println("***************size:" + data.size());

		for (Demo row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 测试addDemo方法
	 */
	@Test
	public void testaddDemo() {
		Map param = new MM();
		param.put("name", "哈哈红酒");
		param.put("age", 200);

		int num = demoDAO.addDemo(param);

		Assert.assertEquals(1, num);
	}

	/**
	 * 测试addDemo方法
	 */
	@Test
	public void testaddDemo1() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "红酒");
		param.put("age", 12);
		param.put("school", "中关村2小");
		param.put("address", "海淀区亿方大厦，11层111231221");

		int num = demoDAO.addDemo1(param);

		Assert.assertEquals(1, num);
	}

	/**
	 * 测试testaddDemoByPojo方法
	 */
	@Test
	public void testaddDemoByPojo() {
		Demo demo = new Demo();
		demo.setId(100);
		demo.setName("红酒");
		demo.setAge(20);
		demo.setCtime(new Date());
		demo.setIsDel(1);
		demo.setSchool("asdfasdf");
		demo.setAddress("123123123");
		demo.setUtime(new Date());

		int num = demoDAO.addDemoByPojo(demo);
		System.out.println("***********新的ID是：" + demo.getId());

		Assert.assertEquals(1, num);
	}

	/**
	 * 测试updateDemo方法
	 */
	@Test
	public void updateDemo() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "长城干红1");
		param.put("age", 12);
		param.put("id", 1);

		int num = demoDAO.updateDemo(param);

		Assert.assertEquals(1, num);
	}

	/**
	 * 测试addDemo方法
	 */
	@Test
	public void testaddMultDemo() {
		Map param = new MM();

		param.put("names", new String[] { "aaa", "bbb", "ccc" });
		param.put("ages", new Integer[] { 20, 21, 22 });

		int num = demoDAO.addMultDemo(param);

		Assert.assertEquals(1, 1);
	}
	
	/**
	 * 测试FindAll方法
	 */
	@Test
	public void testSelect() {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("name", "a");
		List<Map<String, Object>> data = demoDAO.testSelect(param);

		for (Map<String, Object> row : data) {
			System.out.println(row);
			System.out.println(row.get("money").getClass());
			System.out.println(JSON.toJSONString(row, true));
		}

		Assert.assertNotNull(data);
	}
}
