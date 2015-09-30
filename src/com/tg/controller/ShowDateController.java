package com.tg.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.Doctor;
import com.tg.entity.Monitoring;
import com.tg.entity.Title;
import com.tg.entity.User;
import com.tg.entity.add.ShowBaojingDate;
import com.tg.entity.add.ShowBingliDate;
import com.tg.service.DoctorService;
import com.tg.service.MonitoringService;
import com.tg.service.ShowBaojingDateService;
import com.tg.service.ShowBingliDateService;
import com.tg.service.TitleService;
import com.tg.service.UserService;



@Controller

@RequestMapping("/show")
public class ShowDateController {
	
	@Autowired
	private MonitoringService monitoringService; 
	@Autowired
	private ShowBaojingDateService showBaojingDateService;
	@Autowired
	private ShowBingliDateService showBingliDateService;
	@Autowired
	private TitleService titleService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UserService userService;
	@RequestMapping("/showhealth.do")
	public String showhealth(HttpServletRequest request)
	{
		System.out.println("asfdasdf");
		return "a";
	}
	/*================================================用户页面信息显示=================================== */
	//显示用户个人信息
	@RequestMapping("/showUser.do")
	public String showUser(HttpServletRequest request)
	{
		HttpSession hs= request.getSession(true);
		int u_id=(Integer) hs.getAttribute("u_id");
		
		User us = new User();
		us.setU_id(u_id);
		List<User> UserInfo = userService.getListByentity(us);
		System.out.println(UserInfo);
		request.setAttribute("UserInfos", UserInfo);
		return "/user/gerenxinxi";
	}
	
	//数据监测页面数据显示
	@RequestMapping("/showjiance.do")
	public String showjiance(HttpServletRequest request){
		HttpSession hs= request.getSession(true);
		int u_id=(Integer) hs.getAttribute("u_id");
		List<Monitoring> Monitoring = monitoringService.getList(u_id);
		System.out.println(Monitoring);
		request.setAttribute("Monitorings", Monitoring);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "/user/shujujiance";
	}
	//患者病例页面数据显示
		@RequestMapping("/showUserbingli.do")
		public String showUserbingli(HttpServletRequest request){
			HttpSession hs= request.getSession(true);
			int u_id=(Integer) hs.getAttribute("u_id");//拿到当前病人的id
			System.out.println("u_id="+u_id);
			ShowBingliDate sbli = new ShowBingliDate();//将数据写入类型中
			sbli.setU_id(u_id);
			List<ShowBingliDate> showBingliDate =showBingliDateService.getListByentity(sbli);//从数据库中读取数据
			System.out.println(showBingliDate);
			request.setAttribute("showBingliDates1", showBingliDate);
			System.out.println("showbingli");
			return "/user/binglixinxi";
		}
		//患者信息发布
		@RequestMapping("/showContext.do")
		public String showContext(HttpServletRequest request)
		{
			HttpSession hs= request.getSession(true);
			int u_id=(Integer) hs.getAttribute("u_id");
			
			Title title = new Title();
			title.setU_id(u_id);
			List<Title> showcontext = titleService.getListByValue(title);
			System.out.println("~~~~~~~~~~信息显示");
			System.out.println(showcontext);
			request.setAttribute("showcontexts", showcontext);
			return "/user/fabuxinxi";
		}
/*================================================================================================= */
		
		
/*================================================医生页面信息显示=================================== */
	//显示医生个人信息
	@RequestMapping("/showDoctor.do")
	public String showDoctor(HttpServletRequest request)
	{
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");
		
		Doctor doc = new Doctor();
		doc.setD_id(d_id);
		List<Doctor> DoctorInfo = doctorService.getListByentity(doc);
		System.out.println(DoctorInfo);
		request.setAttribute("DoctorInfos", DoctorInfo);
		return "/doctor/gerenxinxi";
	}
	//报警信息页面数据显示
	@RequestMapping("/showbaojing.do")
	public String showbaojing(HttpServletRequest request){
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");//拿到当前医生的id
		
		ShowBaojingDate sbd = new ShowBaojingDate();//将数据写入类型中
		sbd.setD_id(d_id);
		List<ShowBaojingDate> showBaojingDate =showBaojingDateService.getListByentity(sbd);//从数据库中读取数据
		System.out.println(showBaojingDate);
		request.setAttribute("showBaojingDates", showBaojingDate);

		return "/doctor/baojingchuli";
	}
	//病情分析页面数据显示
	@RequestMapping("/showfenxi.do")
	public String showfenxi(HttpServletRequest request){
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");//拿到当前医生的id
		
		ShowBaojingDate sbd = new ShowBaojingDate();//将数据写入类型中
		sbd.setD_id(d_id);
		List<ShowBaojingDate> showBaojingDate =showBaojingDateService.getListByValue(sbd);//从数据库中读取数据
		System.out.println(showBaojingDate);
		request.setAttribute("showBaojingDates1", showBaojingDate);

		return "/doctor/jibingfenxi";
	}
	//医生病例页面数据显示
	@RequestMapping("/showbingli.do")
	public String showbingli(HttpServletRequest request){
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");//拿到当前医生的id
		
		ShowBingliDate sbl = new ShowBingliDate();//将数据写入类型中
		sbl.setD_id(d_id);
		List<ShowBingliDate> showBingliDate =showBingliDateService.getListByValue(sbl);//从数据库中读取数据
		System.out.println(showBingliDate);
		request.setAttribute("showBingliDates", showBingliDate);
		System.out.println("showbingli");
		return "/doctor/huanzhexinxi";
	}
	//医生信息处理
	@RequestMapping("/showContextCL.do")
	public String showContextCL(HttpServletRequest request)
	{
		HttpSession hs= request.getSession(true);
		int d_id=(Integer) hs.getAttribute("d_id");
		
		Title title = new Title();
		title.setD_id(d_id);
		List<Title> showcontext = titleService.getListByentity(title);
		System.out.println("~~~~~~~~~~信息显示");
		System.out.println(showcontext);
		request.setAttribute("showcontexts1", showcontext);
		return "/doctor/xinxichuli";
	}
/*===============================================================================================*/
	
}