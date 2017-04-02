package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 系统工具类。
 * 
 * @author Administrator
 * 
 */
public class SysUtil {

	static Logger logger = Logger.getLogger(SysUtil.class.getName());

	// 系统验证文件路径 
	public static String validatorFileName = "/validate.json";
	// 系统配置文件路径
	public static String sysConfigFileName = "/sysconfig.json";
	// 系统数据字典路径
	public static String sysDictFileName = "/sysdict.json";
	public static String charSet = "UTF-8";

	/**
	 * 获取验证框架配置文件的内容。
	 * 
	 * @return
	 */
	public static String getJsonStringFromFile(String filePath) {
		StringBuilder sb = new StringBuilder();
		InputStream is = SysUtil.class.getResourceAsStream(filePath);
		try {
			InputStreamReader isr = new InputStreamReader(is, charSet);
			char[] charBuffer = new char[100];
			while (true) {
				int num = isr.read(charBuffer);
				if (num <= 0) {
					break;
				}
				sb.append(charBuffer, 0, num);
			}
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 获取验证框架配置文件的内容。
	 * 
	 * @return
	 */
	public static void saveJsonToFile(String json, String filePath) {
		String saveFilePath = SysUtil.class.getResource(filePath).getFile();
		logger.error("配置文件的路径是:" + saveFilePath);
		try {
			PrintStream ps = new PrintStream(saveFilePath, charSet);
			ps.print(json);
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 调试模式下打印帮助信息。(根据ServletContex中设置的Debug判断是否是调试模式)
	 * 
	 * @param msg
	 */
	public static void debug(String msg) {
		ServletContext sc = (ServletContext) MMUtil.getMM().get("mm_context");
		Boolean debug = (Boolean) sc.getAttribute("sys_debug");
		if (debug) {
			System.out.println(msg);
		}
	}

	/**
	 * 调试模式下打印帮助信息。(根据ServletContex中设置的Debug判断是否是调试模式)
	 * 
	 * @param msg
	 */
	public static String encryptPassword(String pass) {
		ServletContext sc = (ServletContext) MMUtil.getMM().get("mm_context");
		Boolean debug = (Boolean) sc.getAttribute("sys_debug");
		if (debug) {
			return pass;
		} else {
			String salt = SysUtil.getSysConfig().get("SYS_SALT").toString();
			String encryptPassword = DigestUtils.md5Hex(pass + salt);
			return encryptPassword;
		}
	}

	/**
	 * 获取数据字段Map
	 * 
	 * @return
	 */
	public static Map getSysDict() {
		JSONObject json = JSON
				.parseObject(getJsonStringFromFile(SysUtil.sysDictFileName));
		return json.getJSONObject("dictionary");
	}

	/**
	 * 获取系统配置Map
	 * 
	 * @return
	 */
	public static Map getSysConfig() {
		JSONObject json = JSON
				.parseObject(getJsonStringFromFile(SysUtil.sysConfigFileName));
		return json.getJSONObject("systemConfig");
	}

	public static void main(String[] args) {
		Map config = getSysConfig();
		System.out.println(config.get("SYS_PAGE_SIZE"));

	}
}
