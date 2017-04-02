package com.platform.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.ueditor.define.State;
import com.github.pagehelper.PageHelper;
import com.mchange.v2.c3p0.stmt.GooGooStatementCache;
import com.util.GlobalDataUtil;
import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

/**
 * 管理后台订单管理DAO类测试
 * 
 * @author 苏鹏
 *
 */
public class TestPlatOrderDAO {

	@Resource
	PlatOrderDAO platOrderDao;

	/**
	 * 平台 订单查询测试成功 最终输出所有订单信息
	 * 
	 * @author 苏鹏
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSelectOrder() {
		PageHelper.startPage(1, 3);
		MMUtil.getMM().put("customerId", "2");
		List<Map<String, Object>> data = platOrderDao.selectOrder(MMUtil.getMM());

		System.out.println("Hello2");
		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 平台 订单插入测试成功 最终输出结果 result == 1
	 * @author 苏鹏
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testInsertOrder() {
		MM mm = MMUtil.getMM();
		mm.put("customerId", 1);
		mm.put("totalPrice", 100);
		mm.put("pay", 100);
		mm.put("state", 2);
		mm.put("customerAddressId", "100");
		mm.put("remark", "insert remark");
		mm.put("ctime", new Date());
		int result = platOrderDao.insertOrder(mm);
		System.out.println("最终输出的结果：***** = " + result);
	}

	/**
	 * 平台 订单更新测试通过，最终结果 == 1
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateOrderById() {
		MM mm = MMUtil.getMM();
		mm.put("id", 6);
		mm.put("customerId", 1);
		mm.put("totalPrice", 10000);
		mm.put("pay", 10);
		mm.put("state", 2);
		mm.put("customerAddressId", "100");
		mm.put("remark", "insert remark");
		mm.put("ctime", new Date());
		int result = platOrderDao.updateOrderById(mm);
		System.out.println("更新：最终输出结果 ******** == " + result);
	}

}
