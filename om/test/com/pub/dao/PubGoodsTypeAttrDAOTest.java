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

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class PubGoodsTypeAttrDAOTest {

	@Resource
	PubGoodsTypeAttrDAO pubGoodsTypeAttrDAO;

	/**
	 * 测试insertAttr方法
	 */
	@Test
	public void testinsertAttr() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", "葡萄品种");
		param.put("typeId", 1);
		param.put("dataType", 1);
		param.put("chooseValue", "紫葡萄，白葡萄");
		param.put("isCondition", 0);
		param.put("showOrder", 0);
		int num = pubGoodsTypeAttrDAO.insertAttr(param);
		Assert.assertEquals(1, num);
	}

	/**
	 * 测试selectGoodsTypeAttr方法
	 */
	@Test
	public void testselectGoodsTypeAttr() {
		List<Map<String, Object>> list = pubGoodsTypeAttrDAO.selectGoodsAttr();
		for (Map<String, Object> data : list) {
			System.out.println(data);
		}
		Assert.assertNotNull(list);
	}

	/**
	 * 测试updateAttrById方法
	 */
	@Test
	public void testupdateAttrById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", "口味");
		param.put("typeId", 1);
		param.put("dataType", 1);
		param.put("chooseValue", "甜，涩");
		param.put("isCondition", 0);
		param.put("showOrder", 0);
		param.put("id", 2);
		int num = pubGoodsTypeAttrDAO.updateAttrById(param);
		Assert.assertEquals(1, num);
	}

}
