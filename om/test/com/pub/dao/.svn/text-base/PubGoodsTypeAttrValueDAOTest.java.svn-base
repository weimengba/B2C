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
public class PubGoodsTypeAttrValueDAOTest {

	@Resource
	PubGoodsTypeAttrValueDAO pubGoodsTypeAttrValueDAO;

	/**
	 * 测试insertAttrValue方法
	 */
	@Test
	public void testinsertAttrValue() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("goodsId", 2);
		param.put("attrId", 1);
		param.put("value", "法国");
		int num = pubGoodsTypeAttrValueDAO.insertAttrValue(param);
		Assert.assertEquals(1, num);
	}

	/**
	 * 测试selectGoodsAttrValue方法
	 */
	@Test
	public void testselectGoodsAttrValue() {
		List<Map<String, Object>> list = pubGoodsTypeAttrValueDAO
				.selectGoodsAttrValue();
		for (Map<String, Object> data : list) {
			System.out.println(data);
		}
		Assert.assertNotNull(list);
	}

	/**
	 * 测试updateAttrValueById方法
	 */
	@Test
	public void testupdateAttrValueById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("goodsId", 2);
		param.put("attrId", 1);
		param.put("value", "白酒");
		param.put("id", 1);
		int num = pubGoodsTypeAttrValueDAO.updateAttrValueById(param);
		Assert.assertEquals(1, num);
	}

}
