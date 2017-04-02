package com.pub.service;

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

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class WeixinServiceTest {

	@Resource
	WeixinServiceI weixinService;

	/**
	 * 测试updateDemoName方法
	 */
	@Test
	public void testUpdateDemo() {

		Map userInfo = JSON
				.parseObject("{\"city\":\"\",\"country\":\"中国\",\"headimgurl\":\"http://wx.qlogo.cn/mmopen/J0Nt8iag9VCicC95X8JTFIcRSTgGeibbu4yCml1fELpONEzwhGKWkVjP33afQmuhnAUWbG2oiaCh6b0L1iaPUic8icOClnzoIMPJOCz/0\",\"language\":\"zh_CN\",\"nickname\":\"BaoLong\",\"openid\":\"oE9o1w0mC1PDS4xiY6PZc9ZzCuPI\",\"privilege\":[],\"province\":\"\",\"sex\":1}");
		Map user = weixinService.weixinLogin(userInfo);
		Assert.assertNotNull(user);
	}

}
