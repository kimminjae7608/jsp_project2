package com.jcpdev.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.GuestBook;
import com.jcpdev.mybatis.SqlSessionBean;

public class GuestBookDao {
	private static GuestBookDao dao = new GuestBookDao();
	
	private GuestBookDao() {}
	
	public static GuestBookDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory(); 
	
	public List<GuestBook> getList(int idx){
		SqlSession mapper = factory.openSession();
		List<GuestBook> list = mapper.selectList("guestbook.getlist", idx);
		mapper.close();
		return list;
	}
	
	public void insert(GuestBook guestbook) {
		SqlSession mapper = factory.openSession();
		mapper.insert("guestbook.insert", guestbook);
		mapper.commit();
		mapper.close();
	}
	
	public void delete(int idx) {
		SqlSession mapper = factory.openSession();
		mapper.delete("guestbook.delete", idx);
		mapper.commit();
		mapper.close();
	}
	
	
	
}
