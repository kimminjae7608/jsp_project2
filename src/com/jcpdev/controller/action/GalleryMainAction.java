package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GalleryDao;
import com.jcpdev.dto.GuguGallery;

public class GalleryMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int u_idx = Integer.parseInt(request.getParameter("idx")); //유저의 idx
	
		GalleryDao gdao = GalleryDao.getInstance();		
		List<GuguGallery> list = gdao.getList(u_idx);
		request.setAttribute("glist", list); 
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="gallery/gallery.jsp";
		return forward;
	}

}
