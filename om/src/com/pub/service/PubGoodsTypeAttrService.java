package com.pub.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MM;
import com.util.MMUtil;


/**
 * 商品类别属性业务实现类
 * 
 * @author Administrator
 * 
 */

@Service
public class PubGoodsTypeAttrService extends BasePubService implements PubGoodsTypeAttrServiceI{


	public List<Map<String, Object>> selectGoodsAttr() {
		MM mm = MMUtil.getMM();
		List<Map<String, Object>> attr = pubGoodsTypeAttrDAO.selectGoodsAttr();
		return attr;
	}
	
}
