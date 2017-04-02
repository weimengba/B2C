package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MM;
import com.util.MMUtil;

/**
 * 管理后台商品评论service类。
 * 
 * @author Administrator
 * 
 */

@Service
public class PlatGoodsCommentSevice extends BasePlatService implements PlatGoodsCommentSeviceI{

	@Override
	public List<Map<String, Object>> selectGoodsComment() {
		MM mm = MMUtil.getMM();
		List<Map<String, Object>> comment = platGoodsCommentDAO.selectGoodsComment(mm);
		return comment;
	}

	@Override
	public void insertGoodsComment() {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
