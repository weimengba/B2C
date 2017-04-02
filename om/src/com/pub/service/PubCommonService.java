package com.pub.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.util.MM;
import com.util.MMUtil;

/**
 * 通用文件   日志实现类
 * @author Administrator
 *
 */
@Service
public class PubCommonService extends BasePubService implements PubCommonServiceI {

	@Override
	public int insertCommonFile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFile() {
		MM mm = MMUtil.getMM();
		System.out.println("mm_app_pagesize：" + mm.get("mm_app_pagesize"));

		Integer pagesize = (Integer) mm.get("mm_app_pagesize");
		PageHelper.startPage(1, pagesize);
		List<Map<String, Object>> data = pubCommonFileDAO.selectFile(mm);
		return data;
	}

	@Override
	public int updateFileById() {
		// TODO Auto-generated method stub
		return 0;
	}

}
