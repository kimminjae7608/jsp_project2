package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcpdev.dao.GuguUserDao;
import com.jcpdev.dto.GuguUser;
import com.jcpdev.dto.TotalProfile;

public class ProfileMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		GuguUserDao dao = GuguUserDao.getInstance();
		TotalProfile bean = dao.getOne(idx);
		request.setAttribute("bean", bean);

		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="profile/profileMain.jsp";
		return forward;
	}

}
