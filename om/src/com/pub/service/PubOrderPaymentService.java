package com.pub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.platform.service.BasePlatService;
import com.util.MMUtil;
import com.util.SysUtil;

 /**
  * 客户端查询订单信息Service
  * @author sqy
  *
  */

@Service//扫描Service组件
@SuppressWarnings("unchecked")
public class PubOrderPaymentService extends BasePubService implements PubOrderPaymentServiceI{
     
	@Override
	public List<List<Map<String, Object>>> selectPubOrderList() {
		
		//定义需要用到的list变量
		//根据订单号返回一组商品信息
		List<Map<String, Object>> goodsList = null;
		//
		List<List<Map<String, Object>>> orderList = new ArrayList();
		
		
		//1、获取指定用户ID的订单ID,后期合成 按时间顺序取
		List<Integer> orderIdList=pubOrderPaymentDAO.selectOrderId(MMUtil
				.getMM());
		
		//2、循环遍历orderIdList，每取出一个orderId,则取出该id对应的商品list
		for (Iterator iterator = orderIdList.iterator(); iterator.hasNext();) {
			//Integer integer = (Integer) iterator.next();
			MMUtil.getMM().put("orderId", iterator.next());
			System.out.println(MMUtil.getMM().get("orderId"));
			goodsList = pubOrderPaymentDAO.selectOrderGoods(MMUtil.getMM());
			orderList.add(goodsList);
		}
		
		return orderList;
	}
}
