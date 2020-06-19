package com.spring.exam.sys.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.exam.sys.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public User getUserById(String id) {
		return sqlSession.selectOne("SystemMapper.selectUser", id);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SystemMapper.selectUsers");
	}
}
