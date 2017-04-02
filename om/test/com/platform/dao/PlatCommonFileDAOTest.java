package com.platform.dao;

 
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 平台通用文件操作DAO测试
 *
 */


//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class PlatCommonFileDAOTest {

	@Resource
	PlatCommonFileDAO platCommonFileDAO;



	/**
	 * 测试insertAttr方法
	 */
	@Test
	public void testinsertAttr() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", "葡萄品种");
		param.put("objectId", 1);
		param.put("fileName", "abc.jpg");
		param.put("oldName", "sss.jpg");
		param.put("contentType", "image/jpeg");
		param.put("length", 19919);
		param.put("path", "test/test");
		param.put("ctime", new Date());
		int num = platCommonFileDAO.insertFile(param);
		Assert.assertEquals(1, num);
	}
	
	

}
