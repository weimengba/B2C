package com.pub.dao;

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
public class TestPubOrderPaymentDAO {

	// cccccc

	@Resource
	PubOrderPaymentDAO pubOrderPaymentDAO;

	/**
	 * 测试updateDemoName方法
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSelectOrder() {
		System.out.println("111111111111");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customerId", "2");
		
		MMUtil.getMM().put("customerId", "2");
		
		//定义需要用到的list变量
		//根据订单号返回一组商品信息
		List<Map<String, Object>> goodsList = null;
		//
		Map<String,List<Map<String, Object>>> orderMap = new HashMap<>();
		
		
		//1、获取指定用户ID的订单ID,后期合成 按时间顺序取
		List<Integer> orderIdList=pubOrderPaymentDAO.selectOrderId(MMUtil
				.getMM());
		
		//2、循环遍历orderIdList，每取出一个orderId,则取出该id对应的商品list
		for (Iterator iterator = orderIdList.iterator(); iterator.hasNext();) {
			//Integer integer = (Integer) iterator.next();
			MMUtil.getMM().put("orderId", iterator.next());
			System.out.println(MMUtil.getMM().get("orderId"));
			goodsList = pubOrderPaymentDAO.selectOrderGoods(MMUtil.getMM());
			orderMap.put(MMUtil.getMM().get("orderId").toString(),goodsList);
		}

		Assert.assertNotNull(orderIdList);
	}
}
