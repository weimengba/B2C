package com.pub.dao;

import java.util.List;
import java.util.Map;

import com.pojo.Demo;

/**
 * 测试类。
 * 
 * @author Administrator
 * 
 */

public interface DemoDAO {

	int updateDemoName(Map<String, Object> param);

	/**
	 * 测试方法。
	 * 
	 * @return
	 */
	List<Map<String, Object>> findAll();

	/**
	 * 测试方法。
	 * 
	 * @return
	 */
	List<Map<String, Object>> findDemoDynamic(Map<String, Object> param);

	/**
	 * 测试方法。
	 * 
	 * @return
	 */
	List<Demo> findDemoDynamicOfDemo(Map<String, Object> param);

	/**
	 * 添加Demo数据
	 * 
	 * @param param
	 *            : String name,int age
	 * @return
	 */
	int addDemo(Map<String, Object> param);

	/**
	 * 添加Demo1数据(根据参数做选择)
	 * 
	 * @param param
	 *            : String name,int age
	 * @return
	 */
	int addDemo1(Map<String, Object> param);

	/**
	 * 添加Demo数据(使用Pojo参数)
	 * 
	 * @param param
	 *            : String name,int age
	 * @return
	 */
	int addDemoByPojo(Demo demo);

	/**
	 * 修改Demo数据
	 * 
	 * @param param
	 *            : String name,int age
	 * @return
	 */
	int updateDemo(Map<String, Object> param);
	
	int addMultDemo(Map<String, Object> param);
	
	List<Map<String, Object>> testSelect(Map<String, Object> param);
}
