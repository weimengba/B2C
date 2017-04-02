package com.pub.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.AjaxMessage;
import com.util.MM;
import com.util.MMUtil;
import com.util.SysUtil;

@Controller
@RequestMapping("/demo")
public class DemoController extends BasePubController {

	/**
	 * 测试1
	 * 
	 * @return
	 */
	@RequestMapping("/t1")
	public ModelAndView t1() {

		MM mm = MMUtil.getMM();
		HttpServletRequest request = (HttpServletRequest) mm.get("mm_reqeust");
		System.out.println("请求的URI是：" + request.getRequestURI());

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> data = demoService.findAllDemo();
		mav.addObject("data", data);
		mav.setViewName("/t1");
		return mav;
	}

	/**
	 * 测试1
	 * 
	 * @return
	 */
	@RequestMapping("/ty")
	public ModelAndView t3() {

		MM mm = MMUtil.getMM();
		HttpServletRequest request = (HttpServletRequest) mm.get("mm_reqeust");
		System.out.println("请求的URI是：" + request.getRequestURI());

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> data = pubGoodsService.selectGoods();
		mav.addObject("data", data);
		mav.setViewName("/ty");
		return mav;
	}

	@RequestMapping("/t2")
	public ModelAndView t2(Integer id, String name) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("name", name);

		int num = demoService.updateDemoNameById(param);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> data = demoService.findAllDemo();
		mav.addObject("data", data);
		mav.setViewName("/t1");
		return mav;
	}

	@RequestMapping("/addDemoForm")
	public String addDemoForm() {
		// for test!
		// return "/atest/demo";
		return "/demo/demo";
	}

	@RequestMapping("/addDemo")
	public String addDemo() {

		demoService.insertDemo();
		System.out.println("提交表单！成功");
		// for test!
		// return "/atest/demo";
		return "/demo/demo";
	}

	/**
	 * 列表
	 * 
	 * @return
	 */
	@RequestMapping("/demoList")
	public ModelAndView demoList() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = demoService.findAllDemo();
		PageInfo page = new PageInfo(data);

		mav.addObject("data", page);

		mav.setViewName("/demo/demoList");
		return mav;
	}

	@RequestMapping("/demofile")
	public ModelAndView demofile() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/demo/file");
		return mav;
	}

	@RequestMapping("/file")
	public ModelAndView file(@RequestParam("img") MultipartFile[] img,
			HttpServletRequest request) {
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			SysUtil.debug(name + ":" + request.getParameter(name));
		}

		try {
			if (img != null && img.length > 0) {
				for (int i = 0; i < img.length; i++) {
					MultipartFile tmp = img[i];
					tmp.transferTo(new File("d:/" + System.currentTimeMillis()
							+ ".jpg"));
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/demo/file");
		return mav;
	}

	/**
	 * 上传文件实例
	 * 
	 * @param files
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam("files") MultipartFile[] files,
			HttpServletRequest request) throws Exception {
		// 判断文件是否为空
		if (files != null && files.length > 0) {
			try {
				// 循环获取file数组中得文件
				for (int i = 0; i < files.length; i++) {
					MultipartFile file = files[i];

					// file.getContentType();
					// file.getOriginalFilename();
					// file.getSize();

					File dir = new File(request.getSession()
							.getServletContext().getRealPath("/")
							+ "upload/");
					if (!dir.exists())
						dir.mkdirs();
					// 转存文件
					String filePath = dir.getAbsolutePath() + File.separator
							+ file.getOriginalFilename();
					file.transferTo(new File(filePath));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "/demo/t1";
	}

	@RequestMapping("/goods")
	@ResponseBody
	public Object goods() {
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List data = pubGoodsService.findGoodsDynamic(MMUtil.getMM());
		PageInfo page = new PageInfo(data);

		Map result = new HashMap();
		result.put("page", page);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		

		return msg;
	}

	@RequestMapping("/login")
	public String login(HttpServletResponse response) {

		String random = UUID.randomUUID().toString().replace("-", "");

		// Redis key 设计：loginUser:random;

		Cookie loginCookie = new Cookie("OM_LOGIN", "");
		loginCookie.setMaxAge(60 * 60 * 24 * 30);

		response.addCookie(loginCookie);
		return "";
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
	}
}
