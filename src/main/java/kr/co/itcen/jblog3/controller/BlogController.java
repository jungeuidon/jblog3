package kr.co.itcen.jblog3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.itcen.jblog3.security.AuthUser;
import kr.co.itcen.jblog3.service.BlogService;
import kr.co.itcen.jblog3.service.CategoryService;
import kr.co.itcen.jblog3.vo.CategoryVo;
import kr.co.itcen.jblog3.vo.PostVo;
import kr.co.itcen.jblog3.vo.UserVo;

@Controller
@RequestMapping("/{userId:(?!assets).*}")
public class BlogController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping("") // 회원 아이디 추가해서 넣기.
	public String main() {
		return "blog/blog-main";
	}
	
	//블로그 manage로 이동
	@RequestMapping("/manage")
	public String manage() {
		return "blog/blog-admin-basic";
	}
	
	//카테고리폼으로 이동
	@RequestMapping("/category")
	public String category(@AuthUser UserVo authUser,
						   @PathVariable(value="userId") String userId,
						   @ModelAttribute CategoryVo categoryVo,
						   Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(categoryService.categoryInfo(userId));
		model.addAllAttributes(map);
		
		return "blog/blog-admin-category";
	}
	
	//카테고리 생성
	@RequestMapping(value="/categoryInsert", method=RequestMethod.POST)
	public String categoryInsert(@AuthUser UserVo authUser,
								   @PathVariable(value="userId") String userId,
								   @ModelAttribute CategoryVo categoryVo,
								   Model model) {
		
		categoryVo.setId(userId);
		categoryService.categoryInsert(categoryVo);
		return "redirect:/"+ userId  +"/category";
	}
	
	//글쓰기폼으로 이동
	@RequestMapping("/write")
	public String write(@AuthUser UserVo authUser,
						@PathVariable(value="userId") String userId,
						@ModelAttribute PostVo postVo,
						Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.putAll(categoryService.categoryInfo(userId));
		model.addAllAttributes(map);
		
		return "blog/blog-admin-write";
	}
	
	//글쓰기 
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String blogWrite(@AuthUser UserVo authUser,
						@PathVariable(value="userId") String userId,
						@ModelAttribute @Valid PostVo postVo,
						Model model) {
		System.out.println("쓰기컨트롤러");
		blogService.insertPost(postVo);
		
		return "redirect:/" + userId;
	}
	
	
}
