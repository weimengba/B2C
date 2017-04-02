package com.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 该类的作用是实现HandlerInterceptor过滤器接口 用于实现处理和过滤前台请求具体业务
 * 
 * @author sqy
 * 
 */
public class CommonInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex)
			throws Exception {

		// 超级容器资源回收。
		MMUtil.clear();
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object, ModelAndView mav)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {

		System.out.println("*************CommonInterceptor 执行!*************");
		// 获得用户请求的session
		HttpSession session = request.getSession();
		// 获得全局的储存信息的空间context
		ServletContext context = session.getServletContext();

		// Enumeration<String> names = request.getParameterNames();
		// while (names.hasMoreElements()) {
		// String name = names.nextElement();
		// System.out.println("***************"+name + ":" +
		// request.getParameter(name));
		// }

		// 获取mm
		MM mm = MMUtil.getMM();
		mm.put("mm_reqeust", request);
		mm.put("mm_response", response);
		mm.put("mm_session", session);
		mm.put("mm_context", context);
		// 1.服务器端校验，参数验证框架入口。同时做数据类型转换。
		Validator valditator = Validator.getValidator();
		if (!valditator.validateAndConver(request, mm)) {
			// 如果服务端校验不通过，抛出异常。
			throw new Exception("参数验证出错！");
		} else {

			// 登录的ID统一存放到MM对象中，方便使用。
			if (session.getAttribute("c_mid") != null) {
				mm.put("mm_mid", session.getAttribute("c_mid"));
			}

			// 前台客户登录的ID统一存放到MM对象中，方便使用。
			if (session.getAttribute("c_cid") != null) {
				mm.put("mm_cid", session.getAttribute("c_cid"));
			}

			// 统一处理分页。
			String curString = request.getParameter("c_cur");
			MMUtil.setPageParam(curString);
			// 统一处理排序。
			String orderName = request.getParameter("c_od");
			String orderDesc = request.getParameter("c_desc");
			MMUtil.setOrder(orderName, orderDesc);
			// 过滤器继续执行。

			// 打印调试信息。
			MMUtil.printMMMessage();

			return true;
		}
	}

}
