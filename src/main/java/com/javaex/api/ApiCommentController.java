package com.javaex.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.service.CommentsService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.CommentsVo;

@Controller
public class ApiCommentController {
	@Autowired
	private CommentsService commentsService;
	

	@ResponseBody
	@RequestMapping(value="/{id}/commentslist", method=RequestMethod.GET)
	public List<CommentsVo> go_category(@PathVariable String id,
								CommentsVo commentvo) {
		List<CommentsVo> list=commentsService.getcomments(commentvo);
		return list;
	} 
	@ResponseBody
	@RequestMapping(value="/{id}/admin/addcomment", method=RequestMethod.POST)
	public CommentsVo addcategory(@ModelAttribute CommentsVo commentvo,
							Model model) {
		CommentsVo comment=commentsService.add(commentvo);
		return comment;
		
	} 
	@ResponseBody
	@RequestMapping(value="/{id}/admin/delcomment", method=RequestMethod.GET)
	public int del(@RequestParam("cmtNo") int cmtNo) {
		
		return commentsService.delete(cmtNo);
	}
}
