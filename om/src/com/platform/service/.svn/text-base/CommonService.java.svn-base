package com.platform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.util.MMUtil;

@Service
public class CommonService extends BasePlatService implements CommonServiceI {

	/**
	 * 通用的删除业务。
	 * 
	 * @return参数包表名，ID
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public int updateCommonDeleteById() {
		String table = (String) MMUtil.get("c_tb");
		String commonTable = globalDataUtil.getTableMapName(table);
		if (null == commonTable) {
			// 输入的表格参数错误，找不到要删除数据的表格，直接返回删除0条数据。
			return 0;
		}
		MMUtil.put("commonTable", commonTable);
		int delNumber = commonDAO.commonDeleteById(MMUtil.getMM());

		return delNumber;
	}

	/**
	 * 查询的通用业务。
	 * 
	 * @return 参数包表名，ID
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object commonGetDataById() {
		String table = (String) MMUtil.get("c_tb");
		String commonTable = globalDataUtil.getTableMapName(table);
		MMUtil.put("commonTable", commonTable);
		Object ob = commonDAO.commonGetDataById(MMUtil.getMM());
		return ob;
	}

	/**
	 * 通用的查询所有数据的业务。
	 * 
	 * @return 参数包表名，ID
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List commonFindAll(String tableName) {
		Map param = new HashMap();
		param.put("commonTable", globalDataUtil.getTableMapName(tableName));
		List data = commonDAO.commonFindAll(param);
		return data;
	}

	/**
	 * 公共文件添加
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int insertFile(Map<String, Object> param) {
		return platCommonFileDAO.insertFile(param);
	}

	/**
	 * 根据ID更新file文件数据
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int updateFileById() {
		int result = platCommonFileDAO.updateFileById(MMUtil.getMM());
		return result;
	}

	/**
	 * 按条件查询file文件
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFile() {
		List<Map<String, Object>> data = platCommonFileDAO.selectFile(MMUtil
				.getMM());
		return data;
	}

	/**
	 * 添加log业务
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int insertLog() {
		return platCommonLogDAO.insertLog(MMUtil.getMM());
	}

	/**
	 * 按条件查询Log
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectLog() {
		List<Map<String, Object>> data = platCommonLogDAO.selectLog(MMUtil
				.getMM());
		return data;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int updateLogById() {
		int result = platCommonLogDAO.updateLogById(MMUtil.getMM());
		return result;
	}

}
