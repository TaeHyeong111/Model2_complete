package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.Receiver;
import domain.ImageBean;
import domain.MemberBean;
import enums.Action;
import enums.Path;
import service.ImageServiceImpl;
import service.MemberServiceImpl;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("멤버두 들어옴");
		Receiver.init(request);
		System.out.println("++++"+Receiver.cmd.getAction().toUpperCase());
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE : 
				Carrier.forward(request, response);
			break;
		case ADD :
			System.out.println("케이스탐");
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case LOGIN : 
			System.out.println("========");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
			}
			break;
			
		case MODIFY : 
			System.out.println("업데이트들어옴");
			Carrier.redirect(request, response,"/member.do?action=retrieve");
			break;
		case REMOVE : 
			System.out.println("===딜리트진입===");
			Carrier.redirect(request, response,"");
			break;
		case RETRIEVE : 
			System.out.println("리트리브");
			Carrier.forward(request, response);
			break;
		case FILEUPLOAD :
			System.out.println("===[1]===");
			if(!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			System.out.println("===[2]===업로드파일이 존재함");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*40); //3MB
			upload.setSizeMax(1024*1024*50); //50MB
			List<FileItem> items = null;
			
			try {
				ImageBean bean = new ImageBean();
				System.out.println("===[3]===try 내부로 진입");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				System.out.println("===[4]=== items 생성");
				Iterator<FileItem>iter = items.iterator();
						while(iter.hasNext()) {
							System.out.println("===[5]===while 진입");
							FileItem item = (FileItem)iter.next();
							if(!item.isFormField()) {
								System.out.println("===[6]===if 진입");
								String fileName = item.getName();
								System.out.println("파일네임 : "+fileName);
								
								bean.setImgName(fileName.substring(0,fileName.lastIndexOf(".")));
								bean.setExtension(fileName.substring(fileName.lastIndexOf(".")+1));
								bean.setUserid(((MemberBean) request.getSession().getAttribute("user")).getUserId());
								ImageServiceImpl.getInstance().add(bean);
								file = new File(Path.UPLOAD_PATH+fileName);
								System.out.println("파일"+file);
								item.write(file);
								System.out.println("===[7]===파일업로드 성공 !!!");
								//image table 에 id, image name, ext 저장
							}else {
								System.out.println("===[8]===파일업로드실패");
							}
						}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("===[10]===");
			Carrier.redirect(request, response,"/member.do?action=retrieve&page=retrieve");
		default:
			break;
		}
	}
	
}
