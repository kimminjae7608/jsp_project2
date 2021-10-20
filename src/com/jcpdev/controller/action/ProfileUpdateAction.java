package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GuguUserDao;
import com.jcpdev.dto.GuguUser;
import com.jcpdev.dto.TotalProfile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProfileUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//이미지 파일 받는 과정 (프로젝트 freeboard의  GalleryRegistAction 참고)
		request.setCharacterEncoding("UTF-8");
		String path="c:\\upload";     //서버컴퓨터 로컬경로
	
	      int size=10*1024*1024; //10MByte, 최대파일크기
	      try {
	    	  //업로드된 파일을 받을 수 있는  MultipartRequest타입의 request 객체 생성.
	         MultipartRequest multi_request = new MultipartRequest(request,path,size,"UTF-8",
	                                    new DefaultFileRenamePolicy());
	         
	         // filename을 multi_request로 받아야 하므로 나머지도 전부 multi_ 로 받아야한다.
	        String filename = multi_request.getFilesystemName("filename");       
			int idx = Integer.parseInt(multi_request.getParameter("idx")); 
			String hobby = multi_request.getParameter("hobby"); 
			String school  = multi_request.getParameter("school"); 
			String job = multi_request.getParameter("job"); 
			String mbti = multi_request.getParameter("mbti"); 
			String introduce = multi_request.getParameter("introduce");	
			
			GuguUser dto = new GuguUser();
			dto.setIdx(idx);
			dto.setHobby(hobby);
			dto.setSchool(school);
			dto.setJob(job);
			dto.setMbti(mbti);
			dto.setIntroduce(introduce);
			dto.setFilename(filename);
			
			GuguUserDao dao = GuguUserDao.getInstance();
			dao.update(dto);
			
			TotalProfile bean = dao.getOne(idx);
			request.setAttribute("bean", bean);
	      }catch(Exception e){   e.printStackTrace();   }    
	      
	      
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url = "profile/profileMain.jsp";
		return forward;
	}

}
