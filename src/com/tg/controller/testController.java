package com.tg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.test;
import com.tg.service.testService;


@Controller

@RequestMapping("/test")
public class testController {
	
	@Autowired
	private testService testService; 
	
	@RequestMapping("/saveTest.do")
	public String saveTest(HttpServletRequest request){
		System.out.println("aaaaaaaaaaa");
		test test =  new test();
		test.setUser("2223232");
		test.setPwd("123asdfŒ¥»∑»œ");
		System.out.println(test);
		testService.add(test);
		System.out.println("aaaa");
		
		return "kx";
	}
}