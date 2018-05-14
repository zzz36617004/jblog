package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.FileVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserDao userDao;
	
	public Map<String,Object> getmainbloginfo(String id,int cateNo,int postNo) {
		 Map<String,Object> map=new HashMap<String,Object>();
		 BlogVo blogvo=blogDao.getbloginfo(id);
		 List<CategoryVo> catelist=categoryDao.getcategory(id);
		 UserVo uservo=userDao.getUser(id);
		 if(cateNo==0) {
			 cateNo=catelist.get(0).getCateNo();
		 }
		 
		 List<PostVo> postlist=postDao.getpost(cateNo);
		 PostVo result=null;
		 if(postNo==0&&postlist.size()==0) {
			map.put("emptys", 1);
		 }else if(postNo==0) {
			 postNo=postlist.get(0).getPostNo();
		 }
		 for(PostVo vo : postlist) {
			 if(vo.getPostNo()==postNo) {
				 result=vo; 
			 }
		 }
		 map.put("postNo",postNo);
		 map.put("cateNo",cateNo);
		 map.put("uservo",uservo);
		 map.put("blogvo", blogvo);
		 map.put("catelist", catelist);
		 map.put("postlist", postlist);
		 map.put("post", result);
		 return map;
	}
	
	public void modify(String id,String title, MultipartFile file) {
		String saveDir="D:\\javaStudy\\upload";
		String orgName=file.getOriginalFilename(); 
		System.out.println(orgName+"!!");
		String filename="";
		if("".equals(orgName)) {
			filename=null;
		}
		else {
		String exName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		filename=id+"_logo"+exName;
		
		System.out.println(filename);
		
		try {
			byte[] fileData=file.getBytes();
			OutputStream out=new FileOutputStream(saveDir+"/"+filename);
			BufferedOutputStream bout=new BufferedOutputStream(out);
			bout.write(fileData);
			if(bout!=null) {
				bout.close();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		}
		blogDao.modify(id,title,filename);
	}
	public BlogVo getbloginfo(String id) {
		 return blogDao.getbloginfo(id);
	}
	public List<CategoryVo> getwriteinfo(String id) {
		List<CategoryVo> catelist =categoryDao.getcategory(id);
		return catelist;
	}
	
}
