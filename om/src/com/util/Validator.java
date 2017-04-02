package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 系统通用验证器和类型转换器。使用单例实现。
 * 
 * @author Administrator
 * 
 */
public class Validator {
	// 单例的实例
	private static Validator validator;
	private Map<String, Object> config;
	static Logger logger = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	SimpleDateFormat dateTimeFormatT = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm");

	/**
	 * 单例的获取实例方法。
	 * 
	 * @return
	 */
	public static Validator getValidator() {
		if (validator == null) {
			synchronized (Validator.class) {
				if (validator == null) {
					validator = new Validator();
				}
			}
		}
		return validator;
	}

	// 单例的私有构造函数
	private Validator() {
		logger = Logger.getLogger(Validator.class.getName());
		initValidator();
	}

	// 初始化验证器方法。
	private void initValidator() {
		long startTime = System.currentTimeMillis();
		config = new HashMap<String, Object>();

		String validateString = SysUtil
				.getJsonStringFromFile(SysUtil.validatorFileName);

		JSONObject jsonObj = JSON.parseObject(validateString);
		JSONArray configList = jsonObj.getJSONArray("validators");
		Iterator<Object> it = configList.iterator();
		while (it.hasNext()) {
			JSONObject one = (JSONObject) it.next();
			JSONArray fieldArray = one.getJSONArray("fields");
			Iterator<Object> itFields = fieldArray.iterator();
			Map<String, Object> fields = new HashMap<String, Object>();
			while (itFields.hasNext()) {
				JSONObject field = (JSONObject) itFields.next();
				fields.put(field.getString("code"), field);
			}
			config.put(one.getString("uri"), fields);
		}
		long endTime = System.currentTimeMillis();
		long useTime = (endTime - startTime);
		logger.debug("\n************* Validator 初始化成功！用时：" + useTime
				+ "*************");

	}

	/**
	 * 验证并且转换数据。
	 * 
	 * @param uri
	 * @return
	 */
	public boolean validateAndConver(HttpServletRequest request,
			Map<String, Object> container) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		uri = uri.replace(contextPath, "");// 去掉上下文路径前缀。

		Map<String, Object> val = (Map<String, Object>) config.get(uri);
		if (val == null) {
			return true;
		}

		Set<String> keySet = val.keySet();
		Iterator<String> keyIt = keySet.iterator();
		while (keyIt.hasNext()) {
			String paramName = keyIt.next();
			JSONObject fieldVal = (JSONObject) val.get(paramName);
			// 验证数据，转换数据。
			if (!doValidateAndConver(paramName, fieldVal, request, container)) {
				SysUtil.debug("￥￥￥￥￥￥￥￥￥￥￥" + paramName + ":"
						+ request.getParameter(paramName) + "验证出错！￥￥￥￥￥￥￥￥￥￥￥");
				return false;
			}
		}

		return true;
	}

	/**
	 * 每一个字段的验证方法。
	 * 
	 * @param paramName
	 * @param fieldVal
	 * @param request
	 * @param container
	 * @return
	 */
	private boolean doValidateAndConver(String paramName, JSONObject fieldVal,
			HttpServletRequest request, Map<String, Object> container) {

		if (fieldVal.getBoolean("isArray") == null
				|| !fieldVal.getBoolean("isArray")) {
			// 非数组参数

			String paramValue = request.getParameter(paramName);
			// TODO 去掉空格，需要根据配置判断是否需要。
			if (paramValue != null) {
				paramValue = paramValue.trim();
			}

			Boolean mustFill = fieldVal.getBoolean("mustFill");
			// 必填检查
			if (!mustFill) {
				// 不是必填项，如果为空则直接返回true。验证通过。
				if (null == paramValue || "".equals(paramValue)) {
					return true;
				}
			} else {
				// 是必填项，如果为空则返回false。验证不通过
				if (null == paramValue || "".equals(paramValue)) {
					return false;
				}
			}

			// 类型转换和验证。
			String type = fieldVal.getString("type");
			try {
				if ("int".equalsIgnoreCase(type)) {
					int value = Integer.parseInt(paramValue);
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				} else if ("double".equalsIgnoreCase(type)) {
					double value = Double.parseDouble(paramValue);
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				} else if ("string".equalsIgnoreCase(type)) {
					String value = paramValue;
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				} else if ("date".equalsIgnoreCase(type)) {

					Date value = dateFormat.parse(paramValue);
					// TODO 完善参数验证的代码

					container.put(paramName, value);

				} else if ("datetime".equalsIgnoreCase(type)) {
					Date value = null;
					if (paramValue.indexOf("T") == -1) {
						value = dateTimeFormat.parse(paramValue);
					} else {
						value = dateTimeFormatT.parse(paramValue);
					}
					// TODO 完善参数验证的代码

					container.put(paramName, value);

				} else if ("text".equalsIgnoreCase(type)) {
					String value = paramValue;
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				}
			} catch (Exception e) {
				logger.error("参数验证，转换异常发生:name:" + paramName + ";value:"
						+ paramValue);
				e.printStackTrace();
				return false;
			}
		} else {
			// 数组参数

			String[] paramValue = request.getParameterValues(paramName);

			Boolean mustFill = fieldVal.getBoolean("mustFill");
			// 必填检查
			if (!mustFill) {
				// 不是必填项，如果为空则直接返回true。验证通过。
				if (null == paramValue || paramValue.length == 0) {
					return true;
				}

			} else {
				// 是必填项，如果为空则返回false。验证不通过
				if (null == paramValue || paramValue.length == 0) {
					return false;
				}
			}
			// TODO 去掉空格，需要根据配置判断是否需要。
			if (paramValue != null) {
				for (int i = 0; i < paramValue.length; i++) {
					paramValue[i] = paramValue[i].trim();
				}

			}
			// 类型转换和验证。
			String type = fieldVal.getString("type");
			try {
				if ("int".equalsIgnoreCase(type)) {

					int[] value = new int[paramValue.length];
					for (int i = 0; i < paramValue.length; i++) {
						value[i] = Integer.parseInt(paramValue[i]);
					}
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				} else if ("double".equalsIgnoreCase(type)) {
					double[] value = new double[paramValue.length];
					for (int i = 0; i < paramValue.length; i++) {
						value[i] = Double.parseDouble(paramValue[i]);
					}
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				} else if ("string".equalsIgnoreCase(type)) {
					String[] value = paramValue;
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				} else if ("date".equalsIgnoreCase(type)) {
					Date[] value = new Date[paramValue.length];
					for (int i = 0; i < paramValue.length; i++) {
						value[i] = dateFormat.parse(paramValue[i]);
					}
					// TODO 完善参数验证的代码

					container.put(paramName, value);

				} else if ("datetime".equalsIgnoreCase(type)) {
					Date[] value = new Date[paramValue.length];
					for (int i = 0; i < paramValue.length; i++) {
						if (paramValue[i].indexOf("T") == -1) {
							value[i] = dateTimeFormat.parse(paramValue[i]);
						} else {
							value[i] = dateTimeFormatT.parse(paramValue[i]);
						}
					}

					// TODO 完善参数验证的代码

					container.put(paramName, value);

				} else if ("text".equalsIgnoreCase(type)) {
					String[] value = paramValue;
					// TODO 完善参数验证的代码

					container.put(paramName, value);
				}
			} catch (Exception e) {
				logger.error("参数验证，转换异常发生:name:" + paramName + ";value:"
						+ paramValue);
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}
}
