package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
@Autowired
	private SqlSession sqlSession;
public int makeblog(UserVo userVo) {
	Map<String, String> map = new HashMap<String,String>();
	map.put("id", userVo.getId());
	map.put("blogtitle", userVo.getId()+"의 블로그  입니다.");
	map.put("logoFile", "spring-logo.jpg");
	return sqlSession.insert("user.makeblog",map);
}

public int insert(UserVo userVo) {
		return sqlSession.insert("user.insert",userVo);
	}
public UserVo getUser(String id,String password) {
	Map<String, String> map = new HashMap<String,String>();
	map.put("id", id);
	map.put("password", password);
	return sqlSession.selectOne("user.selectUserByEmailPw",map);
}
public UserVo getUser(String id) {
	return sqlSession.selectOne("user.selectUserByid",id);
}
public UserVo check(String id) {
	return sqlSession.selectOne("user.check", id);
}
}