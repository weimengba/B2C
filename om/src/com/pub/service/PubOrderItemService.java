package com.pub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MMUtil;

/**
 * 订单项业务。
 * @author Administrator
 *
 */


@Service
public class PubOrderItemService extends BasePubService implements PubOrderItemServiceI {

	/**
	 * 添加商品详细信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int insertOrderItem() {
	
		return pubOrderItemDAO.insertOrderItem(MMUtil.getMM());
	}
	/**
	 * 循环添加商品详细信息
	 * 
	 */
	@Override
	public int insertOrderItemAll(ArrayList<Map<String, Object>> data) {
		 MMUtil.get("item");
		    int i = 0;
			for ( i = 0; i < data.size(); i++) {
				pubOrderItemDAO.insertOrderItem(data.get(i));
			}
		return i;
	}
	
}
