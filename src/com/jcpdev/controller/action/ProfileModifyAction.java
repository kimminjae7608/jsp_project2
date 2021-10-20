package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GuguUserDao;
import com.jcpdev.dto.GuguUser;
import com.jcpdev.dto.TotalProfile;


public class ProfileModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//수정 버튼-> 내용 변경 -> 저장버튼 으로 실행됩니다.
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		GuguUserDao dao = GuguUserDao.getInstance();
		TotalProfile bean = dao.getOne(idx);
		request.setAttribute("bean", bean);

		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="profile/profileUpdate.jsp";
		return forward;
	}

}
