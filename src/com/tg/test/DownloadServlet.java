package com.tg.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//文件的下载
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		
		String filename = request.getParameter("filename");//get请求方式
		filename = new String(filename.getBytes("ISO-8859-1"),"UTF-8");//中文编码
		
		//截取老文件名
		String oldFileName = filename.split("_")[1];
		//得到存储路径
		String storePath = getServletContext().getRealPath("/WEB-INF/files");
		//得到文件的全部路径
		String filePath = makeStorePath(storePath, filename)+"\\"+filename;
		
		//判断文件是否存在
		File file = new File(filePath);
		if(!file.exists()){
			out.write("对比起！你要下载的文件可能已经不存在了".getBytes("UTF-8"));
			return;
		}
		
		InputStream in = new FileInputStream(file);
		//通知客户端以下载的方式打开
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(oldFileName, "UTF-8"));
		
		byte[] b = new byte[1024];
		int len = -1;
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
		out.write("下载成功".getBytes("UTF-8"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	private String makeStorePath(String storePath, String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode & 0xf;// 0000~1111：整数0~15共16个
		int dir2 = (hashCode & 0xf0) >> 4;// 0000~1111：整数0~15共16个

		String path = storePath + "\\" + dir1 + "\\" + dir2; // WEB-INF/files/1/12
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();

		return path;
	}
}
