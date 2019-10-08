package kr.co.itcen.jblog3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog3.repository.CategoryDao;
import kr.co.itcen.jblog3.vo.UserVo;


@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	

	public void joinFirst(UserVo vo) {
		categoryDao.joinFirst(vo);
	}

}
