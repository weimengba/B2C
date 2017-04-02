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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.Demo;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class PubGoodsCategoryDAOTest {

	@Resource
	PubGoodsCategoryDAO pubGoodsCategoryDAO;

	/**
	 * 测试selectGoodsCategory方法
	 */
	@Test
	public void testselectGoodsCategory() {
		List<Map<String, Object>> data = pubGoodsCategoryDAO
				.selectGoodsCategory();

		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 测试insertGoodsCategory方法
	 */
	@Test
	public void testinsertGoodsCategory() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "桃红葡萄酒");
		param.put("level", 2);
		param.put("parentId", 2);
		param.put("isShow", 0);
		int num = pubGoodsCategoryDAO.insertGoodsCategory(param);
		Assert.assertEquals(1, num);
	}

	/**
	 * 测试updateGoodsCategoryById方法
	 */
	@Test
	public void testupdateGoodsCategoryById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "白酒");
		param.put("level", 2);
		param.put("parentId", 1);
		param.put("isShow", 0);
		param.put("id", 6);
		int num = pubGoodsCategoryDAO.updateGoodsCategoryById(param);
		Assert.assertEquals(1, num);
	}

}
