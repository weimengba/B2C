package com.pub.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.dao.PlatCustomerAddressDAO;
import com.platform.dao.PlatCustomerCartDAO;
import com.platform.dao.PlatCustomerSnsDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

public class PubCustomerDAOTest {

	@Resource
	PubCustomerAddressDAO pubCustomerAddressDao;
	@Resource
	PubCustomerCartDAO pubCustomerCartDao;
	@Resource
	PubCustomerSnsDAO pubCustomerSnsDao;
	
	/*******************
	 * 测  试  客  户  收  货  地  址  *
	 *******************/	
	/**
	 * 测试根据客户ID查询收货地址
	 */
	@Test
	public void testSelectCustomerAddress(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customerId", 2);
		param.put("postcodes", "0");
		List<Map<String,Object>> data = pubCustomerAddressDao.selectCustomerAddress(param);		
		for (Map<String, Object> map : data) {
			System.out.println(map.get("consignee"));
		}
		Assert.assertNotNull(data);
	}
	
	/**
	 * 测试添加客户收货地址
	 */
	@Test
	public void testInsertCustomerAddress(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customerId", 4);
		param.put("consignee", "呵呵呵");
		param.put("mobile", "15988222667");
		param.put("address", "呵市呵街呵呵呵小区");
		param.put("postcodes", "100000");
		int result = pubCustomerAddressDao.insertCustomerAddress(param);
		Assert.assertEquals(1,result);
	}
	
	/**
	 * 测试修改客户收货地址
	 */
	@Test
	public void testUpdateCustomerAddressById(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", 6);
		param.put("consignee", "张小盒");
		param.put("mobile", "15846289577");
		param.put("address", "盒子公寓");
		param.put("postcodes", "166000");
		int result = pubCustomerAddressDao.updateCustomerAddressById(param);
		Assert.assertEquals(1,result);
	}
	
	/*************
	 * 测  试  购  物  车  *
	 *************/
	/**
	 * 测试查询全部购物车信息
	 */
	@Test
	public void testSelectCustomerCart(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customerId", 2);
		param.put("goodsId", 2);
		param.put("isOnsale", 1);
		List<Map<String,Object>> data = pubCustomerCartDao.selectCustomerCart(param);
		for (Map<String, Object> map : data) {
			System.out.println(map.get("id"));
		}
		Assert.assertNotNull(data);
	}
	
	/**
	 * 测试添加购物车
	 */
	@Test
	public void testInsertCustomerCart(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customerId", 3);
		param.put("goodsId", 20);
		param.put("num", 10);
		int num = pubCustomerCartDao.insertCustomerCart(param);
		Assert.assertEquals(1, num);
	}
	/**
	 * 测试根据ID修改购物车信息
	 */
	@Test
	public void testUpdateCustomerCartById(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", 1);
		param.put("num", 222);
		int num = pubCustomerCartDao.updateCustomerCartById(param);
		Assert.assertEquals(1, num);
	}
	
	/***************
	 * 测  试  登  录  方  式  *
	 ***************/
	/**
	 * 测试查询全部登录方式（未删除）
	 */
	@Test
	public void testSelectCustomerSns(){
		List<Map<String,Object>> data = pubCustomerSnsDao.selectCustomerSns();
		for (Map<String, Object> map : data) {
			System.out.println(map.get("id"));
		}
		Assert.assertNotNull(data);
	}
	/**
	 * 测试根据客户ID查询登录方式（未删除）
	 */
	@Test
	public void testSelectCustomerSnsByCustomerId(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customer_id", 1);
		List<Map<String,Object>> data = pubCustomerSnsDao.selectCustomerSnsByCustomerId(param);
		for (Map<String, Object> map : data) {
			System.out.println(map.get("id"));
		}
		Assert.assertNotNull(data);
	}
	/**
	 * 测试根据根据第三方接口ID查询登录方式（未删除）
	 */
	@Test
	public void testSelectCustomerSnsBySnsId(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sns_id", 222);
		List<Map<String,Object>> data = pubCustomerSnsDao.selectCustomerSnsBySnsId(param);
		for (Map<String, Object> map : data) {
			System.out.println(map.get("id"));
		}
		Assert.assertNotNull(data);
	}
	/**
	 * 测试添加登录方式
	 */
	@Test
	public void testInsertCustomerSns(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customer_id", 4);
		param.put("sns_id", 67438);
		param.put("sns_info", "{name:'***'}");
		int num = pubCustomerSnsDao.insertCustomerSns(param);
		Assert.assertEquals(1, num);
	}
}
