package com.chen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(value="/mvc") 如果这里加上这个那么请求的url中药加上这个
public class BaseController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET,
			produces="application/json;charset=UTF-8")
	public String login(){
		return "login";
	}
	/**
	 * 请求url=localhost:8080/login
	 * 方法：post请求
	 * produces
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/test",method=RequestMethod.GET,
	produces="application/json;charset=UTF-8")
	public @ResponseBody String test(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@RequestMapping(value="/login1",method=RequestMethod.GET,
	produces="application/json;charset=UTF-8")
	public @ResponseBody String login1(String name) {
		return "login1";
	}
	/**
	 * 返回本身，可以是json，也可以是xml等
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login2",method=RequestMethod.GET,
	produces="application/json;charset=UTF-8")
	public @ResponseBody String login2(String name, Model model) {
		model.addAttribute("name", name);
		return "login2";
	}
	/**
	 * 直接返回字符串的形式，会根据spring配置文件中的
	 * org.springframework.web.servlet.view.InternalResourceViewResolver
	 * 中指定的路径下，加上返回的字符串的路径去请求jsp
	 * 
	 * 返回：/views/redirect/redirectResults.jsp
	 * 
	 * 带参数样式
	 * @param account
	 * @param date
	 * @return
	 */
	@RequestMapping(value="login/{account}", method=RequestMethod.GET)
	public String show(@PathVariable String account, @RequestParam(required=false) String date) {
		return "redirect/redirectResults";
	}
}
