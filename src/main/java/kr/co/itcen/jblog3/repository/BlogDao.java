package kr.co.itcen.jblog3.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog3.vo.BlogVo;
import kr.co.itcen.jblog3.vo.PostVo;
import kr.co.itcen.jblog3.vo.UserVo;

@Repository
public class BlogDao {

	@Autowired
	SqlSession sqlSession;
	
	public Boolean insert(UserVo vo) {
		
		int cnt = sqlSession.insert("post.insert", vo);
		
		return cnt ==1;
	}
	
	public BlogVo getVo(String userId) {
		BlogVo vo = sqlSession.selectOne("blog.getBlog", userId);
		return vo;
	}

}
