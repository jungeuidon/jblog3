package kr.co.itcen.jblog3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog3.repository.BlogDao;
import kr.co.itcen.jblog3.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	BlogDao blogDao;

	public void join(UserVo vo) {

		blogDao.insert(vo);
	}

}
