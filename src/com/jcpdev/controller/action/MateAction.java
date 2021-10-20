package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jcpdev.dao.GuguMateDao;
import com.jcpdev.dto.GuguUser;
import com.jcpdev.dto.Mate;

public class MateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_idx = Integer.parseInt(request.getParameter("u_idx"));
		
		GuguMateDao mdao = GuguMateDao.getInstance();
		List<Mate> matelist =mdao.matelist(u_idx);
		List<GuguUser> addmate =mdao.addMate(u_idx);
		List<GuguUser> waitingmate =mdao.waitingMate(u_idx);
		List<GuguUser> randommate =mdao.randomMate(u_idx);
		
		request.setAttribute("matelist", matelist);
		request.setAttribute("addmate", addmate);
		request.setAttribute("waitingmate", waitingmate);
		request.setAttribute("randommate", randommate);
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url = "mate.jsp";
		
		return forward;
	}

}
