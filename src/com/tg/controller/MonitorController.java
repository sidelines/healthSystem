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
import com.tg.entity.Monitoring;
import com.tg.entity.test;
import com.tg.service.DoctorService;
import com.tg.service.MonitoringService;
import com.tg.service.testService;


@Controller

@RequestMapping("/monitor")
public class MonitorController {
	
	@Autowired
	private MonitoringService monitoringService; 
	@Autowired
	private DoctorService doctorService;
	
	
	//报警处理
	@RequestMapping("/add.do")
	public  void saveTest(HttpServletRequest request,HttpServletResponse response){
		
		Monitoring mo = new Monitoring();
		
		String highpress1= request.getParameter("highpress");
		String lowpress1 = request.getParameter("lowpress");
		String temperature1 = request.getParameter("temperature");
		String pulse1 = request.getParameter("pulse");
		String doctorname = request.getParameter("doctor");
		
		int highpress=Integer.parseInt(highpress1);
		System.out.println(highpress);
		int lowpress=Integer.parseInt(lowpress1);
		System.out.println(lowpress);
		double temperature=Double.parseDouble(temperature1);
		System.out.println(temperature);
		int pulse=Integer.parseInt(pulse1);
		System.out.println(pulse);
		int warning=0;
		
		//从数据库中取得m_id的值
		Monitoring monitor = monitoringService.findOne(mo, ".findM_id");
		System.out.println(monitor);
		
		//判断是否需要报警
		if(highpress>180||lowpress>110||temperature>40||pulse>110)
		{
			warning=1;
		}
		//根据医生名字判断医生id
		Doctor doct = new Doctor();
		doct.setD_name(doctorname);
		doct = doctorService.findOne(doct,".findOne");
		System.out.println(doct);
		//从session中获取用户id
		HttpSession hs= request.getSession(true);
		int u_id=(Integer) hs.getAttribute("u_id");
		
		mo.setD_id(doct.getD_id());
		mo.setU_id(u_id);
		mo.setHighpressure(highpress);
		mo.setLowpressure(lowpress);
		mo.setTemperature(temperature);
		mo.setPulse(pulse);
		mo.setWarning(warning);
		mo.setM_id(monitor.getM_id());
		System.out.println(mo);
		monitoringService.update1(mo);//讲数据添加进数据库
		try {
			request.getRequestDispatcher("../show/showjiance.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/del.do")
	public void delMonitoring(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("~~~~~del");
		int delparm= Integer.parseInt(request.getParameter("delparm"));
		monitoringService.deleteOne(delparm);//删除数据
		try {
			request.getRequestDispatcher("../show/showjiance.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}