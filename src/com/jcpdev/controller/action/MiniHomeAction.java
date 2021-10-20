package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcpdev.dao.GuguHomeDao;
import com.jcpdev.dao.GuguMateDao;
import com.jcpdev.dao.GuguUserDao;
import com.jcpdev.dto.GuguHome;
import com.jcpdev.dto.Mate;

public class MiniHomeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_idx = Integer.parseInt(request.getParameter("u_idx"));
		
		GuguHomeDao dao = GuguHomeDao.getInstance();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("readIdx") !=null){
			StringBuilder readIdx = (StringBuilder)session.getAttribute("readIdx");
			boolean status = readIdx.toString().contains("/"+u_idx+"/");
			if(!status){		
				dao.updateCount(u_idx);
				readIdx.append(u_idx + "/");
			}
		} else{
			StringBuilder readIdx = new StringBuilder("/");
			session.setAttribute("readIdx", readIdx);
		}
		
		if(dao.userhome(u_idx)==null) {
			GuguHome dto =new GuguHome();
			dto.setU_idx(u_idx);
			dao.insert(dto);
		}
		GuguHome dto = dao.userhome(u_idx);

		
		
		
		GuguMateDao mdao = GuguMateDao.getInstance();
		int count = mdao.mateCount(u_idx);
		
		List<Mate> list = mdao.matelist(u_idx); 
		
		GuguUserDao udao = GuguUserDao.getInstance();
		String name = udao.getName(u_idx);
		
		request.setAttribute("name", name);
		request.setAttribute("mlist", list);
		request.setAttribute("homeuser", dto);
		request.setAttribute("count", count);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url = "minihome.jsp";
		return forward;
	}

}
