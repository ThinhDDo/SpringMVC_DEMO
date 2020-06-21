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
		return sqlSession.selectList("SystemMapper.selectUsers");
	}

	@Override
	public void addUser(User user) {
		sqlSession.insert("SystemMapper.insertUser", user);
	}

	@Override
	public void deleteUser(String id) {
		sqlSession.delete("SystemMapper.deleteUser", id);
	}

	@Override
	public void updateUser(User user) {
		sqlSession.update("SystemMapper.updateUser", user);
	}

	@Override
	public List<User> getUsersByName(String name) {
		return sqlSession.selectList("SystemMapper.selectUsersByName", name);
	}
}
