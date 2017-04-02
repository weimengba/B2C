package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Administrator
 * 
 */
@Service
public interface XXPlatSysManagerServiceI {

	int updateSysManager();

	List<Map<String, Object>> selectSysManager();

	int insertSysManager();

}
