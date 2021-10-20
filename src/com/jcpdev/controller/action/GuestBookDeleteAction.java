package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcpdev.dao.GuestBookDao;
import com.jcpdev.dao.GuguMateDao;
import com.jcpdev.dto.GuestBook;
import com.jcpdev.dto.Mate;
import com.jcpdev.dto.SessionDto;

public class GuestBookDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int idx = Integer.parseInt(request.getParameter("idx"));
		
		
		GuestBookDao dao = GuestBookDao.getInstance();
		dao.delete(idx);
		
		HttpSession session = request.getSession();
		
		SessionDto user = (SessionDto)session.getAttribute("user");
		int u_idx = user.getIdx();
		System.out.println(u_idx);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = true;
		forward.url ="guestbook.do?u_idx="+u_idx;
		
		return forward;
	}

}
