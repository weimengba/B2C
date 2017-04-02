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
public class PubOrderViewService extends BasePubService implements PubOrderViewServiceI {

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> OrderView() {
		
		System.out.println(MMUtil.getMM().get("customer_id")); 
		List<Map<String, Object>> data=PubOrderViewDAO.OrderView(MMUtil.getMM());
		return data;
	}



}
