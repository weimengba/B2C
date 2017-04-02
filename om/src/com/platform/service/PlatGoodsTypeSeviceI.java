package com.platform.service;

import java.util.List;
import java.util.Map;


/**
 * 管理后台商品类别service类。
 * 
 * @author Administrator
 * 
 */
public interface PlatGoodsTypeSeviceI {
	
	/**
	 * 查询GoodsType。
	 * 
	 * @author Administrator
	 * 
	 */
	List<Map<String, Object>> selectGoodsType();
	
	/**
	 * 增加GoodsType。
	 * 
	 * @author Administrator
	 * 
	 */
	int insertGoodsType();
	
	/**
	 * 修改GoodsType。
	 * 
	 * @author Administrator
	 * 
	 */
	int updateGoodsTypeById();
	
	
	
}
