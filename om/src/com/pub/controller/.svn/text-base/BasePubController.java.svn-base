package com.pub.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.platform.service.CommonServiceI;
import com.pub.dao.RedisDAO;
import com.pub.service.DemoServiceI;
import com.pub.service.PubCommonServiceI;
import com.pub.service.PubCustomerServiceI;
import com.pub.service.PubGoodsCategoryServiceI;
import com.pub.service.PubGoodsServiceI;
import com.pub.service.PubGoodsTypeAttrServiceI;
import com.pub.service.PubOrderItemServiceI;
import com.pub.service.PubOrderPaymentServiceI;
import com.pub.service.PubOrderServiceI;
import com.pub.service.PubOrderViewServiceI;
import com.util.MMUtil;

public class BasePubController {

	@Resource
	DemoServiceI demoService;

	@Resource
	CommonServiceI commonService;
	
	@Resource
	PubCommonServiceI pubCommonService;
	
	@Resource
	PubCustomerServiceI	pubCustomerService;
	
	@Resource
	PubGoodsCategoryServiceI pubGoodsCategoryService;
	
	@Resource
	PubGoodsServiceI pubGoodsService;
	
	@Resource
	PubGoodsTypeAttrServiceI pubGoodsTypeAttrService;
	
	@Resource
	PubOrderServiceI pubOrderService;
	
	@Resource
	PubOrderPaymentServiceI pubOrderPaymentServiceI;
	
	@Resource
	PubOrderViewServiceI pubOrderViewService;
	
	@Resource
	PubOrderItemServiceI pubOrderItemService;
	@Resource
	RedisDAO redisDAO;
	
	/**
	 * 根据key取cookie的值，若key不存在返回空字符串
	 * @param key
	 * @return
	 */
	public static String getCookie(String key) {
		Cookie[] cookies = MMUtil.getHttpServletRequest().getCookies();
		String value = "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cook = cookies[i];
			if (cook.getName().equalsIgnoreCase(key)) { // 获取键
				value = cook.getValue().toString();// 获取值
			}
		}
		return value;
	}
	/**
	 * 根据key删除cookie
	 * @param key
	 * @return
	 */
	public static void delCookie(String key, HttpServletResponse response) {
		if(null!=key){
			Cookie cookie = new Cookie(key,null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}	
	}
	/**
	 * 
	 * @param files
	 *            文件数组
	 * @param basePath
	 *            文件存放基地址
	 * @param objId
	 *            文件所属对象的ID
	 * @param type
	 *            文件的类型，如：goodPhoto商品主图片，goodImg商品相册图片。
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public void commonSaveFile(MultipartFile[] files, String basePath,
			Object objId, String type) throws IOException {
		for (int i = 0; i < files.length; i++) {
			Map<String, Object> param = new HashMap<String, Object>();
			MultipartFile file = files[i];
			String oldFileName = file.getOriginalFilename();

			String newFileName = System.currentTimeMillis()
					+ oldFileName.substring(oldFileName.lastIndexOf("."));

			String genDir = getFilePath();
			File dir = new File(basePath + genDir);
			if (!dir.exists())
				dir.mkdirs();

			param.put("type", type);
			param.put("objectId", objId);
			param.put("fileName", newFileName);
			param.put("oldName", file.getOriginalFilename());
			param.put("contentType", file.getContentType());
			param.put("length", file.getSize());
			param.put("path", genDir + newFileName);

			commonService.insertFile(param);

			file.transferTo(new File(basePath + genDir + newFileName));
		}
	}

	/**
	 * 根据基路径，生成文件上传路径。形如：d:/upload/20170304/
	 * 
	 * @param basePath
	 * @return
	 */
	public static String getFilePath() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date()) + "/";
	}
	 /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
}
