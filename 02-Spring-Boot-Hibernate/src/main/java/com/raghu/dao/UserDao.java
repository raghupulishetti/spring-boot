package com.raghu.dao;

import java.util.List;

import com.raghu.entity.User;

public interface UserDao {
	public long createUser(User user);

	public User getUser(long userId);

	public List<User> getUsers();

	public int updateUserProfile(User user);

	public int deleteUser(long userId);

}
