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
public class PubGoodsCommentDAOTest {

	@Resource
	PubGoodsCommentDAO pubGoodsCommentDAO;



	/**
	 * 测试insertAttrValue方法
	 */
	@Test
	public void testinsertGoodsComment() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderItemId", 2);
		param.put("customerId", 3);
		param.put("goodsId", 2);
		param.put("star", 5);
		param.put("content", "口味不错");
		param.put("state", 1);
		int num = pubGoodsCommentDAO.insertGoodsComment(param);
		Assert.assertEquals(1, num);
	}
	
	/**
	 * 测试selectGoodsAttrValue方法
	 */
	@Test
	public void testselectGoodsComment() {
		List<Map<String, Object>> list=pubGoodsCommentDAO.selectGoodsComment();
		for(Map<String, Object> data : list){
			System.out.println(data);
		}
		Assert.assertNotNull(list);
	}
	
	/**
	 * 测试selectGoodsAttrValue方法
	 */
	@Test
	public void testselectGoodsComment1() {
		Map<String, Object> param = new HashMap<>();
		param.put("id", 53);
		List<Map<String, Object>> list=pubGoodsCommentDAO.selectGoodsCommentByGoodsId(param);
		for(Map<String, Object> data : list){
			System.out.println(data);
		}
		Assert.assertNotNull(list);
	}
	
	

}

