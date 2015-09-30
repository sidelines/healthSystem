package com.tg.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.Doctor;
import com.tg.entity.User;
import com.tg.entity.test;
import com.tg.service.DoctorService;
import com.tg.service.UserService;
import com.tg.service.testService;


@Controller

@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DoctorService doctorService;
	
	
	@RequestMapping("/test.do")
	public String saveTest(HttpServletRequest request){
		test test =  new test();
		
		System.out.println("aaaa");
		
		return "kx";
	}
	
	
	@RequestMapping("/checklogin.do")
	public void checkLogin(HttpServletRequest request,HttpServletResponse response)
	{	
		System.out.println("~~~~~~~~");
		String url=null;
		//判断登陆类型是医生还是病人
		String loginType=request.getParameter("loginType");
		System.out.println(loginType+"检查类型");
		
		if(loginType.equals("normal"))//病人
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("username="+username+"password="+password);
			User u = new User();
			u.setU_username(username);
			u.setU_password(password);
			
			int count = userService.countByCondition(u, ".logincheck");
			System.out.println("count="+count);
			if(count==1)
			{
				try {
					u=userService.findOne(u,".findOne");//获取用户信息
					HttpSession hs= request.getSession(true);
					hs.setAttribute("u_username", username);
					hs.setAttribute("u_password", password);
					hs.setAttribute("u_id",u.getU_id() );
					hs.setAttribute("u_name", u.getU_name());
					response.sendRedirect("../page/user/index.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					response.sendRedirect("../page/main/login.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		if(loginType.equals("dynamic"))//医生
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("username="+username+"password="+password);
			Doctor d = new Doctor();
			d.setD_username(username);
			d.setD_password(password);
			int count = doctorService.countByCondition(d, ".logincheck");
			if(count==1)
			{
				try {
					d=doctorService.findOne(d,".getdid");//获取用户信息
					System.out.println(d);
					HttpSession hs= request.getSession(true);
					hs.setAttribute("d_username", username);
					hs.setAttribute("d_password", password);
					hs.setAttribute("d_id",d.getD_id() );
					hs.setAttribute("d_name", d.getD_name());
					response.sendRedirect("../page/doctor/index.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					response.sendRedirect("../page/main/login.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}