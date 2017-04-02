package com.pub.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.platform.dao.PlatCommonFileDAO;
import com.platform.dao.PlatCommonLogDAO;
import com.platform.dao.PlatCustomerDAO;
import com.pub.service.PubCustomerServiceI;
import com.util.MM;
import com.util.MMUtil;



//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class AllDAOTest {

	@Resource
	PlatCommonFileDAO fileDao;
	@Resource
	PlatCommonLogDAO logDao;
	@Resource
	PlatCustomerDAO customerDao;
	@Resource
	PubCustomerServiceI pubCustomerService;
	/**
	 * 测试addFile方法
	 */
	@Test
	public void testInsertFile() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", "goods");
		param.put("object_id", 12233);
		param.put("file_name", "2222.jsp");
		param.put("old_name", "goods.jsp");
		param.put("content_type", "image/jpeg");
		param.put("length", 12233);
		param.put("path", "/map/123/");
		param.put("ctime", new Date());
		
		int num = fileDao.insertFile(param);

		Assert.assertEquals(1, num);
	}

	/**
	 * 测试addLog方法
	 */
	@Test
	public void testInsertLog() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", "addOrders");
		param.put("operator_id", 12233);
		param.put("operator_type", 1);
		param.put("operator_time", new Date());
		param.put("ctime", new Date());
		
		int num = logDao.insertLog(param);

		Assert.assertEquals(1, num);
	}
	
	
	/**
	 * 测试insertCustomer方法
	 */
	@Test
	public void testInsertCustomer() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("account", "admin");
		param.put("password", 12233);
		param.put("mobile", "12132112345");
		param.put("email", "123@sina.com");
		param.put("nickname", "小五");
		param.put("sex", "1");
		param.put("ctime", new Date());
		
		int num = customerDao.insertCustomer(param);
		Assert.assertEquals(1, num);
	}
	
	/**
	 * 测试service的updateAddCustomer方法
	 */
	@Test
	public void updateAddCustomer() {		
		MM mm =MMUtil.getMM();
		mm.put("account", "aqeqw");
		mm.put("password", 12233);
		mm.put("mobile", "121326578");
		mm.put("email", "253@sina.com");
		mm.put("nickname", "李六");
		mm.put("sex", "1");
		mm.put("ctime", new Date());
		
		int num = pubCustomerService.insertCustomer();

		Assert.assertEquals(1, num);
	}

}
