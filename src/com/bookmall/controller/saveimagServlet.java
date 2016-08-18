package com.bookmall.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class saveimagServlet
 */
@WebServlet("/servlet/saveimagServlet")
public class saveimagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PATH_FOLDER = "/";

	private static String TEMP_FOLDER = "/";
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletCtx = config.getServletContext();

		PATH_FOLDER = servletCtx.getRealPath("/img/book_img");

		TEMP_FOLDER = servletCtx.getRealPath("/imgTemp/book_img");
	}

    public saveimagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
			request.setCharacterEncoding("utf-8"); 
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setRepository(new File(TEMP_FOLDER));
			factory.setSizeThreshold(1024 * 1024);
			ServletFileUpload  upload=new ServletFileUpload(factory);
			List<FileItem> list=upload.parseRequest(request);
			FileItem item = getUploadFileItem(list);
			String filename = getUploadFileName(item);
		//	String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
	
			String picUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/img/book_img/"+filename;

			System.out.println("存文件目录:" + PATH_FOLDER);
			System.out.println("文件名:" + filename);
			System.out.println("服务器路径:" + picUrl);
			String savePath="F:\\eclipsej2eeworkspace\\BookMallProject\\WebContent\\img";
			System.out.println(savePath);
			item.write(new File(savePath,filename)); 
			request.getSession().setAttribute("filename", filename);
			item.write(new File(PATH_FOLDER, filename));
			PrintWriter writer = response.getWriter();
			
			writer.print("{");
			writer.print("msg:\"文件名:"+item.getSize()+"\"");
			writer.print(",picName:\""+filename+"\"");
			writer.print(",picUrl:\"" + picUrl + "\"");
			writer.print("}");
			
			writer.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private FileItem getUploadFileItem(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if(!fileItem.isFormField()) {
				return fileItem;
			}
		}
		return null;
	}
	
	private String getUploadFileName(FileItem item) {
		String value = item.getName();
		int start = value.lastIndexOf("/");
		String filename = value.substring(start + 1);
		System.out.println(filename);
		
		return filename;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		doGet(request,response);
	}

}
