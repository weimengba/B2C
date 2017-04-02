package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MM;
import com.util.MMUtil;


/**
 * 管理后台商品属性值service类。
 * 
 * @author Administrator
 * 
 */
@Service
public class PlatGoodsAttrValueSevice extends BasePlatService implements PlatGoodsAttrValueSeviceI{

	@Override
	public List<Map<String, Object>> selectGoodsAttrValue() {
		List<Map<String, Object>> data = platGoodsAttrValueDAO.selectGoodsAttrValue(MMUtil.getMM());
		return data;
	}

	@Override
	public int insertAttrValue() {
		return platGoodsAttrValueDAO.insertAttrValue(MMUtil.getMM());
	}

	@Override
	public int updateAttrValueById() {
		return platGoodsAttrValueDAO.updateAttrValueById(MMUtil.getMM());
	}
	
	
	
}
