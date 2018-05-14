package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;
@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<PostVo> getpost(int cateNo){
		return sqlSession.selectList("post.getpost",cateNo);
	}
	public void insert(PostVo postvo) {
	 sqlSession.insert("post.insert",postvo);
	}
}
