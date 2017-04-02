package com.platform.service;

import java.util.List;
import java.util.Map;

/**
 * 管理后台商品属性值service类。
 * 
 * @author Administrator
 * 
 */

public interface PlatGoodsAttrValueSeviceI{
	
	/**
	 * 查询GoodsAttrValue。
	 * 
	 * @author Administrator
	 * 
	 */
	List<Map<String, Object>> selectGoodsAttrValue();
	
	/**
	 * 增加GoodsAttrValue。
	 * 
	 * @author Administrator
	 * 
	 */
	int insertAttrValue();
	
	/**
	 * 修改GoodsAttrValue。
	 * 
	 * @author Administrator
	 * 
	 */
	int updateAttrValueById();
	
	
	
}
