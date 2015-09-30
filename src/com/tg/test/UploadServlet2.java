package com.tg.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//入门案例
public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//得到存放上传文件的真实路径
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
			//设置环境
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//判断一下form是否是enctype=multipart/form-data类型的
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(!isMultipart){
				System.out.println("大傻鸟");
				return;
			}
			//ServletFileUpload核心类
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解析
			List<FileItem> items = upload.parseRequest(request);
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
					//构建输出流
					String storeFile = path+"\\"+fileName;
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
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
