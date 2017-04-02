package com.pub.service;

import java.util.List;
import java.util.Map;




/**
 * 商品分类业务接口
 * 
 * @author Administrator
 * 
 */
public interface PubGoodsCategoryServiceI {
	
	/**
	 * 查询GoodsCategory所有数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectGoodsCategory();
	
}
