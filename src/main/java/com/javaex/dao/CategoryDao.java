package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;
@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> getcategory(String id) {
		return sqlSession.selectList("category.getcate",id);
	}
	public int addcategory(CategoryVo categoryvo) {
		 sqlSession.insert("category.addcate",categoryvo);
		 System.out.println(categoryvo.getCateNo());
		 return categoryvo.getCateNo();
	}
	public CategoryVo selectcategory(int cateNo) {
		return sqlSession.selectOne("category.select",cateNo);
	}
	public int postcheck(int cateNo) {
		return sqlSession.selectOne("category.postcheck", cateNo);
	}
	public int delete(int cateNo) {
		return sqlSession.delete("category.delete",cateNo);
	}
}
