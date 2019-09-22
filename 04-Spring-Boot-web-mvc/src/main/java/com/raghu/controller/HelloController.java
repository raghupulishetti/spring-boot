package com.raghu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.raghu.service.HelloService;

@org.springframework.stereotype.Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	@RequestMapping("/wish")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = "";
		String viewName = "welcome";
		String name = request.getParameter("name");
		message = helloService.sayHello(name);
		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewName);
		mv.addObject("msg", message);
		return mv;
		//return new ModelAndView(viewName, "msg", message);
	}

}
