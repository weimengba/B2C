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
public class PubGoodsTypeDAOTest {

	@Resource
	PubGoodsTypeDAO pubGoodsTypeDAO;



	/**
	 * 测试insertGoodsType方法
	 */
	@Test
	public void testinsertGoodsType() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", "桃红葡萄酒");
		param.put("description", "产自意大利");
		int num = pubGoodsTypeDAO.insertGoodsType(param);
		Assert.assertEquals(1, num);
	}
	
	/**
	 * 测试selectGoodsType方法
	 */
	@Test
	public void testselectGoodsType() {
		List<Map<String, Object>> list=pubGoodsTypeDAO.selectGoodsType();
		for(Map<String, Object> data : list){
			System.out.println(data);
		}
		Assert.assertNotNull(list);
	}
	
	
	/**
	 * 测试updateGoodsTypeById方法
	 */
	@Test
	public void testupdateGoodsTypeById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", "白酒");
		param.put("description", "浓香型");
		param.put("id", 3);
		int num = pubGoodsTypeDAO.updateGoodsTypeById(param);
		Assert.assertEquals(1, num);
	}


}

