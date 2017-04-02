package com.platform.dao;

import java.util.List;
import java.util.Map;

import com.util.MM;


/**
 * 管理后台商品评论DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PlatGoodsCommentDAO {

	/**
	 * 查询所有的商品评论
	 * @param mm 
	 */
	List<Map<String, Object>> selectGoodsComment(MM mm);
	/**
	 * 添加一个商品评论
	 * @param param 
	 */
	
	int insertGoodsComment(Map<String, Object> param);
	
	
	
}
