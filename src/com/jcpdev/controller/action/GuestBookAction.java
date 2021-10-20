package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GuestBookDao;
import com.jcpdev.dto.GuestBook;

public class GuestBookAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("u_idx"));
		
		List<GuestBook> list =null;
		
		GuestBookDao dao = GuestBookDao.getInstance();
		list = dao.getList(idx);
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="guestbook/guestbook.jsp";
		
		
		return forward;
	}

}
