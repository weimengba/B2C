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

import com.platform.dao.PlatCustomerAddressDAO;
import com.platform.dao.PlatCustomerCartDAO;
import com.platform.dao.PlatCustomerDAO;
import com.platform.dao.PlatCustomerSnsDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

public class PlatCustomerDAOTest {

	@Resource
	PlatCustomerDAO platCustomer;
	@Resource
	PlatCustomerAddressDAO platCustomerAddressDao;
	@Resource
	PlatCustomerCartDAO platCustomerCartDao;
	@Resource 
	PlatCustomerSnsDAO platCustomerSnsDao;
	
	/*******************
	 * 测         试         客         户     *
	 *******************/
	/**
	 * 测试根据条件查询客户
	 */
	@Test
	public void testSelectCustomer(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("mobile", "2");
		List<Map<String,Object>> data = platCustomer.selectCustomer(param);		
		for (Map<String, Object> map : data) {
			System.out.println(map.get("account"));
		}
		Assert.assertNotNull(data);
	}
	
	/**
	 * 测试修改客户信息
	 */
	@Test
	public void testUpdateCustomer(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", 2);
		param.put("mobile", "17319028856");
		int data = platCustomer.updateCustomerById(param);		
		Assert.assertEquals(1, data);
	}
	
	/**
	 * 测试增加客户信息
	 */
	@Test
	public void testInsertCustomer(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("email", "yuyang@sina.com");
		param.put("mobile", "15819028856");
		param.put("account", "yuyang");
		param.put("password", "yuyang");
		param.put("sex", "2");
		int data = platCustomer.insertCustomer(param);	
		Assert.assertEquals(1, data);
	}
	
	
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
		List<Map<String,Object>> data = platCustomerAddressDao.selectCustomerAddress(param);		
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
		int result = platCustomerAddressDao.insertCustomerAddress(param);
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
		int result = platCustomerAddressDao.updateCustomerAddressById(param);
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
		List<Map<String,Object>> data = platCustomerCartDao.selectCustomerCart(param);
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
		int num = platCustomerCartDao.insertCustomerCart(param);
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
		int num = platCustomerCartDao.updateCustomerCartById(param);
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
		List<Map<String,Object>> data = platCustomerSnsDao.selectCustomerSns();
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
		param.put("customerId", 1);
		List<Map<String,Object>> data = platCustomerSnsDao.selectCustomerSnsByCustomerId(param);
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
		param.put("snsId", 222);
		List<Map<String,Object>> data = platCustomerSnsDao.selectCustomerSnsBySnsId(param);
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
		param.put("customerId", 4);
		param.put("snsId", 67438);
		param.put("snsInfo", "{name:'***'}");
		int num = platCustomerSnsDao.insertCustomerSns(param);
		Assert.assertEquals(1, num);
	}
}
