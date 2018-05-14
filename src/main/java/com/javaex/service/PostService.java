package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;
@Service
public class PostService {
	@Autowired
	private PostDao postdao;
	
	public void makepost(PostVo postvo) {
		postdao.insert(postvo);
		
	}
	
}
