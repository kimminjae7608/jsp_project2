package com.jcpdev.dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.GuguUser;
import com.jcpdev.dto.SessionDto;
import com.jcpdev.dto.TotalProfile;
import com.jcpdev.mybatis.SqlSessionBean;

public class GuguUserDao {
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static GuguUserDao dao = new GuguUserDao();
	
	private GuguUserDao() { }
	public static GuguUserDao getInstance() {
		return dao;
	}

	public void insert(GuguUser dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("guguUser.insert", dto);    
		mapper.commit();
		mapper.close();
	}
	
	public SessionDto login(Map<String, String> map) {
		SessionDto dto = null;
		SqlSession mapper= factory.openSession();
		dto = mapper.selectOne("guguUser.loginCheck",map);
		mapper.close();
		return dto;
	}
	
	public String lookForPW(Map<String, String> map) {
		String password = null;
		SqlSession mapper= factory.openSession();
		password = mapper.selectOne("guguUser.lookForPW",map);
		mapper.close();
		return password;
	}
	
	public String lookForEmail(Map<String, String> map) {
		String email = null;
		SqlSession mapper= factory.openSession();
		email = mapper.selectOne("guguUser.lookForEmail",map);
		mapper.close();
		return email;
	}
	
	public String getName(int idx) {
		SqlSession mapper = factory.openSession();
		String name = mapper.selectOne("getname",idx);
		mapper.close();
		return name;
	}
	
	
	public TotalProfile getOne(int idx) {
		SqlSession mapper = factory.openSession();
		TotalProfile dto = mapper.selectOne("guguUser.selectByIdx", idx);  
		mapper.close();
		return dto;
	}
	
	public void update(GuguUser dto) {
		SqlSession mapper = factory.openSession();
		mapper.update("guguUser.update",dto);
		mapper.commit();
		mapper.close();		
	}
	
	
	
	/*
	 * public SessionDto login(Map<String, String> map) { SessionDto dto = null;
	 * SqlSession mapper= factory.openSession(); dto =
	 * mapper.selectOne("loginCheck",map); return dto; }
	 */
}
