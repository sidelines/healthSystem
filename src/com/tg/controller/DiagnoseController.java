package com.tg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.Diagnose;
import com.tg.entity.Monitoring;
import com.tg.entity.Report;
import com.tg.entity.test;
import com.tg.service.DiagnoseService;
import com.tg.service.MonitoringService;
import com.tg.service.ReportService;
import com.tg.service.testService;


@Controller

@RequestMapping("/diagnose")
public class DiagnoseController {
	

	@Autowired
	private DiagnoseService diagnoseService;
	@Autowired
	private MonitoringService monitoringService;
	@Autowired
	private ReportService reportService;
	@RequestMapping("/test.do")
	public void saveTest(HttpServletRequest request){
		System.out.println("diatest");
		String u_id = request.getParameter("u_id");
		System.out.println("u_id="+u_id);
		String m_id = request.getParameter("m_id");
		System.out.println("m_id="+m_id);
		
	}
	@RequestMapping("/addBaojing.do")
	public void addBaojing(HttpServletRequest request,HttpServletResponse response){
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");
		
		System.out.println("diatest");
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		System.out.println("u_id="+u_id);
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		System.out.println("m_id="+m_id);
		String condition=request.getParameter("condition");
		System.out.println(condition);
		String state=request.getParameter("state");
		System.out.println(state);
		String reportname=request.getParameter("reportname");
		System.out.println("reportname="+reportname);
		
		//通过condition和state获取reprot
		Report re = new Report();
		re.setR_con(condition);
		re.setR_st(state);
		re=reportService.findOne(re, ".findreprot");//从数据库中查找report
		System.out.println(re);
		//将值写入Diagnose中
		Diagnose dia = new Diagnose();
		dia.setD_id(d_id);
		dia.setU_id(u_id);
		dia.setM_id(m_id);
		dia.setCondition(condition);
		dia.setState(state);
		dia.setReportname(reportname);
		dia.setReport(re.getR_re());
		System.out.println(dia);
		diagnoseService.add(dia);//向数据库中写值
		//通过m_id更改warning的值
		Monitoring Mon= new Monitoring();
		Mon.setM_id(m_id);
		monitoringService.update(Mon);//从数据库中改变值
		try {
			request.getRequestDispatcher("../show/showbaojing.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addfenxi.do")
	public void addfenxi(HttpServletRequest request,HttpServletResponse response){
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");
		
		System.out.println("diatest");
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		System.out.println("u_id="+u_id);
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		System.out.println("m_id="+m_id);
		String condition=request.getParameter("condition");
		System.out.println(condition);
		String state=request.getParameter("state");
		System.out.println(state);
		String reportname=request.getParameter("reportname");
		System.out.println("reportname="+reportname);
		
		//通过condition和state获取reprot
		Report re = new Report();
		re.setR_con(condition);
		re.setR_st(state);
		re=reportService.findOne(re, ".findreprot");//从数据库中查找report
		System.out.println(re);
		//将值写入Diagnose中
		Diagnose dia = new Diagnose();
		dia.setD_id(d_id);
		dia.setU_id(u_id);
		dia.setM_id(m_id);
		dia.setCondition(condition);
		dia.setState(state);
		dia.setReportname(reportname);
		dia.setReport(re.getR_re());
		System.out.println(dia);
		diagnoseService.add(dia);//向数据库中写值
		//通过m_id更改warning的值
		Monitoring Mon= new Monitoring();
		Mon.setM_id(m_id);
		monitoringService.update(Mon);//从数据库中改变值
		try {
			request.getRequestDispatcher("../show/showfenxi.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deldiagnose.do")
	public void deldiagnose(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("~~~~~deldiagnose");
		int deldiagparm= Integer.parseInt(request.getParameter("deldiagparm"));
		diagnoseService.deleteOne(deldiagparm);//删除数据
		try {
			request.getRequestDispatcher("../show/showbingli.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/delUserdiagnose.do")
	public void delUserdiagnose(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("~~~~~deldiagnose");
		int deldiagparm= Integer.parseInt(request.getParameter("deldiagparm"));
		diagnoseService.deleteAll(deldiagparm);//删除数据
		try {
			request.getRequestDispatcher("../show/showUserbingli.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}