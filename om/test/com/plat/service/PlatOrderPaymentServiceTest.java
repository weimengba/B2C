package com.plat.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.platform.service.CommonServiceI;
import com.platform.service.PlatOrderServiceI;
import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

public class PlatOrderPaymentServiceTest {
	@Resource
	PlatOrderServiceI platOrderServiceI;
	@Resource
	CommonServiceI commonService;
	/**
	 * 测试查询平台所有订单的方法
	 */
	@Test
	public void testSelectPlatOrderPayment(){
		List<Map<String,Object>> data=platOrderServiceI.selectPlatOrderPayment();
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		Assert.assertNotNull(data);		
	}
	/**
	 * 平台订单通用查询测试方法
	 * 通过ID查询一条记录
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCommonGetDataById(){
		MM mm = MMUtil.getMM();
		mm.put("c_tb", "orderPayment");
		mm.put("id",1);	
		Map<String, String> strMap=(Map<String, String>) commonService.commonGetDataById();	
		System.out.println(strMap);
	}
	
	/**
	 * 平台订单通用删除方法测试
	 */
	@Test
	public void testUpdateCommonDeleteById(){
		MM mm = MMUtil.getMM();
		mm.put("c_tb", "orderPayment");
		mm.put("id",3);	
		int delNum=commonService.updateCommonDeleteById();
		Assert.assertTrue(delNum == 1);		
	}
	
	/**
	 * 平台订单修改测试方法
	 */
	@Test
	public void testUpdatePlatOrderPayment(){
		MM mm = MMUtil.getMM();
		mm.put("c_tb", "orderPayment");
		mm.put("id",6);	
		MMUtil.put("payStatus", 25);
		MMUtil.put("payer", "2w改");
		MMUtil.put("paySum", 35);
		MMUtil.put("payAmount", 45);
		MMUtil.put("payActual", 3);
		MMUtil.put("payRefund", 2);		
		int updateNum =platOrderServiceI.updatePlatOrderPayment();	 
		Assert.assertTrue(updateNum == 1);
	}
	
	/**
	 * 平台订单添加测试方法
	 */
	@Test
	public void testInsertPlatOrderPayment() {
		MM mm = MMUtil.getMM();
		mm.put("c_tb", "orderPayment");	
		mm.put("id", 1);
		MMUtil.put("orderId", 24);
		MMUtil.put("payWay", 2);
		MMUtil.put("payer", "测s试");
		MMUtil.put("payStatus", 245);
		MMUtil.put("paySum", 35);
		MMUtil.put("payAmount", 45);
		MMUtil.put("payActual", 3);
		MMUtil.put("payRefund", 2);
		MMUtil.put("isDel", 0);
		int addNum =platOrderServiceI.insertPubOrderPayment();	 
		Assert.assertTrue(addNum == 1);
	}

}
