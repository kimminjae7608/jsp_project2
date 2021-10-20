package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GuguUserDao;

public class RequestFriendAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_idx = Integer.parseInt(request.getParameter("u_idx"));
		int v_idx = Integer.parseInt(request.getParameter("v_idx"));

		GuguUserDao dao = GuguUserDao.getInstance();
		
		String v_name = dao.getName(v_idx);
		
		request.setAttribute("u_idx", u_idx);
		request.setAttribute("v_idx", v_idx);
		request.setAttribute("v_name", v_name);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect =false;
		forward.url ="requestfriend.jsp";
		
		return forward;
	}

}
