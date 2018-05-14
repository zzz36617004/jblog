package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CategoryDao categoryDao;
	public void join(UserVo userVo) {
		userDao.insert(userVo);
		userDao.makeblog(userVo);
		CategoryVo categoryvo=new CategoryVo(userVo.getId(),"미분류","default");
		categoryDao.addcategory(categoryvo);
	}
	
	public UserVo login(String id,String password) {
		return userDao.getUser(id,password);
	}
	
	public boolean idcheck(String id) {
		System.out.println(userDao.check(id));
		 if( userDao.check(id)!=null) {
			 return true;
		 }else {
			 return false;
		 }
	}
		
}
