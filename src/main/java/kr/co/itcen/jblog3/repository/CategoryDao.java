package kr.co.itcen.jblog3.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog3.vo.UserVo;

@Repository
public class CategoryDao {
	
	@Autowired
	SqlSession sqlSession;

	public Boolean joinFirst(UserVo vo) {
		
		int cnt = sqlSession.insert("category.joinFirst", vo);
		
		return cnt==1;
	}

}
