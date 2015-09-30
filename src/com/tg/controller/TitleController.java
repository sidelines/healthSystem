package com.tg.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.Doctor;
import com.tg.entity.Title;
import com.tg.service.DoctorService;
import com.tg.service.TitleService;



@Controller

@RequestMapping("/title")
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/addcontext.do")
	public void addcontext(HttpServletRequest request,HttpServletResponse response){
		HttpSession hs= request.getSession(true);
		int u_id=(Integer) hs.getAttribute("u_id");
		
		String title= request.getParameter("title");
		String doctor = request.getParameter("doctor");
		String context = request.getParameter("context");
		//根据医生名字判断医生id
		Doctor doct = new Doctor();
		doct.setD_name(doctor);
		doct = doctorService.findOne(doct,".findOne");
		System.out.println(doct);
				
		Title t = new Title();
		t.setU_id(u_id);
		t.setD_id(doct.getD_id());
		t.setTitle(title);
		t.setDoctorname(doctor);
		t.setContext(context);
		System.out.println("信息录入"+t);
		titleService.add(t);
		try {
			request.getRequestDispatcher("../show/showContext.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deltitledoctor.do")
	public void deltitledoctor (HttpServletRequest request ,HttpServletResponse response)
	{
		int deltitledoctorparm =Integer.parseInt(request.getParameter("deltitledoctorparm"));
		titleService.deleteOne(deltitledoctorparm);
		try {
			request.getRequestDispatcher("../show/showContextCL.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deltitleuser.do")
	public void deltitleuser (HttpServletRequest request ,HttpServletResponse response)
	{
		int deltitledoctorparm =Integer.parseInt(request.getParameter("deltitledoctorparm"));
		titleService.deleteOne(deltitledoctorparm);
		try {
			request.getRequestDispatcher("../show/showContext.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}