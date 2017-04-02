package com.platform.dao;

import java.util.List;
import java.util.Map;

import com.util.MM;



/**
 * 管理后台商品属性DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PlatGoodsAttrDAO{
	/**
	 * 查询GoodsAttr所有数据
	 * @param mm 
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectGoodsAttr(MM mm);
	
	/**
	 * 添加GoodsAttr数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int insertAttr(Map<String, Object> param);
	
	/**
	 * 修改GoodsAttr数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int updateAttrById(Map<String, Object> param);

	List<Map<String, Object>> selectGoodsAttrByTypeId(MM mm);
	
}
