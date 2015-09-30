package com.tg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.User;
import com.tg.entity.test;
import com.tg.service.UserService;
import com.tg.service.testService;


@Controller

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping("/ajaxSign.do")
	public void ajaxSign(HttpServletRequest request,HttpServletResponse response){
		System.out.println("aaaaaaaaaaa");
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			String username=request.getParameter("username");
			User u = new User();
			u.setU_username(username);
			int count = userService.countByCondition(u, ".ajaxSign");
			if(count==1)
		       {
		    	   out.write("用户名已经存在");
		       }
		       else
		       {
		    	   out.write("用户名可以使用");
		       }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/Sign.do")
	public void Sign(HttpServletRequest request,HttpServletResponse response)
	{
		try{
			String username=request.getParameter("username");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String password = request.getParameter("twopassword");
			String sex = request.getParameter("sex");
			System.out.println(username+name+age+password+sex);
			User u = new User();
			u.setU_username(username);
			u.setU_name(name);
			u.setU_age(age);
			u.setU_password(password);
			u.setU_sex(sex);
			System.out.println(u);
			userService.add(u);
			response.sendRedirect("../page/main/login.html");
			}
		catch(IOException e)
		{
			try {
				response.sendRedirect("../page/main/signfail.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}