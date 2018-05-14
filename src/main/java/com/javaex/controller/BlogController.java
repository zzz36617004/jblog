package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.PostService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private PostService postService;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String go_blog(@PathVariable String id,
						@RequestParam(value="cateNo",defaultValue="0") int cateNo ,
						@RequestParam(value="postNo",defaultValue="0") int postNo,
							Model model) {
		BlogVo blogvo=blogService.getbloginfo(id);
		Map<String,Object> map=blogService.getmainbloginfo(id,cateNo,postNo);
		model.addAttribute("cN",cateNo);
		model.addAttribute("pN",postNo);
		//session.setAttribute("map",map);
		model.addAttribute("blogvo",blogvo);
		model.addAttribute("map",map);
		return "blog/blog-main";
	} 
	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.GET)
	public String go_modify(@PathVariable String id,
						Model model) {
		BlogVo blogvo=blogService.getbloginfo(id);
		model.addAttribute("blogvo",blogvo);
		System.out.println(blogvo.toString());
		return "blog/admin/blog-admin-basic";
	} 
	@RequestMapping(value="/{id}/modify", method=RequestMethod.POST)
	public String modify(@PathVariable String id,
						@RequestParam("blogTitle") String blogTitle,
						@RequestParam("file") MultipartFile file,
							Model model) {
		BlogVo blogvo=blogService.getbloginfo(id);
		model.addAttribute("blogvo",blogvo);
		blogService.modify(id,blogTitle,file);
		return "redirect:/"+id+"/admin/basic";
	} 
	
	
	@RequestMapping(value="/{id}/admin/write", method=RequestMethod.GET)
	public String write(@PathVariable String id,
						Model model) {
		BlogVo blogvo=blogService.getbloginfo(id);
		model.addAttribute("blogvo",blogvo);
		List<CategoryVo> catelist=blogService.getwriteinfo(id);
		model.addAttribute("catelist",catelist);
		return "blog/admin/blog-admin-write";
	} 
	
	@RequestMapping(value="/{id}/admin/realwrite", method=RequestMethod.POST)
	public String realwrite(@PathVariable String id,
						@RequestParam("cateNo") int cateNo,
						@RequestParam("postTitle") String postTitle,
						@RequestParam("postContent") String postContent,
						Model model) {
		BlogVo blogvo=blogService.getbloginfo(id);
		model.addAttribute("blogvo",blogvo);
		PostVo postvo=new PostVo(cateNo,postTitle,postContent);
		postService.makepost(postvo);
		return "redirect:/"+id+"/admin/write";
	} 
	
	
	
}
