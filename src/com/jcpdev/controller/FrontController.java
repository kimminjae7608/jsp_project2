package com.jcpdev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.controller.action.Action;
import com.jcpdev.controller.action.ActionForward;
import com.jcpdev.controller.action.DeleteFriend;
import com.jcpdev.controller.action.GalleryInsertAction;
import com.jcpdev.controller.action.GalleryMainAction;
import com.jcpdev.controller.action.GuestBookAction;
import com.jcpdev.controller.action.GuestBookAddAction;
import com.jcpdev.controller.action.GuestBookDeleteAction;
import com.jcpdev.controller.action.GuestBookSaveAction;
import com.jcpdev.controller.action.LoginAction;
import com.jcpdev.controller.action.LogoutAction;
import com.jcpdev.controller.action.LookForEmailAction;
import com.jcpdev.controller.action.LookForPWAction;
import com.jcpdev.controller.action.MateAction;
import com.jcpdev.controller.action.MemberAction;
import com.jcpdev.controller.action.MiniHomeAction;
import com.jcpdev.controller.action.NewFriendAction;
import com.jcpdev.controller.action.NewMateAction;
import com.jcpdev.controller.action.ProfileMainAction;
import com.jcpdev.controller.action.ProfileModifyAction;
import com.jcpdev.controller.action.ProfileUpdateAction;
import com.jcpdev.controller.action.RequestFriendAction;
import com.jcpdev.controller.action.RequestMateAction;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	//요청Method 구별없이 실행 -> doGet() 또는 doPost()메소드 실행내용 있으면 실행.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward=null; 
		String spath = request.getServletPath();
		String path="home.jsp";
		
		if(spath.equals("/member.do")) { //회원가입 양식으로 이동해서 파라미터값 입력  
			path = "member.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/member_save.do")) { // 양식에 적었던 파라미터값을 dao.insert
			Action action = new MemberAction();
			forward = action.execute(request, response);      
		}else if(spath.equals("/login.do")) {  // 로그인 할수있는 jsp (이메일,비번 파라미터 입력)
			path = "login.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/loginAction.do")) {// 이메일,비번 파라미터값을 dao.login
			Action action = new LoginAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/logout.do")) { // 세션을 초기화하여 로그아웃 상태를 만든다.
			Action action = new LogoutAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/home.do")) {  // 로그인,로그아웃 후 임시이동 
			path = "home.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/lostPW.do")) {  // 비번 잊어버림
			path = "lostPW.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/lookForPW.do")) { // 비번찾기 dao.lookForPW
			Action action = new LookForPWAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/lostEmail.do")) {  // email 잊어버림
			path = "lostEmail.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/lookForEmail.do")) { // email(아이디)찾기 dao.lookForEmail
			Action action = new LookForEmailAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/profileMain.do")) {  // �옄�떊�쓽 �봽濡쒗븘�쓣 蹂쇱닔 �엳�뒗怨� (�닔�젙x)--------------------------------------------
			Action action = new ProfileMainAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/profileModify.do")) {  // �닔�젙 �엯�젰�븯湲곗쐞�빐 �씠�룞
			Action action = new ProfileModifyAction();
			forward = action.execute(request, response); 
		}else if(spath.equals("/profileUpdate.do")) {  // 濡쒓렇�씤,濡쒓렇�븘�썐 �썑 �엫�떆�씠�룞 
			Action action = new ProfileUpdateAction();
			forward = action.execute(request, response); 
		}else if(spath.equals("/gallery.do")) {  // �옄�떊�쓽 媛ㅻ윭由щ�� 蹂쇱닔 �엳�뒗怨� (�닔�젙x)------------------------------------------
			Action action = new GalleryMainAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryRegist.do")) {
			path = "gallery/galleryRegist.jsp";
			forward = new ActionForward(false,path);
		}else if(spath.equals("/galleryInsert.do")) {  
			Action action = new GalleryInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryUpdate.do")) {
			path = "gallery/galleryUpdate.jsp";
			forward = new ActionForward(false,path);
		}		
		// minjae
		else if(spath.equals("/minihome.do")) {
			Action action = new MiniHomeAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/mateAction.do")) {
			Action action = new MateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/newfriend.do")) {
			Action action = new NewFriendAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/newmate.do")) {
			Action action = new NewMateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/requestfriendaction.do")) {
			Action action = new RequestFriendAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/requestmateaction.do")) {
			Action action = new RequestMateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/deletefriend.do")) {
			Action action = new DeleteFriend();
			forward = action.execute(request, response);
		}
		//방명록남기기 추가
		else if(spath.equals("/guestbook.do")) { 
			Action action = new GuestBookAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/guestbookadd.do")) { 
			Action action = new GuestBookAddAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/guestbooksave.do")) { 
			Action action = new GuestBookSaveAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/guestbookdelete.do")) { 
			Action action = new GuestBookDeleteAction();
			forward = action.execute(request, response);
		}
		
		
		
		
		
		//이 시점에서 forward 에 isRedirect 와 url 값이 저장되었으면 ok!
		if(forward.isRedirect()) {   //타입 boolean 일때는 getXXX 아니고 isXXX 입니다.
			response.sendRedirect(forward.getUrl());
		}else {
			RequestDispatcher rd 
			= request.getRequestDispatcher(forward.getUrl()); //getRequest가지로 전달
			rd.forward(request, response);
		}
		
	}

}
