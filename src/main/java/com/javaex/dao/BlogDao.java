package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;


@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	public BlogVo getbloginfo(String id) {
		return sqlSession.selectOne("blog.bloginfo",id);
	}
	public void modify(String id,String title,String file) {
		Map<String,String> map=new HashMap<String, String>();
		System.out.println(id+" "+title+" "+file);
		map.put("id",id);
		map.put("blogTitle",title);
		map.put("logoFile",file);
		sqlSession.update("blog.modify",map);
	}
}
