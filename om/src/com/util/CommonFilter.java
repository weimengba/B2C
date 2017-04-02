package com.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartResolver;

/**
 * 该类的作用是实现Filter过滤器接口 用于实现处理和过滤前台请求具体业务
 * 
 * @author sqy
 * 
 */
public class CommonFilter implements Filter {
	/**
	 * 容器调用destroy()方法指出将从服务中删除该过滤器。 如果过滤器使用了其他资源，需要在这个方法中释放这些资源。
	 */
	@Override
	public void destroy() {

	}

	/**
	 * 每当请求和响应经过过滤器链时，容器都要调用一次该方法。 需要注意的是过滤器的一个实例可以同时服务于多个请求，
	 * 特别需要注意线程同步问题，尽量不用或少用实例变量。 在过滤器的doFilter()方法实现中，
	 * 任何出现在FilterChain的doFilter方法之前地方，request是可用的； 在doFilter()方法之后response是可用的。
	 */
	@Override
	public void doFilter(ServletRequest r, ServletResponse s, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("*************CommonFilter 执行!*************");

		// 获得HttpServlet请求，
		HttpServletRequest request = (HttpServletRequest) r;
		// 获得HttpServlet相应，
		HttpServletResponse response = (HttpServletResponse) s;
		// 获得用户请求的session
		HttpSession session = request.getSession();
		// 获得全局的储存信息的空间context
		ServletContext context = session.getServletContext();

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(context);
		MultipartResolver multipartResolver = (MultipartResolver) ctx
				.getBean("multipartResolver");
		request = multipartResolver
				.resolveMultipart((HttpServletRequest) request);

		// 获取mm
		MM mm = MMUtil.getMM();
		// 1.服务器端校验，参数验证框架入口。同时做数据类型转换。
		Validator valditator = Validator.getValidator();
		if (!valditator.validateAndConver(request, mm)) {
			// 如果服务端校验不通过，跳转到出错页面。
			request.getRequestDispatcher("/WEB-INF/jsp/validateError.jsp")
					.forward(r, s);
		} else {
			mm.put("mm_reqeust", request);
			mm.put("mm_response", response);
			mm.put("mm_session", session);
			mm.put("mm_context", context);

			// 统一处理分页。
			String curString = request.getParameter("c_cur");
			MMUtil.setPageParam(curString);
			// 统一处理排序。
			String orderName = request.getParameter("c_od");
			String orderDesc = request.getParameter("c_desc");
			MMUtil.setOrder(orderName, orderDesc);
			// 过滤器继续执行。

			
			//对于编辑，详情等简单业务传入的ID，跳过Validator通用验证实现，简化开发配置。
			String id = request.getParameter("id");
			if(id!=null && !"".equals(id)){
				MMUtil.put("id", id);
			}
			
			// 打印调试信息。
			MMUtil.printMMMessage();

			fc.doFilter(r, s);
		}
		// 2.超级容器资源回收。
		MMUtil.clear();

	}

	/**
	 * web容器调用本方法，说明过滤器正被加载到web容器中去。 容器只有在实例化过滤器时才会调用该方法一次。
	 * 容器为这个方法传递一个FilterConfig对象，其中包含与Filter相关的配置信息。
	 */
	@Override
	public void init(FilterConfig fc) throws ServletException {

	}

}
