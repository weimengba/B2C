package com.pub.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class PubGoodsDAOTest {

	@Resource
	PubGoodsDAO pubGoodsDAO;

	/**
	 * 测试selectGoods方法
	 */
	@Test
	public void testselectGoods() {
		List<Map<String, Object>> data = pubGoodsDAO.selectGoods();

		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 测试findGoods方法
	 */
	@Test
	public void testfindGoods() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 3);
		MM mm = MMUtil.getMM();
		List<Map<String, Object>> data = pubGoodsDAO.findGoods(mm);

		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 测试findGoods方法
	 */
	@Test
	public void testfindGoodsDetail() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 58);
		List<Map<String, Object>> data = pubGoodsDAO.findGoodsDetail(param);

		for (Map<String, Object> row : data) {
			System.out.println(row);
		}

		Assert.assertNotNull(data);
	}

	/**
	 * 测试insertGoods方法
	 */
	@Test
	public void testinsertGoods() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("categoryId", 4);
		param.put("typeId", 3);
		param.put("title", "AAA");
		param.put("price", 1998.00);
		param.put("marketPrice", 1000.00);
		param.put("quantity", 10);
		param.put("num", 200);
		param.put("brief", "白葡萄酒，源自新西兰");
		param.put("detail", "白葡萄酒，金丘特惠");
		int num = pubGoodsDAO.insertGoods(param);
		Assert.assertEquals(1, num);
	}

	/**
	 * 测试updateGoodsById方法
	 */
	@Test
	public void testupdateGoodsById() {
		Map<String, Object> param = new HashMap<String, Object>();
		// param.put("categoryId", 2);
		// param.put("typeId", 2);
		param.put("title", "红酒");
		// param.put("price", 3998.00);
		// param.put("marketPrice", 500.00);
		// param.put("quantity", 10);
		// param.put("num", 200);
		// param.put("brief", "法国波尔多");
		// param.put("detail", "葡萄酒");
		param.put("id", 1);
		int num = pubGoodsDAO.updateGoodsById(param);
		Assert.assertEquals(1, num);
	}

	/**
	 * 测试findGoods方法
	 */
	@Test
	public void testGetGoodsDetailById() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 53);
		Map<String, Object> data = pubGoodsDAO.getGoodsDetailById(param);

		System.out.println(data);

		Assert.assertNotNull(data);
	}
}
