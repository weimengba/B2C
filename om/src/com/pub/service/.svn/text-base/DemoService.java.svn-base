package com.pub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.util.MM;
import com.util.MMUtil;

/**
 * Demo业务实现类
 * 
 * @author Administrator
 * 
 */

@Service
public class DemoService extends BasePubService implements DemoServiceI {

	@SuppressWarnings("unchecked")
	public int insertDemo() {
		MM mm = MMUtil.getMM();
		
		System.out.println(mm.get("name"));
		return demoDAO.addDemo(mm);
	}

	/**
	 * 查询所有Demo数据
	 */
	@Override
	public List<Map<String, Object>> findAllDemo() {
		
		
		
		List<Map<String, Object>> data = demoDAO
				.findDemoDynamic(MMUtil.getMM());
		return data;
	}

	/**
	 * 测试事务
	 */
	@Override
	@Transactional
	public void testTranscation() {
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("name", "事务成功");
		param1.put("age", 20);

		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("name", "成功2");
		param2.put("age", 20);

		demoDAO.addDemo(param1);
		demoDAO.addDemo(param2);
	}

	@Override
	@Transactional
	public int updateDemoNameById(Map<String, Object> param) {
		MM mm = MMUtil.getMM();
		return demoDAO.updateDemo(mm);
	}

}
