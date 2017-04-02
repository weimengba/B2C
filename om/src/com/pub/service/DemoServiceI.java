package com.pub.service;

import java.util.List;
import java.util.Map;

/**
 * 测试Demo业务接口
 * 
 * @author Administrator
 * 
 */
public interface DemoServiceI {
	List<Map<String, Object>> findAllDemo();

	void testTranscation();

	int insertDemo();

	int updateDemoNameById(Map<String, Object> param);
}
