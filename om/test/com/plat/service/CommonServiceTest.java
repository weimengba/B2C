package com.plat.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.service.CommonServiceI;
import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class CommonServiceTest {

	@Resource
	CommonServiceI commonService;
	
	/**
	 * 测试updateDemoName方法
	 */
	@Test
	public void testUpdateCommonDeleteById() {

		MM mm = MMUtil.getMM();

		mm.put("id", 1);
		mm.put("c_tb", "demo");

		int delNum = commonService.updateCommonDeleteById();
		Assert.assertTrue(delNum == 1);
	}


	/**
	 * 测试updateFileByID方法
	 */
	@Test
	public void testUpdateFileById() {

		MM mm = MMUtil.getMM();
		mm.put("id", 1);
		mm.put("type", "abd");
		mm.put("utime", new Date());
		
		int num = commonService.updateFileById();
		Assert.assertTrue(num == 1);
	}
	/**
	 * 测试insertFile方法
	 */
	@Test
	public void testInsertFile() {

		MM mm = MMUtil.getMM();
		mm.put("type", "service测试");
		mm.put("objectId", 12233);
		mm.put("fileName", "2222.jsp");
		mm.put("oldName", "goods.jsp");
		mm.put("contentType", "image/jpeg");
		mm.put("length", 12233);
		mm.put("path", "/map/123/");
		mm.put("ctime", new Date());
		
		int num = commonService.insertFile(mm);
		Assert.assertTrue(num == 1);
	}
	/**
	 * 测试selectFile方法
	 */
	@Test
	public void testSelectLog() {
		MM mm = MMUtil.getMM();
		//mm.put("type","goods");
		List<Map<String,Object>> data=commonService.selectLog();
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
		Assert.assertNotNull(data);	
	}
}
