package com.javaex.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Controller
public class ApiCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="/{id}/admin/category", method=RequestMethod.GET)
	public String go(@PathVariable String id,
					Model model		) {
		BlogVo blogvo=categoryService.getbloginfo(id);
		model.addAttribute("blogvo",blogvo);
		return "blog/admin/blog-admin-cate";
	} 
	
	@ResponseBody
	@RequestMapping(value="/{id}/admin/category/list", method=RequestMethod.GET)
	public List<CategoryVo> go_category(@PathVariable String id
							) {
		List<CategoryVo> list=categoryService.getcategory(id);
		return list;
	} 
	@ResponseBody
	@RequestMapping(value="/{id}/admin/addcategory", method=RequestMethod.POST)
	public CategoryVo addcategory(@ModelAttribute CategoryVo categoryvo,
							Model model) {
		CategoryVo cate=categoryService.addcategory(categoryvo);
		return cate;
		
	} 
	@ResponseBody
	@RequestMapping(value="/{id}/admin/del", method=RequestMethod.GET)
	public int del(@RequestParam("cateNo") int cateNo) {
		
		return categoryService.delete(cateNo);
	}
	

}