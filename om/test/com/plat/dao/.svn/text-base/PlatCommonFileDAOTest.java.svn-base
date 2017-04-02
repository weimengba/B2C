package com.plat.dao;

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

import com.github.pagehelper.PageHelper;
import com.platform.dao.PlatCommonFileDAO;
import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
//配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
/**
 * 公共文件DAO测试类
 * @author lml
 * 
 */
public class PlatCommonFileDAOTest {
	@Resource
	PlatCommonFileDAO fileDao;
	
	/**
	 * 测试addFile方法
	 */
	@Test
	public void testInsertFile() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", "detail");
		param.put("objectId", 3);
		param.put("fileName", "fdhjjj4555.jsp");
		param.put("oldName", "goods.jsp");
		param.put("contentType", "image/jpeg");
		param.put("length", 222);
		param.put("path", "/map/123/");
		param.put("ctime", new Date());
		
		int num = fileDao.insertFile(param);

		Assert.assertEquals(1, num);
	}
	
	/**
	 * 根据条件查询file数据方法测试
	 */
	
	@Test
	@SuppressWarnings("unchecked")
	public  void testSelectFile() {
		PageHelper.startPage(0,5);
		MM mm = MMUtil.getMM();
		//mm.put("type", "goods");
		List<Map<String,Object>> data =fileDao.selectFile(mm);
		for (Map<String, Object> map : data) {
			System.out.println(map.get("id"));
		}
		Assert.assertNotNull(data);
	}
	
	
	/**
	 * 测试根据ID更新file数据方法
	 */
	@Test
	@SuppressWarnings("unchecked")
	public  void updateFileById() {
		MM mm = MMUtil.getMM();
		mm.put("id", "4");
		mm.put("objectId", "76241");
		mm.put("utime", new Date());
		int num = fileDao.updateFileById(mm);
		Assert.assertEquals(1, num);
	}
}
