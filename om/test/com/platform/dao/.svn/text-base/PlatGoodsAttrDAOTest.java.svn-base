package com.platform.dao;

 
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
/**
 * 管理后台GoodsTypeDAO类测试

 *
 */
public class PlatGoodsAttrDAOTest {

	@Resource
	PlatGoodsAttrDAO platGoodsAttrDAO;



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
		int num = platGoodsAttrDAO.insertAttr(param);
		Assert.assertEquals(1, num);
	}
	
	/**
	 * 测试selectGoodsTypeAttr方法
	 */
	@Test
	public void testselectGoodsTypeAttr() {
		MM mm = MMUtil.getMM();
		mm.put("typeId", 17);
		List<Map<String, Object>> list=platGoodsAttrDAO.selectGoodsAttrByTypeId(mm);
		for(Map<String, Object> data : list){
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
		param.put("type_id", 1);
		param.put("data_type", 1);
		param.put("choose_value", "甜，涩");
		param.put("is_condition", 0);
		param.put("show_order", 0);
		param.put("id", 2);
		int num = platGoodsAttrDAO.updateAttrById(param);
		Assert.assertEquals(1, num);
	}


}
