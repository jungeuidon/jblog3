package kr.co.itcen.jblog3.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog3.vo.PostVo;
import kr.co.itcen.jblog3.vo.UserVo;

@Repository
public class BlogDao {

	@Autowired
	SqlSession sqlSession;
	
	public Boolean insert(UserVo vo) {
		
		int cnt = sqlSession.insert("blog.insert", vo);
		
		return cnt ==1;
	}

	public Boolean insertPost(PostVo postVo) {
		System.out.println("포스트 쓰기");
		
		int cnt = sqlSession.insert("blog.insertPost", postVo);
		
		return cnt ==1;
	}

}
