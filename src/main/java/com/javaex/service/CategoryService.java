package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private BlogDao blogDao;
	
	public List<CategoryVo> getcategory(String id) {
		 return categoryDao.getcategory(id);
	}
	public BlogVo getbloginfo(String id) {
		BlogVo blogvo=blogDao.getbloginfo(id);
		 return blogvo;
	}
	public CategoryVo addcategory(CategoryVo categoryvo) {
		 int cateNo = categoryDao.addcategory(categoryvo);
		 return categoryDao.selectcategory(cateNo);
	}


	public int delete(int cateNo) {
		if(categoryDao.postcheck(cateNo)==0) {
		categoryDao.delete(cateNo);
		return cateNo;
		}
		else {
			return 0;
		}
	}
}
