package com.tg.controller;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.Application;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tg.entity.Monitoring;
import com.tg.entity.test;
import com.tg.service.MonitoringService;
import com.tg.service.testService;


@Controller

@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	private MonitoringService monitoringService;
	
	@RequestMapping("/up.do")
	public void saveTest(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("上传");
		try {
			//得到存放上传文件的真实路径
			String path = request.getContextPath();
			String realpath = request.getSession().getServletContext().getRealPath("/file/");
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
			//设置环境
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//判断一下form是否是enctype=multipart/form-data类型的
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(!isMultipart){
				System.out.println("类型错误");
			}
			//ServletFileUpload核心类
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解析
			List<FileItem> items = upload.parseRequest(request);
			System.out.println(items);
			for(FileItem item:items){
				if(item.isFormField()){
					//普通字段
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					System.out.println(fieldName+"="+fieldValue);
				}else{
					//上传字段
					InputStream in = item.getInputStream();
					//上传的文件名
					String fileName = item.getName();//   C:\Documents and Settings\wzhting\妗岄潰\a.txt        a.txt
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);//   a.txt
					System.out.println("filename="+fileName);
					
					Monitoring mo = new Monitoring();
					mo.setEcg(fileName);
					monitoringService.add(mo);//写入数据库
					//构建输出流
					String storeFile = realpath+"\\"+fileName;
					System.out.println(storeFile);
					OutputStream out = new FileOutputStream(storeFile);
					
					byte b[] = new byte[1024];
					int len = -1;
					while((len=in.read(b))!=-1){
						out.write(b,0,len);
					}
					out.close();
					in.close();
				}
			}
		} catch (FileUploadException e) {
			throw new RuntimeException("服务器忙");
			// TODO Auto-generated catch block
		} catch (IOException e) {
			
		}
	}
}