package com.pub.controller;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml",
		"classpath*:/conf/spring-mvc.xml" })
public class TestDemoController {

	@Resource
	DemoController demoController;

	@Test
	public void test() {

		MockHttpServletRequest request;
		MockServletContext context;
		MockHttpSession session;
		MockHttpServletResponse response;

		ModelAndView mav = demoController.t1();

		Assert.assertEquals("t1", mav.getViewName());
		Assert.assertNotNull(mav.getModel().get("data"));
	}
	
	@Test
	public void testT2() {

		// MockHttpServletRequest request;
		// MockServletContext context;
		// MockHttpSession session;
		// MockHttpServletResponse response;

		ModelAndView mav = demoController.t2(10,"阿里巴巴");

		Assert.assertEquals("/t1", mav.getViewName());
		Assert.assertNotNull(mav.getModel().get("data"));
	}

}
