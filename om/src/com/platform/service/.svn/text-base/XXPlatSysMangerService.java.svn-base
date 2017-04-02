package com.platform.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.platform.dao.XXPlatSysManagerDAO;
import com.util.MMUtil;

/**
 * 
 * @author Administrator
 * 
 */
@Service
public class XXPlatSysMangerService extends BasePlatService implements
		XXPlatSysManagerServiceI {

	@Resource
	XXPlatSysManagerDAO dao;

	@Override
	public int updateSysManager() {
		return dao.updateSysManager(MMUtil.getMM());
	}

	@Override
	public List<Map<String, Object>> selectSysManager() {
		List<Map<String, Object>> data = dao.findSysManager(MMUtil.getMM());
		return data;
	}

	@Override
	public int insertSysManager() {
		return dao.insertSysManager(MMUtil.getMM());
	}

}
