package com.pub.dao;

import java.util.List;
import java.util.Map;


/**
 * 公众前台商品类别属性值DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PubGoodsTypeAttrValueDAO {
	
	/**
	 * 查询GoodsAttrValue所有数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectGoodsAttrValue();
	
	/**
	 * 添加GoodsAttrValue数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int insertAttrValue(Map<String, Object> param);
	
	/**
	 * 修改GoodsAttrValue数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int updateAttrValueById(Map<String, Object> param);
	
}
