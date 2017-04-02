package com.platform.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class TestPlatReport {

	@Resource
	PlatReportDAO platReportDAO;

	/**
	 * 平台 订单查询测试成功 最终输出所有订单信息
	 * 
	 * @author 苏鹏
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSelectReportDAO() {
		//PageHelper.startPage(1, 3);
		//MMUtil.getMM().put("customerId", "2");
		MMUtil.getMM().put("startTime", "2017-03-10 15:04:03");
		System.out.println(MMUtil.getMM().get("startTime"));
		List<Map<String, Object>> data = platReportDAO.selectSalesRank(MMUtil.getMM());

		System.out.println("Hello2");
		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}
}
