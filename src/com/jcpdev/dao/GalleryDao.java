package com.jcpdev.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.GuguGallery;
import com.jcpdev.mybatis.SqlSessionBean;

public class GalleryDao {
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static GalleryDao dao = new GalleryDao();
	
	private GalleryDao() { }
	public static GalleryDao getInstance() {
		return dao;
	}

	public List<GuguGallery> getList(int u_idx){
		SqlSession mapper = factory.openSession();
		List<GuguGallery> list = mapper.selectList("gallery.getAll",u_idx);
		mapper.close();
		return list;
	}
	
	public void insert(GuguGallery g) {
		SqlSession mapper = factory.openSession();
		mapper.insert("gallery.insert",g);
		mapper.commit();
		mapper.close();
	}

}
