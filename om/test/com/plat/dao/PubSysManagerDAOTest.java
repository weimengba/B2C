package com.plat.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pub.dao.PubSysManagerDAO;
import com.pub.dao.PubSysManagerRoleDAO;
import com.pub.dao.PubSysPermissionDAO;
import com.pub.dao.PubSysRoleDAO;
import com.pub.dao.PubSysRolePermissionDAO;



//Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })

public class PubSysManagerDAOTest {
	@Resource
	PubSysManagerDAO psm;
	@Resource
	PubSysManagerRoleDAO psmr;
	@Resource
	PubSysPermissionDAO pubSysPermissionDAO;
	@Resource
	PubSysRoleDAO pubSysRoleDAO;
	@Resource
	PubSysRolePermissionDAO pubSysRolePermissionDAO;

	@Test
	public void testSelectPubSysManager() {
		List<Map<String,Object>> list=psm.selectSysManger();
		for (Map<String, Object> map : list) {
			System.out.println(map.get("id"));
		}
		Assert.assertNotNull(list);
	}
}
