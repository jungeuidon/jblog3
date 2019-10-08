package kr.co.itcen.jblog3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

	
	@RequestMapping("") // 회원 아이디 추가해서 넣기.
	public String main() {
		return "blog/blog-main";
	}
	
	@RequestMapping("/manage")
	public String manage() {
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/category")
	public String category() {
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "blog/blog-admin-write";
	}
	
	
	
}
