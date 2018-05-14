package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;
import com.javaex.vo.CommentsVo;

@Repository
public class CommentsDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CommentsVo> getlist(CommentsVo commentvo) {
		System.out.println(commentvo.toString());
		List<CommentsVo> vo= sqlSession.selectList("comment.getlist", commentvo);
		System.out.println(vo);
		return vo;
		
	}
	public int addcomment(CommentsVo commentvo) {
		 sqlSession.insert("comment.insert",commentvo);
		 System.out.println(commentvo.toString());
		 return commentvo.getCmtNo();
	}
	public CommentsVo selectcomment(int cmtNo) {
		return sqlSession.selectOne("comment.select",cmtNo);
	}
	public int delete(int cmtNo) {
		return sqlSession.delete("comment.delete",cmtNo);
	}
}
