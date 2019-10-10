package kr.co.itcen.jblog3.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog3.repository.BlogDao;
import kr.co.itcen.jblog3.repository.CategoryDao;
import kr.co.itcen.jblog3.vo.CategoryVo;
import kr.co.itcen.jblog3.vo.PostVo;
import kr.co.itcen.jblog3.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	BlogDao blogDao;

	@Autowired
	CategoryDao categoryDao;
	
	//회원가입시 블로그생성
	public void join(UserVo vo) {

		blogDao.insert(vo);
	}
	
//	//카테고리 목록 가져오기
//	public List<CategoryVo> getCategory(String userId) {
//		return categoryDao.getCategory(userId);
//	}

	//글쓰기
	public void insertPost(PostVo postVo) {
		
		blogDao.insertPost(postVo);
	}

//	public Map<String, Object> getCatePost(Long categoryNo, Long postNo) {
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("", blogDao.);
//		
//		
//		return null;
//	}
	
	

}
